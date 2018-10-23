package com.roka.ticketing.bookticket.viewholder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import com.roka.ticketing.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roka on 06/04/18.
 */

public class InputPassengerViewHolder extends BaseViewHolder {
    @BindView(R.id.cv_container)
    public CardView container;

    @BindView(R.id.tv_item_bookflight_name)
    public TextView text;

    public InputPassengerViewHolder(View v) {
        super(v);
        ButterKnife.bind(this, v);
    }
}
