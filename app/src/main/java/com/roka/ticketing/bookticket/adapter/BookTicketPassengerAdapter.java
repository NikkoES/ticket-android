package com.roka.ticketing.bookticket.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roka.ticketing.R;
import com.roka.ticketing.bookticket.BookTicketActivity;
import com.roka.ticketing.bookticket.interfaces.BookTicketInterface;
import com.roka.ticketing.bookticket.viewholder.BaseViewHolder;
import com.roka.ticketing.bookticket.viewholder.InputPassengerViewHolder;
import com.roka.ticketing.bookticket.viewholder.PassengerViewHolder;
import com.roka.ticketing.bookticket.viewholder.TitleViewHolder;
import com.roka.ticketing.repository.entity.AdultEntity;
import com.roka.ticketing.repository.entity.BaseEntity;
import com.roka.ticketing.repository.entity.ChildEntity;
import com.roka.ticketing.repository.entity.EmptyAdultEntity;
import com.roka.ticketing.repository.entity.EmptyChildEntity;
import com.roka.ticketing.repository.entity.EmptyInfantEntity;
import com.roka.ticketing.repository.entity.InfantEntity;
import com.roka.ticketing.repository.entity.TitleEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roka on 06/04/18.
 */

public class BookTicketPassengerAdapter extends Adapter<BaseViewHolder>
        implements View.OnClickListener {
    private int mAdult = 1;
    private int mChild, mInfant = 0;
    private BookTicketInterface mInterface;
    private List<BaseEntity> mData = new ArrayList<>();


    public static final int VIEW_TYPE_TITLE = 0;
    public static final int VIEW_TYPE_EMPTY_ADULT = 1;
    public static final int VIEW_TYPE_EMPTY_CHILD = 2;
    public static final int VIEW_TYPE_EMPTY_INFANT = 3;
    public static final int VIEW_TYPE_ADULT = 4;
    public static final int VIEW_TYPE_CHILD = 5;
    public static final int VIEW_TYPE_INFANT = 6;

    public BookTicketPassengerAdapter(int adult, int child, int infant, BookTicketInterface callback) {
        this.mAdult = adult;
        this.mChild = child;
        this.mInfant = infant;
        this.mInterface = callback;
    }

    public BookTicketPassengerAdapter(List<BaseEntity> mData, BookTicketActivity callback) {
        this.mData = mData;
        this.mInterface = callback;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        BaseViewHolder vH = null;
        switch (viewType) {
            case VIEW_TYPE_TITLE:
                vH = new TitleViewHolder(inflater.inflate(R.layout.item_bookticket_title, parent, false));
                break;
            case VIEW_TYPE_EMPTY_ADULT:
            case VIEW_TYPE_EMPTY_CHILD:
            case VIEW_TYPE_EMPTY_INFANT:
                vH = new InputPassengerViewHolder(inflater.inflate(R.layout.item_bookticket_inputpassenger, parent, false));
                break;
            case VIEW_TYPE_ADULT:
            case VIEW_TYPE_CHILD:
            case VIEW_TYPE_INFANT:
                vH = new PassengerViewHolder(inflater.inflate(R.layout.item_bookticket_passenger, parent, false));
                break;

        }
        return vH;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

        switch (getItemViewType(position)) {
            case VIEW_TYPE_TITLE: {
                TitleViewHolder vH = (TitleViewHolder) holder;
                TitleEntity item = (TitleEntity) mData.get(position);
                vH.tv_title.setText(item.getTitle());
                break;
            }
            case VIEW_TYPE_EMPTY_ADULT:
            case VIEW_TYPE_EMPTY_CHILD:
            case VIEW_TYPE_EMPTY_INFANT: {
                InputPassengerViewHolder vH = (InputPassengerViewHolder) holder;
                vH.container.setOnClickListener(this);
                vH.container.setTag(position);
                break;
            }
            case VIEW_TYPE_ADULT: {
                AdultEntity item = (AdultEntity) mData.get(position);
                PassengerViewHolder vH = (PassengerViewHolder) holder;
                vH.text.setText(item.getFirstName() + " " + item.getLastName());
                vH.nik.setText(item.getIdentityNumber());
                vH.container.setOnClickListener(this);
                vH.container.setTag(position);
                break;
            }
            case VIEW_TYPE_CHILD: {
                ChildEntity item = (ChildEntity) mData.get(position);
                PassengerViewHolder vH = (PassengerViewHolder) holder;
                vH.text.setText(item.getFirstName() + " " + item.getLastName());
                vH.nik.setText(item.getIdentityNumber());
                vH.container.setOnClickListener(this);
                vH.container.setTag(position);
                break;
            }
            case VIEW_TYPE_INFANT: {
                InfantEntity item = (InfantEntity) mData.get(position);
                PassengerViewHolder vH = (PassengerViewHolder) holder;
                vH.text.setText(item.getFirstName() + " " + item.getLastName());
                vH.nik.setText(item.getIdentityNumber());
                vH.container.setOnClickListener(this);
                vH.container.setTag(position);
                break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof TitleEntity)
            return VIEW_TYPE_TITLE;
        else if (mData.get(position) instanceof EmptyAdultEntity)
            return VIEW_TYPE_EMPTY_ADULT;
        else if (mData.get(position) instanceof EmptyChildEntity)
            return VIEW_TYPE_EMPTY_CHILD;
        else if (mData.get(position) instanceof EmptyInfantEntity)
            return VIEW_TYPE_EMPTY_INFANT;
        else if (mData.get(position) instanceof AdultEntity)
            return VIEW_TYPE_ADULT;
        else if (mData.get(position) instanceof ChildEntity)
            return VIEW_TYPE_CHILD;
        else
            return VIEW_TYPE_INFANT;
    }

    @Override
    public void onClick(View view) {
        int tag = (int) view.getTag();
        mInterface.onInputPassengerCliked(tag, getItemViewType(tag));
    }
}
