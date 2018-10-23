package com.roka.ticketing.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roka.ticketing.R;
import com.roka.ticketing.home.fragment.BookingListFragment;
import com.roka.ticketing.home.viewholder.BookingViewHolder;
import com.roka.ticketing.rest.response.flight.helperpojo.listbooking.ListBookingResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by roka on 18/04/18.
 */

public class BookingAdapter extends RecyclerView.Adapter<BookingViewHolder> {

    private final List<ListBookingResponse> mData;
    private final BookingListFragment parentFragment;
    private final String[] mAirportList;


    public BookingAdapter(List<ListBookingResponse> mData, BookingListFragment bookingListFragment) {
        this.mData = mData;
        this.parentFragment = bookingListFragment;
        mAirportList = bookingListFragment.getResources().getStringArray(R.array.airport_name);
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_booking, parent, false);

        return new BookingViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {
        ListBookingResponse item = mData.get(position);

        //set rute
        String rute = item.getYourItineraryDetails().getItineraryDetails()
                .getJourney().getItem().getSegment().getItem().get(0).getCityFromName().getValue();
        rute += " - ";
        rute += item.getYourItineraryDetails().getItineraryDetails()
                .getJourney().getItem().getSegment().getItem().get(0).getCityToName().getValue();
        holder.tv_rute.setText(rute);

        //set booking code
        String bookingCode = item.getBookingCode().getValue();
        holder.tv_booking_code.setText("Booking Code : " + bookingCode);

        //set waktu berangkat
        String strDateFlown = item.getYourItineraryDetails().getItineraryDetails()
                .getJourney().getItem().getSegment().getItem().get(0).getFlownDate().getValue();
        String strTimeFlown = item.getYourItineraryDetails().getItineraryDetails()
                .getJourney().getItem().getSegment().getItem().get(0).getStdLT().getValue()
                .replace(" LT", "");
        String strFlown = strDateFlown + " " + strTimeFlown;
        Log.d("faruk", "faruk strFlown = "+strFlown);
        String inputPattern = "dd-MMM-yy HH:mm";
        String outputPattern = "EEE, dd MMM yyyy HH:mm";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern, Locale.US);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern, Locale.US);
        Date dateFlown = null;
        try {
            dateFlown = inputFormat.parse(strFlown);
        } catch (ParseException e) {
            e.printStackTrace();
            Log.d("faruk", "error = "+e.getMessage());
        }

        if(dateFlown != null){
            String outputStrFlown = outputFormat.format(dateFlown);
            holder.tv_flown.setText("Depart at : " + outputStrFlown);
        }
        //set maskapai, bandara
        String maskapai = "Sriwijaya Air, ";
        String aiportCode = item.getYourItineraryDetails().getItineraryDetails()
                .getJourney().getItem().getSegment().getItem().get(0).getCityFrom().getValue();
        String airportName = findAirportName(aiportCode);
        holder.tv_maskapai_airport.setText(maskapai + airportName);

        //set status issued;
        String issuedBy = item.getYourItineraryDetails().getAgentDetails().getIssuedBy().getValue();
        String statusIssued = "Not Issued Yet";
        if(!issuedBy.equals("-"))
            statusIssued = "Issued";
        holder.tv_status_issued.setText(statusIssued);


    }

    private String findAirportName(String code) {
        for (String target :
                mAirportList) {
            if (target.contains(code))
                return target;
        }
        return "-";
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
