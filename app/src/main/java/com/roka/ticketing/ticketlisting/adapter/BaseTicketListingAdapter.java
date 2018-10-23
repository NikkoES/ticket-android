package com.roka.ticketing.ticketlisting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.roka.ticketing.ticketlisting.interfaces.TicketListingInterface;

/**
 * Created by roka on 25/02/18.
 */

public abstract class BaseTicketListingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
    implements View.OnClickListener{
    protected TicketListingInterface mCallback = null;

    public BaseTicketListingAdapter(TicketListingInterface callback) {
        mCallback = callback;
    }

    @Override
    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public abstract int getItemCount();
}
