package com.roka.ticketing.ticketlisting.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.roka.ticketing.BuildConfig;
import com.roka.ticketing.R;
import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.payload.train.Schedule;
import com.roka.ticketing.rest.response.train.StationResponse;
import com.roka.ticketing.rest.services.RestCalls;
import com.roka.ticketing.rest.services.RestTrainServices;
import com.roka.ticketing.ticketlisting.adapter.TrainTicketListingAdapter;
import com.roka.ticketing.ticketlisting.interfaces.TicketListingInterface;
import com.roka.ticketing.utilities.Gb;
import com.roka.ticketing.utilities.StringUtilities;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by roka on 23/02/18.
 */

public class TicketListingTrainFragment extends Fragment {
    @BindView(R.id.rv_train_ticket_listing)
    RecyclerView mRvTrainTicketListing;

    @BindView(R.id.pb_loading_bar)
    ProgressBar mPbProgress;

    private static final int TOTAL_PROGRESS = 3;
    private int currentProgress = 0;

    private TicketListingInterface mCallback = null;
    private TrainTicketListingAdapter mAdapter = null;
    private Schedule mBody = null;

    private RestCalls mServices = null;
    private List<Schedule> mData = new ArrayList<>();

    private MaterialDialog mDialog = null;
    private SharedPreferences mPref = null;

    public static TicketListingTrainFragment newInstance(TicketListingInterface callback, Schedule body) {
        TicketListingTrainFragment fragment = new TicketListingTrainFragment();
        fragment.mCallback = callback;
        fragment.mBody = body;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ticket_listing_train, container, false);
        ButterKnife.bind(this,v);
        initRecyclerView();

        mServices = RestTrainServices.getService();
        mPref = getActivity().getSharedPreferences(Gb.PREF_NAME, Context.MODE_PRIVATE);
        initProgress();
        searchTicket();
        return v;
    }

    private void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mAdapter = new TrainTicketListingAdapter(mCallback, mData, mBody);
        mRvTrainTicketListing.setAdapter(mAdapter);
        mRvTrainTicketListing.setLayoutManager(manager);
        mAdapter.notifyDataSetChanged();
    }

    private void searchTicket() {
        mDialog = new MaterialDialog.Builder(getContext())
                .cancelable(false)
                .backgroundColor(getResources().getColor(R.color.white))
                .contentColor(getResources().getColor(R.color.black))
                .content("Please Wait...")
                .build();

        Call<StationResponse> call = mServices.getRailSchedule(BuildConfig.API_TRAIN_TOKEN, mBody.getOrg(), mBody.getDes(), StringUtilities.dateResponseToDate(mBody.getDep_datetime()), ""+mBody.getAdult_num(), ""+mBody.getInfant_num());
        call.enqueue(new Callback<StationResponse>() {
            @Override
            public void onResponse(Call<StationResponse> call, Response<StationResponse> response) {
                if (response.isSuccessful()){
                    if(!response.body().getResult().getSchedule().toString().equalsIgnoreCase("[]")){
                        mData = response.body().getResult().getSchedule();
                        Log.e("SCHEDULE", ""+mData);

                        mRvTrainTicketListing.setAdapter(new TrainTicketListingAdapter(mCallback, mData, mBody));
                        mAdapter.notifyDataSetChanged();
                        return;
                    }
                    else{
                        Toast.makeText(getContext(), "Schedule kereta tidak ditemukan !", Toast.LENGTH_SHORT).show();
                        getActivity().finish();
                        return;
                    }
                }
                else{
                    Toast.makeText(getContext(), "Failed to Fetch Data !", Toast.LENGTH_SHORT).show();
                }
                addProgress();
            }

            @Override
            public void onFailure(Call<StationResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Errornya " + t.toString(), Toast.LENGTH_SHORT).show();
//                Log.e("ASDF", "" + t.toString());
                addProgress();
            }
        });
    }

    private void initProgress() {
        mData.clear();
        currentProgress = 0;
        mPbProgress.setIndeterminate(true);
        mPbProgress.setVisibility(View.VISIBLE);
    }

    private void addProgress() {
        currentProgress++;
        if (currentProgress == TOTAL_PROGRESS) {
            mPbProgress.setVisibility(View.GONE);
            mCallback.showControlLayout(true);
        }
    }
}
