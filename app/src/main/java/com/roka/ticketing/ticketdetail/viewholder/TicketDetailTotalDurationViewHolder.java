package com.roka.ticketing.ticketdetail.viewholder;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import com.roka.ticketing.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roka on 20/03/18.
 */

public class TicketDetailTotalDurationViewHolder extends ViewHolder {
    @BindView(R.id.iv_ticketdetail_stops_total_time)
    public TextView totalduration;

    public TicketDetailTotalDurationViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

}
