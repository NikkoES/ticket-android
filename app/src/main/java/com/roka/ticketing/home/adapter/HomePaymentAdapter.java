package com.roka.ticketing.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.mikepenz.iconics.IconicsDrawable;
import com.roka.ticketing.R;
import com.roka.ticketing.home.interfaces.HomeInterface;
import com.roka.ticketing.home.viewholder.HomePaymentViewHolder;

import butterknife.OnClick;

/**
 * Created by roka on 20/02/18.
 */

public class HomePaymentAdapter extends RecyclerView.Adapter<HomePaymentViewHolder>
    implements View.OnClickListener{
    private HomeInterface mCallback;
    private Context mContext = null;

    public HomePaymentAdapter(HomeInterface callback) {
        mCallback = callback;
    }

    private String[] mTitleEnum = new String[]{"Flights", "Train", "Hotel",
            "Agriculture", "Industrial", "Food",};

    private String[] mImageIcon = new String[]{"gmd-flight","gmd-train","gmd-hotel",
            "gmd-local-florist","gmd-ev-station","gmd-restaurant"};

    @Override
    public HomePaymentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_home_promo, parent, false);
        mContext = parent.getContext();

        return new HomePaymentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HomePaymentViewHolder holder, int position) {
        holder.container.setTag(position);
        holder.container.setOnClickListener(this);
        holder.title.setText(mTitleEnum[position]);
        Glide.with(mContext).load(
                new IconicsDrawable(mContext)
                        .icon(mImageIcon[position])
                        .color(mContext.getResources().getColor(R.color.colorPrimary))
                        .sizeDp(32))
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        mCallback.paymentCallback(position);
    }
}
