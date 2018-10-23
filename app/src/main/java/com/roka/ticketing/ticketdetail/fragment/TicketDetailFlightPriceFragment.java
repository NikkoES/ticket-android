package com.roka.ticketing.ticketdetail.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roka.ticketing.R;
import com.roka.ticketing.bookticket.BookTicketActivity;
import com.roka.ticketing.rest.response.CitilinkDetailPriceResponse;
import com.roka.ticketing.rest.services.RestCalls;
import com.roka.ticketing.rest.services.RestServices;
import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FlightRouteItem;
import com.roka.ticketing.utilities.Gb;
import com.roka.ticketing.utilities.StringUtilities;

import java.text.NumberFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.roka.ticketing.ticketdetail.fragment.TicketDetailFlightFragment.TYPE_CITILINK;
import static com.roka.ticketing.ticketdetail.fragment.TicketDetailFlightFragment.TYPE_SRIWIJAYA;

/**
 * Created by roka on 22/02/18.
 */

public class TicketDetailFlightPriceFragment extends Fragment {
    private RestCalls mServices;

    @BindView(R.id.tv_ticket_detail_brand_name)
    TextView mTvBrandName;

    @BindView(R.id.tv_num_of_ticket)
    TextView mTvNumberOfTicket;

    @BindView(R.id.tv_ticket_detail_item_price)
    TextView mTvPrice;

    @BindView(R.id.tv_ticket_detail_total_price)
    TextView mTvTotalPrice;

    @BindView(R.id.tv_ticket_detail_class)
    TextView mTvClass;

    private FlightRouteItem mData = null;
    private SearchFlightPayload mPayload;
    private int mTypeProvider;

    public static TicketDetailFlightPriceFragment newInstance(FlightRouteItem model, SearchFlightPayload payload) {
        TicketDetailFlightPriceFragment fragment = new TicketDetailFlightPriceFragment();
        fragment.mData = model;
        fragment.mPayload = payload;
        fragment.mTypeProvider = TYPE_SRIWIJAYA;
        fragment.mServices = RestServices.getService();

        return fragment;
    }

    public static com.roka.ticketing.ticketdetail.fragment.TicketDetailFlightPriceFragment newInstance(SearchFlightPayload payload) {
        com.roka.ticketing.ticketdetail.fragment.TicketDetailFlightPriceFragment fragment = new com.roka.ticketing.ticketdetail.fragment.TicketDetailFlightPriceFragment();
        fragment.mPayload = payload;
        fragment.mTypeProvider = TYPE_CITILINK;
        fragment.mServices = RestServices.getService();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ticketdetail_price, container, false);
        ButterKnife.bind(this, v);

        if (mTypeProvider == TYPE_SRIWIJAYA)
            initDataToView();
        else if(mTypeProvider == TYPE_CITILINK)
            initDataToViewCitilink();

        return v;
    }

    private void initDataToViewCitilink() {
        String strPassenger = "";
        if(mPayload.getAdult()>0)
            strPassenger += "Adult (" + mPayload.getAdult() + "x)";
        if(mPayload.getChild()>0)
            strPassenger += ", Child (" + mPayload.getChild() + "x)";

        mTvNumberOfTicket.setText(strPassenger);

        mTvPrice.setText("Waiting...");
        mTvTotalPrice.setText("Waiting...");
        mTvClass.setText("Waiting...");

        mTvBrandName.setText("Citilink");
    }

    private void initDataToView() {
        double totalPrice = StringUtilities.getPriceTotal(mData);
        double singlePrice = StringUtilities.getPrice(mData);
        int numPerson = (int) (totalPrice / singlePrice);
        mTvNumberOfTicket.setText("Adult (" + numPerson + "x)");
        mTvPrice.setText(StringUtilities.getPriceInCurrency(mData));
        mTvTotalPrice.setText(StringUtilities.getPriceTotalInCurrency(mData));

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
            //TODO SELLREQUEST
        }
    }


    public void updatePrice(CitilinkDetailPriceResponse detailPrice) {
        String formattedNumber = NumberFormat.getNumberInstance(Locale.ENGLISH).format(detailPrice.getPricePerPerson());
        String formattedNumberTotal = NumberFormat.getNumberInstance(Locale.ENGLISH).format(detailPrice.getTotalPrice());
        mTvPrice.setText("IDR " + formattedNumber);
        mTvTotalPrice.setText("IDR "+formattedNumberTotal);
        mTvClass.setText("Class "+detailPrice.getFlightClass());
    }
}
