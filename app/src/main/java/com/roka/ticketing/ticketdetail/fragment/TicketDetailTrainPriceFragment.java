package com.roka.ticketing.ticketdetail.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roka.ticketing.R;
import com.roka.ticketing.bookticket.BookTicketActivity;
import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.payload.train.Schedule;
import com.roka.ticketing.utilities.Gb;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TicketDetailTrainPriceFragment extends Fragment {

    @BindView(R.id.tv_ticket_detail_brand_name)
    TextView mTvBrandName;

    @BindView(R.id.tv_num_of_ticket_adult)
    TextView mTvNumberOfTicketAdult;

    @BindView(R.id.tv_num_of_ticket_infant)
    TextView mTvNumberOfTicketInfant;

    @BindView(R.id.tv_ticket_detail_item_price_adult)
    TextView mTvPriceAdult;

    @BindView(R.id.tv_ticket_detail_item_price_infant)
    TextView mTvPriceInfant;

    @BindView(R.id.tv_ticket_detail_total_price)
    TextView mTvTotalPrice;

    @BindView(R.id.tv_ticket_detail_class)
    TextView mTvClass;

    private Schedule mData = null;
    private Schedule mPayload;

    public static TicketDetailTrainPriceFragment newInstance(Schedule model, Schedule payload) {
        TicketDetailTrainPriceFragment fragment = new TicketDetailTrainPriceFragment();
        fragment.mData = model;
        fragment.mPayload = payload;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ticket_detail_train_price, container, false);

        ButterKnife.bind(this, v);

        initDataToView();

        return v;
    }

    private void initDataToView() {
        int adultPrice = mPayload.getAdult_num() * Integer.parseInt(mData.getAdult_fare());
        int infantPrice = mPayload.getInfant_num() * Integer.parseInt(mData.getInfant_fare());
        int totalPrice = adultPrice + infantPrice;

        mTvNumberOfTicketAdult.setText("Adult (" + mPayload.getAdult_num() + "x)");
        mTvPriceAdult.setText("IDR "+adultPrice);
        mTvNumberOfTicketInfant.setText("Infant (" + mPayload.getInfant_num() + "x)");
        mTvPriceInfant.setText("IDR "+infantPrice);
        mTvTotalPrice.setText("IDR "+totalPrice);

        // Set PassengerClass, Waiting for Enum for V, X, etc
        mTvClass.setText(mData.getKelas());

        mTvBrandName.setText(mData.getTransporter_name());
    }

    @OnClick(R.id.btn_ticketdetail_book_flight)
    public void onBookFlight() {
        Intent intent = new Intent(getActivity(), BookTicketActivity.class);
        intent.putExtra(Gb.INTENT_PAYLOAD_ITEM , mPayload);
        intent.putExtra(Gb.INTENT_GENERAL_MODE , 1);

        startActivity(intent);
    }

}
