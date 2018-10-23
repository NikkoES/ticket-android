package com.roka.ticketing.ticket.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.iconics.view.IconicsImageView;
import com.roka.ticketing.BuildConfig;
import com.roka.ticketing.R;
import com.roka.ticketing.calendar.CalendarActivity;
import com.roka.ticketing.rest.payload.train.Destination;
import com.roka.ticketing.rest.payload.train.Schedule;
import com.roka.ticketing.rest.response.train.StationResponse;
import com.roka.ticketing.rest.services.RestCalls;
import com.roka.ticketing.rest.services.RestTrainServices;
import com.roka.ticketing.ticket.PassengerActivity;
import com.roka.ticketing.ticketlisting.TicketListingActivity;
import com.roka.ticketing.utilities.Gb;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by roka on 20/02/18.
 */

public class TrainTicketFragment extends Fragment
        implements CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener{

    @BindView(R.id.sw_round_trip)
    SwitchCompat mSwRoundTrip;

    @BindView(R.id.rl_ticket_plane_return_date)
    RelativeLayout mRlReturnDate;

    @BindView(R.id.tv_train_passenger)
    TextView mTvPassenger;

    @BindView(R.id.sp_train_select_destination)
    AppCompatSpinner mSpDestination;

    @BindView(R.id.sp_train_select_origin)
    AppCompatSpinner mSpOrigin;

    @BindView(R.id.iiv_swap)
    IconicsImageView mIivSwap;

    @BindView(R.id.tv_train_select_origin_date)
    TextView mTvOriginDate;

    @BindView(R.id.tv_train_select_return_date)
    TextView mTvReturnDate;

    private int mAdultNum = 1;
    private int mChildNum, mInfantNum = 0;

    private ArrayAdapter<String> mAdapter = null;
    private int mSelectedOriginPosition = 50, mSelectedDestinationPosition = 5;
    private List<Destination> stationResponses = new ArrayList<>();
    private List<String> listStation = new ArrayList<>();
    private String mDepartureDate, mReturnDate;
    private SharedPreferences mPref;

    private static final int ORIGIN_SPINNER = 0;
    private static final int DESTINATION_SPINNER = 1;

    private RestCalls mServices = null;

    public static TrainTicketFragment newInstance() {
        TrainTicketFragment fragment = new TrainTicketFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ticket_train, container, false);
        ButterKnife.bind(this, v);

        mServices = RestTrainServices.getService();

        mSwRoundTrip.setOnCheckedChangeListener(this);
        initSpinners();

        mPref = getActivity().getSharedPreferences(Gb.PREF_NAME, Context.MODE_PRIVATE);
        mPref.edit().putInt(Gb.PREF_ADULT_NUM, 1).commit();
        mPref.edit().putInt(Gb.PREF_CHILD_NUM, 0).commit();
        mPref.edit().putInt(Gb.PREF_INFANT_NUM, 0).commit();
        clearInputPassenger();
        return v;
    }

    private void initSpinners() {
        Call<StationResponse> call = mServices.getStation(BuildConfig.API_TRAIN_TOKEN);
        call.enqueue(new Callback<StationResponse>() {
            @Override
            public void onResponse(Call<StationResponse> call, Response<StationResponse> response) {
                if (response.code() == 200) {
                    stationResponses = response.body().getResult().getDestination();
                    for(int i=0;i<stationResponses.size();i++){
                        String namaStasiun = stationResponses.get(i).getName().substring(0,1)
                                + stationResponses.get(i).getName().substring(1).toLowerCase();
                        listStation.add("Stasiun "+namaStasiun+" ("+stationResponses.get(i).getCode()+")");
                    }

                    mAdapter = new ArrayAdapter<String>(getContext(), R.layout.support_simple_spinner_dropdown_item, listStation);
                    mSpDestination.setAdapter(mAdapter);
                    mSpOrigin.setAdapter(mAdapter);

                    mAdapter.notifyDataSetChanged();

                    setStation(stationResponses);

                    mSpOrigin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                            int tag = (int) adapterView.getTag();
                            switch (tag) {
                                case DESTINATION_SPINNER :
                                    mSelectedDestinationPosition = position;
                                    setDestination(position);
                                    break;
                                case ORIGIN_SPINNER :
                                    mSelectedOriginPosition = position;
                                    setOrigin(position);
                                    break;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    mSpOrigin.setSelection(mSelectedOriginPosition);
                    mSpOrigin.setTag(ORIGIN_SPINNER);

                    mSpDestination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                            int tag = (int) adapterView.getTag();
                            switch (tag) {
                                case DESTINATION_SPINNER :
                                    mSelectedDestinationPosition = position;
                                    setDestination(position);
                                    break;
                                case ORIGIN_SPINNER :
                                    mSelectedOriginPosition = position;
                                    setOrigin(position);
                                    break;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    mSpDestination.setSelection(mSelectedDestinationPosition);
                    mSpDestination.setTag(DESTINATION_SPINNER);

                } else {
                    Toast.makeText(getContext(), "No Lion Data Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<StationResponse> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.toString(), Toast.LENGTH_SHORT).show();
//                Log.e("ASDF", "" + t.toString());

            }
        });
    }

    public void setDestination(int position){
        mSelectedDestinationPosition = position;
    }

    public void setOrigin(int position){
        mSelectedOriginPosition = position;
    }

    public void setStation(List<Destination> responseStation){
        stationResponses = responseStation;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b) mRlReturnDate.setVisibility(View.VISIBLE);
        else mRlReturnDate.setVisibility(View.GONE);
    }

    @OnClick(R.id.tv_train_passenger)
    public void onPassengerClicked() {
        Intent intent = new Intent(getActivity(), PassengerActivity.class);

        intent.putExtra(Gb.INTENT_KODE_PASSENGER, "train");
        intent.putExtra(Gb.INTENT_PASSENGER_ADULT, mAdultNum);
        intent.putExtra(Gb.INTENT_PASSENGER_CHILD, mChildNum);
        intent.putExtra(Gb.INTENT_PASSENGER_INFANT, mInfantNum);

        startActivityForResult(intent, Gb.PASSENGER_SELECT);
    }

    @OnClick(R.id.iiv_swap)
    public void swapDestination() {
        int temp = mSelectedDestinationPosition;
        mSelectedDestinationPosition = mSelectedOriginPosition;
        mSelectedOriginPosition = temp;

        mSpDestination.setSelection(mSelectedDestinationPosition);
        mSpOrigin.setSelection(mSelectedOriginPosition);
    }

    @OnClick(R.id.ll_plane_origin_date)
    public void onOriginDate() {
        Intent intent = new Intent(getActivity(), CalendarActivity.class);
        intent.putExtra(Gb.INTENT_IS_RANGE_SELECTION, false);
        intent.putExtra(Gb.INTENT_TITLE, "Select Departure Date");

        startActivityForResult(intent, Gb.DEPARTURE_DATE);
    }

    @OnClick(R.id.ll_plane_return_date)
    public void onDestinationDate() {
        Intent intent = new Intent(getActivity(), CalendarActivity.class);
        intent.putExtra(Gb.INTENT_IS_RANGE_SELECTION, false);
        intent.putExtra(Gb.INTENT_TITLE, "Select Return Date");

        startActivityForResult(intent, Gb.ARRIVAL_DATE);
    }

    @OnClick(R.id.btn_train_search)
    public void onSearch() {
        String dest = stationResponses.get(mSelectedDestinationPosition).getCode();
        String origin = stationResponses.get(mSelectedOriginPosition).getCode();

        Schedule.Builder builder = new Schedule.Builder(mAdultNum, mInfantNum)
                .withOrigin(origin)
                .withDestination(dest)
                .withDepartureDate(mDepartureDate)
                .withReturnStatus(mSwRoundTrip.isChecked() ? "Yes" : "No");

        if(mDepartureDate != null && mDepartureDate.length() > 0) builder.withDepartureDate(mDepartureDate);
        if(mReturnDate != null && mReturnDate.length() > 0) builder.withReturnDate(mReturnDate);

        Schedule body = builder.build();

        Intent intent = new Intent(getActivity(), TicketListingActivity.class);
        intent.putExtra(Gb.INTENT_GENERAL_MODE, 1);
        intent.putExtra(Gb.INTENT_GENERAL_BODY, body);
        intent.putExtra(Gb.INTENT_GENERAL_DEST, dest);
        intent.putExtra(Gb.INTENT_GENERAL_ORI, origin);
        intent.putExtra(Gb.INTENT_GENERAL_DEPART_DATE, mDepartureDate);

        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Gb.PASSENGER_SELECT) {
            if(resultCode == getActivity().RESULT_OK) {
                mAdultNum = data.getIntExtra(Gb.INTENT_PASSENGER_ADULT,0);
                mChildNum = data.getIntExtra(Gb.INTENT_PASSENGER_CHILD, 0);
                mInfantNum = data.getIntExtra(Gb.INTENT_PASSENGER_INFANT, 0);

                String passengerText = mAdultNum + " Adult";
                if(mChildNum > 0) {
                    passengerText  = passengerText  + ", " + mChildNum + " Child";
                } else if (mChildNum > 1) {
                    passengerText  = passengerText + ", " + mChildNum + " Children";
                }

                if(mInfantNum > 0) {
                    passengerText  = passengerText  + ", " + mInfantNum + " Infant";
                } else if (mChildNum > 1) {
                    passengerText  = passengerText + ", " + mInfantNum + " Infants";
                }

                mPref.edit().putInt(Gb.PREF_ADULT_NUM, mAdultNum).commit();
                mPref.edit().putInt(Gb.PREF_CHILD_NUM, mChildNum).commit();
                mPref.edit().putInt(Gb.PREF_INFANT_NUM, mInfantNum).commit();

                clearInputPassenger();

                mTvPassenger.setText(passengerText);
            }
        } else if(requestCode == Gb.DEPARTURE_DATE){
            if(resultCode == getActivity().RESULT_OK) {
                mDepartureDate = data.getStringExtra(Gb.REQ_CALENDAR_RESULT);
                mTvOriginDate.setText(mDepartureDate);
            }
        }

        else if(requestCode == Gb.ARRIVAL_DATE){
            if(resultCode == getActivity().RESULT_OK) {
                mReturnDate = data.getStringExtra(Gb.REQ_CALENDAR_RESULT);
                mTvReturnDate.setText(mReturnDate);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void clearInputPassenger() {
        for(int i=0; i<mAdultNum; i++)
            mPref.edit().putString(i+"_ADULT","").commit();
        for(int i=0; i<mChildNum; i++)
            mPref.edit().putString(i+"_CHILD","").commit();
        for(int i=0; i<mInfantNum; i++)
            mPref.edit().putString(i+"_INFANT","").commit();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int tag = (int) adapterView.getTag();
        switch (tag) {
            case DESTINATION_SPINNER :
                mSelectedDestinationPosition = i;
                break;
            case ORIGIN_SPINNER :
                mSelectedOriginPosition = i;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
