package com.roka.ticketing.ticketdetail.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.roka.ticketing.R;
import com.roka.ticketing.bookticket.BookTicketActivity;
import com.roka.ticketing.rest.response.CitilinkDetailPriceResponse;
import com.roka.ticketing.rest.response.flight.LionSearchResponse;
import com.roka.ticketing.rest.services.RestCalls;
import com.roka.ticketing.rest.services.RestServices;
import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FlightRouteItem;
import com.roka.ticketing.ticketdetail.adapter.TicketDetailStopsAdapter;
import com.roka.ticketing.utilities.Gb;
import com.roka.ticketing.utilities.StringUtilities;

import java.text.NumberFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by roka on 22/02/18.
 */

public class TicketDetailFlightFragment extends Fragment {
    @BindView(R.id.tv_ticket_detail_brand_name)
    TextView mTvBrandName;

    @BindView(R.id.tv_ticket_detail_price)
    TextView mTvPrice;

    @BindView(R.id.tv_ticket_detail_class)
    TextView mTvClass;

    @BindView(R.id.tv_baggage)
    TextView mTvBaggage;

    @BindView(R.id.iv_ticketdetail_thumb)
    ImageView mIvThumb;

    @BindView(R.id.rv_ticketdetail_stops)
    RecyclerView mRvStops;

    private FlightRouteItem mData = null;
    private LionSearchResponse mLionFlightItem = null;
    private TicketDetailStopsAdapter mAdapter = null;
    private String mTotalDuration;
    private SearchFlightPayload mPayload;
    private int mTypeProvider;

    public static final int TYPE_SRIWIJAYA = 0;
    public static final int TYPE_CITILINK = 1;
    private RestCalls mServices;

    public static TicketDetailFlightFragment newInstance(FlightRouteItem flightRoute, String totalDuration, SearchFlightPayload payload) {
        TicketDetailFlightFragment fragment = new TicketDetailFlightFragment();
        fragment.mData = flightRoute;
        fragment.mTotalDuration = totalDuration;
        fragment.mPayload = payload;
        fragment.mServices = RestServices.getService();

        return fragment;
    }

    public static TicketDetailFlightFragment newInstance(LionSearchResponse flightRoute, SearchFlightPayload payload) {
        TicketDetailFlightFragment fragment = new TicketDetailFlightFragment();
        fragment.mLionFlightItem = flightRoute;
        fragment.mPayload = payload;
        fragment.mTotalDuration = flightRoute.getTotalFlightDuration();
        fragment.mTypeProvider = TYPE_CITILINK;
        fragment.mServices = RestServices.getService();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ticketdetail_flight, container, false);

        ButterKnife.bind(this, v);
        if (mTypeProvider == TYPE_SRIWIJAYA) {
            initDataToView();
        } else if (mTypeProvider == TYPE_CITILINK) {
            mTvPrice.setText("waiting...");
            String citilinkUrl = "https://firebasestorage.googleapis.com/v0/b/ticketapp-pasarprodukbumn.appspot.com/o/logos%2Fcitilink.png?alt=media&token=b1546cf8-1745-4596-a6ee-1d6ac62c8560";
            mTvBaggage.setText("Baggage 30 kg");
            Glide.with(getContext())
                    .load(citilinkUrl)
                    .into(mIvThumb);
            mTvBrandName.setText("Citilink");

            LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            mAdapter = new TicketDetailStopsAdapter(mLionFlightItem.getFlightData(), mPayload.getDepartDate(), mTotalDuration);
            mRvStops.setAdapter(mAdapter);
            mRvStops.setLayoutManager(manager);
            mRvStops.setNestedScrollingEnabled(false);
        }

        return v;
    }

    private void initDataToView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mAdapter = new TicketDetailStopsAdapter(mData.getmSegments().getItem().get(0).getmLegs().getItem(), mTotalDuration);
        mRvStops.setAdapter(mAdapter);
        mRvStops.setLayoutManager(manager);
        mRvStops.setNestedScrollingEnabled(false);

        mTvPrice.setText(StringUtilities.getPriceInCurrency(mData));
        // Set PassengerClass, Waiting for Enum for V, X, etc
        mTvClass.setText(StringUtilities.getFlightCodeAndClass(mData));

        mTvBrandName.setText("Sriwijaya");

    }

    @OnClick(R.id.btn_ticketdetail_book_flight)
    public void onBookFlight() {
        if(mTypeProvider == TYPE_SRIWIJAYA) {
            Intent intent = new Intent(getActivity(), BookTicketActivity.class);
            intent.putExtra(Gb.INTENT_PAYLOAD_ITEM, mPayload);

            startActivity(intent);
        }else if(mTypeProvider == TYPE_CITILINK){

        }

    }

    public void updatePrice(CitilinkDetailPriceResponse detailPrice) {
        String formattedNumber = NumberFormat.getNumberInstance(Locale.ENGLISH).format(detailPrice.getPricePerPerson());
        mTvPrice.setText("IDR " + formattedNumber);
        mTvBaggage.setText("Baggage " + detailPrice.getBaggageWeight());
        mTvClass.setText("Class "+detailPrice.getFlightClass());
    }
}
