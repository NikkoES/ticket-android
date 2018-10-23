package com.roka.ticketing.inputpassenger.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import com.roka.ticketing.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roka on 26/04/18.
 */

public class PassengerViewHolder extends ViewHolder{
    @BindView(R.id.tv_item_passenger_name)
    public TextView name;

    @BindView(R.id.tv_item_passenger_phone)
    public TextView phone;

    @BindView(R.id.cv_container)
    public CardView container;

    public PassengerViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }
}
