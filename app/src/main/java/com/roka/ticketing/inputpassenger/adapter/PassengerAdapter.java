package com.roka.ticketing.inputpassenger.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roka.ticketing.R;
import com.roka.ticketing.inputpassenger.interfaces.InputPassengerInterface;
import com.roka.ticketing.inputpassenger.viewholder.PassengerViewHolder;
import com.roka.ticketing.repository.entity.PassengerEntity;

import java.util.List;

/**
 * Created by roka on 26/04/18.
 */

public class PassengerAdapter extends Adapter<PassengerViewHolder>
    implements View.OnClickListener{
    private List<PassengerEntity> mData;
    private InputPassengerInterface mInterface;

    public PassengerAdapter(List<PassengerEntity> passengers, InputPassengerInterface callback) {
        mData = passengers;
        mInterface = callback;
    }

    @NonNull
    @Override
    public PassengerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_passenger, parent, false);
        return new PassengerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PassengerViewHolder holder, int position) {
        PassengerEntity data = mData.get(position);

        holder.container.setOnClickListener(this);
        holder.container.setTag(data);

        holder.name.setText(data.getFirstName() + " " + data.getLastName());
        holder.phone.setText(data.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cv_container :
                PassengerEntity passenger = (PassengerEntity) view.getTag();
                mInterface.onPassengerSelected(passenger);
        }
    }
}
