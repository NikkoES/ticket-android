package com.roka.ticketing.ticketlisting.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roka.ticketing.R;
import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.payload.train.Schedule;
import com.roka.ticketing.ticketlisting.interfaces.TicketListingInterface;
import com.roka.ticketing.ticketlisting.viewholder.TrainTicketListingViewHolder;
import com.roka.ticketing.utilities.StringUtilities;

import java.util.List;

/**
 * Created by roka on 25/02/18.
 */

public class TrainTicketListingAdapter extends BaseTicketListingAdapter
        implements View.OnClickListener {
    private Schedule mPayload;
    private List<Schedule> mData = null;

    public TrainTicketListingAdapter(TicketListingInterface callback, List<Schedule> data, Schedule payload) {
        super(callback);
        mData = data;
        mPayload = payload;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_ticketlisting_train, parent, false);

        return new TrainTicketListingViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TrainTicketListingViewHolder vh = (TrainTicketListingViewHolder) holder;

        Schedule item = mData.get(position);
        vh.name.setText(item.getTransporter_name());
        vh.seats.setText(item.getAvb()+" Seats Left");
        vh.direct.setText("Direct ("+StringUtilities.durationTrain(item.getDep_datetime(), item.getArv_datetime())+")");
        vh.time.setText(StringUtilities.timeResponseToHourTrain(item.getDep_datetime())+" - "+StringUtilities.timeResponseToHourTrain(item.getArv_datetime()));
        vh.price.setText("IDR "+Integer.parseInt(item.getAdult_fare()) * mPayload.getAdult_num());

        vh.container.setOnClickListener(this);
        vh.detail.setOnClickListener(this);

        vh.detail.setTag(item);
        vh.container.setTag(item);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View view) {
        Schedule item = (Schedule) view.getTag();
        if (item != null){
            mCallback.onTrainTicketDetail(item, mPayload);
        }

    }
}
