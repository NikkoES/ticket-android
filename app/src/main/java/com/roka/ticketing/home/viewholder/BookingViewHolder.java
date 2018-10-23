package com.roka.ticketing.home.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.roka.ticketing.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roka on 18/04/18.
 */

public class BookingViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_rute)
    public TextView tv_rute;

    @BindView(R.id.tv_booking_code)
    public TextView tv_booking_code;

    @BindView(R.id.tv_flown)
    public TextView tv_flown;

    @BindView(R.id.tv_maskapai_airport)
    public TextView tv_maskapai_airport;

    @BindView(R.id.tv_status_issued)
    public TextView tv_status_issued;

    public BookingViewHolder(View v) {
        super(v);
        ButterKnife.bind(this, v);
    }
}
