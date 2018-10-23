package com.roka.ticketing.home.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.roka.ticketing.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roka on 20/02/18.
 */

public class HomePaymentViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.ll_container)
    public LinearLayout container;

    @BindView(R.id.tv_item_home_promo)
    public TextView title;

    @BindView(R.id.iv_item_home_promo)
    public ImageView image;

    public HomePaymentViewHolder(View v) {
        super(v);
        ButterKnife.bind(this,v);
    }
}
