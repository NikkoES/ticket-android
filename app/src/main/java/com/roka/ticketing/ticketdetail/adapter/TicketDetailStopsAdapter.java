package com.roka.ticketing.ticketdetail.adapter;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roka.ticketing.R;
import com.roka.ticketing.rest.response.flight.FlightDataItem;
import com.roka.ticketing.rest.response.flight.helperpojo.searchflight.LegsItem;
import com.roka.ticketing.ticketdetail.viewholder.TicketDetailStopsViewHolder;
import com.roka.ticketing.ticketdetail.viewholder.TicketDetailTotalDurationViewHolder;
import com.roka.ticketing.utilities.StringUtilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.roka.ticketing.ticketdetail.fragment.TicketDetailFlightFragment.TYPE_CITILINK;
import static com.roka.ticketing.ticketdetail.fragment.TicketDetailFlightFragment.TYPE_SRIWIJAYA;

/**
 * Created by roka on 20/03/18.
 */

public class TicketDetailStopsAdapter extends RecyclerView.Adapter<ViewHolder> {
    private SimpleDateFormat dateFormat;
    private List<FlightDataItem> mData2;
    private List<LegsItem> mData;
    private String mTotalDuration;
    private int mTypeProvider;
    private Date departureDate;

    private static final int VT_ITEM = 0;
    private static final int VT_TOTAL_DURATION = 1;

    public TicketDetailStopsAdapter(List<LegsItem> legs, String totalDuration) {
        mData = legs;
        mTotalDuration = totalDuration;
        mTypeProvider = TYPE_SRIWIJAYA;
    }

    public TicketDetailStopsAdapter(List<FlightDataItem> legs, String strDepartureDate, String totalDuration) {
        mData2 = legs;
        mTotalDuration = totalDuration;
        mTypeProvider = TYPE_CITILINK;
        dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            departureDate = dateFormat.parse(strDepartureDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v;
        switch (viewType) {
            case VT_TOTAL_DURATION:
                v = inflater.inflate(R.layout.item_stops_total_time, parent, false);
                return new TicketDetailTotalDurationViewHolder(v);

            default:
                v = inflater.inflate(R.layout.item_ticketdetail_stops, parent, false);
                return new TicketDetailStopsViewHolder(v);

        }

    }

    @Override
    public void onBindViewHolder(ViewHolder vh, int position) {
        switch (getItemViewType(position)) {
            case VT_TOTAL_DURATION:
                TicketDetailTotalDurationViewHolder holder1 = (TicketDetailTotalDurationViewHolder) vh;
                holder1.totalduration.setText("Total Duration " + mTotalDuration);
                break;

            default:
                if (mTypeProvider == TYPE_SRIWIJAYA) {
                    LegsItem item = mData.get(position);
                    TicketDetailStopsViewHolder holder = (TicketDetailStopsViewHolder) vh;
                    holder.duration.setText("Duration " + StringUtilities.duration(item));
                    holder.landingto.setText(item.getmArrivalStation().getvalue());
                    holder.takeofffrom.setText(item.getmDepartureStation().getvalue());
                    holder.landingdate.setText(StringUtilities.getPrettyDate(item.getmSta().getvalue()));
                    holder.takeoffdate.setText(StringUtilities.getPrettyDate(item.getmStd().getvalue()));
                }else if(mTypeProvider == TYPE_CITILINK){
                    FlightDataItem item = mData2.get(position);
                    TicketDetailStopsViewHolder holder = (TicketDetailStopsViewHolder) vh;
                    holder.duration.setText("Duration " + item.getFlightDuration());
                    holder.landingto.setText(item.getArrivalPort());
                    holder.takeofffrom.setText(item.getDeparturePort());

                    String strDepartureTime = item.getDepartureTime();
                    String strArrivalTime = item.getArrivalTime();

                    Date arrivalDate = departureDate;

                    if(strArrivalTime.compareTo(strDepartureTime) < 0){
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(departureDate);
                        cal.add(Calendar.DATE, 1);
                        arrivalDate =  cal.getTime();
                    }

                    holder.takeoffdate.setText(dateFormat.format(departureDate) + ", " + item.getDepartureTime());
                    holder.landingdate.setText(dateFormat.format(arrivalDate) + ", " + item.getArrivalTime());
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        if (mTypeProvider == TYPE_SRIWIJAYA)
            return mData.size() + 1;
        else if (mTypeProvider == TYPE_CITILINK)
            return mData2.size() + 1;
        else
            return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (mTypeProvider == TYPE_SRIWIJAYA) {
            if (position == mData.size()) {
                return VT_TOTAL_DURATION;
            } else {
                return VT_ITEM;
            }
        } else if (mTypeProvider == TYPE_CITILINK) {
            if (position == mData2.size()) {
                return VT_TOTAL_DURATION;
            } else {
                return VT_ITEM;
            }
        } else {
            return VT_ITEM;
        }
    }
}
