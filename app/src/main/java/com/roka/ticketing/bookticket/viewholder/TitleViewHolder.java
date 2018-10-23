package com.roka.ticketing.bookticket.viewholder;

import android.view.View;
import android.widget.TextView;

import com.roka.ticketing.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TitleViewHolder extends BaseViewHolder {
    @BindView(R.id.tv_title)
    public TextView tv_title;

    public TitleViewHolder(View v) {
        super(v);
        ButterKnife.bind(this, v);
    }
}
