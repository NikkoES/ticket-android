package com.roka.ticketing.ticketdetail.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roka.ticketing.R;
import com.roka.ticketing.bookticket.BookTicketActivity;
import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.payload.train.Schedule;
import com.roka.ticketing.utilities.Gb;
import com.roka.ticketing.utilities.StringUtilities;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TicketDetailTrainFragment extends Fragment {

    @BindView(R.id.tv_ticket_detail_brand_name)
    TextView mTvBrandName;

    @BindView(R.id.tv_ticket_detail_price)
    TextView mTvPrice;

    @BindView(R.id.tv_ticket_detail_class)
    TextView mTvClass;

    //Information
    @BindView(R.id.iv_ticketdetail_stops_facilities_landing_date)
    public TextView landingdate;

    @BindView(R.id.iv_ticketdetail_stops_facilities_landing_to)
    public TextView landingto;

    @BindView(R.id.iv_ticketdetail_stops_facilities_duration)
    public TextView duration;

    @BindView(R.id.iv_ticketdetail_stops_facilities_takeoff_date)
    public TextView takeoffdate;

    @BindView(R.id.iv_ticketdetail_stops_facilities_takeoff_from)
    public TextView takeofffrom;

    private Schedule mData = null;
    private Schedule mPayload;

    public static TicketDetailTrainFragment newInstance(Schedule schedule, Schedule payload) {
        TicketDetailTrainFragment fragment = new TicketDetailTrainFragment();
        fragment.mData = schedule;
        fragment.mPayload = payload;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ticket_detail_train, container, false);

        ButterKnife.bind(this,v);
        initDataToView();

        return v;
    }

    private void initDataToView() {
        takeofffrom.setText(mData.getOrg());
        takeoffdate.setText(mData.getDep_datetime());
        landingto.setText(mData.getDes());
        landingdate.setText(mData.getArv_datetime());
        Log.e("DURATION", ""+mData.getDep_datetime());
        duration.setText("Duration ("+StringUtilities.durationTrain(mData.getDep_datetime(), mData.getArv_datetime())+")");

        mTvPrice.setText("IDR "+Integer.parseInt(mData.getAdult_fare()) * mPayload.getAdult_num());
        // Set PassengerClass, Waiting for Enum for V, X, etc
        mTvClass.setText(mData.getKelas());

        mTvBrandName.setText(mData.getTransporter_name());

    }

    @OnClick(R.id.btn_ticketdetail_book_train)
    public void onBookTrain() {
        Intent intent = new Intent(getActivity(), BookTicketActivity.class);
        intent.putExtra(Gb.INTENT_PAYLOAD_ITEM , mPayload);
        intent.putExtra(Gb.INTENT_FLIGHT_ROUTE_ITEM, mData);
        intent.putExtra(Gb.INTENT_GENERAL_MODE , 1);

        startActivity(intent);
    }

}
