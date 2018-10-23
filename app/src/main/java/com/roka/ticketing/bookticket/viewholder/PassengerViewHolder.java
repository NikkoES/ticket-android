package com.roka.ticketing.bookticket.viewholder;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.roka.ticketing.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roka on 06/04/18.
 */

public class PassengerViewHolder extends BaseViewHolder {
    @BindView(R.id.cv_container)
    public CardView container;

    @BindView(R.id.tv_item_bookflight_name)
    public TextView text;

    @BindView(R.id.tv_item_bookflight_nik)
    public TextView nik;

    public PassengerViewHolder(View v) {
        super(v);
        ButterKnife.bind(this, v);
    }
}
