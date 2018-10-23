package com.roka.ticketing.ticketlisting.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.roka.ticketing.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roka on 25/02/18.
 */

public class TrainTicketListingViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.cv_container)
    public CardView container;

    @BindView(R.id.btn_ticketlisting_detail)
    public Button detail;

    @BindView(R.id.tv_train_name)
    public TextView name;

    @BindView(R.id.tv_train_seat)
    public TextView seats;

    @BindView(R.id.tv_train_direct)
    public TextView direct;

    @BindView(R.id.tv_train_time)
    public TextView time;

    @BindView(R.id.tv_train_price)
    public TextView price;

    public TrainTicketListingViewHolder(View v) {
        super(v);
        ButterKnife.bind(this,v);
    }
}
