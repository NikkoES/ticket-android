package com.roka.ticketing.ticketdetail.viewholder;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.roka.ticketing.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roka on 20/03/18.
 */

public class TicketDetailStopsViewHolder extends ViewHolder{
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


    public TicketDetailStopsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
