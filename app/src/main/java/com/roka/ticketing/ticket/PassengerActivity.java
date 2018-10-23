package com.roka.ticketing.ticket;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mikepenz.iconics.view.IconicsImageView;
import com.roka.ticketing.R;
import com.roka.ticketing.utilities.Gb;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by roka on 21/02/18.
 */

public class PassengerActivity extends AppCompatActivity {
    @BindView(R.id.iiv_add_adult)
    IconicsImageView mIivAddAdult;

    @BindView(R.id.iiv_add_child)
    IconicsImageView mIivAddChild;

    @BindView(R.id.iiv_add_infant)
    IconicsImageView mIivAddInfant;

    @BindView(R.id.iiv_remove_adult)
    IconicsImageView mIivRemoveAdult;

    @BindView(R.id.iiv_remove_child)
    IconicsImageView mIivRemoveChild;

    @BindView(R.id.iiv_remove_infant)
    IconicsImageView mIivRemoveInfant;

    @BindView(R.id.tv_adult)
    TextView mTvAdult;

    @BindView(R.id.tv_child)
    TextView mTvChild;

    @BindView(R.id.tv_infant)
    TextView mTvInfant;

    @BindView(R.id.rl_child_passenger)
    RelativeLayout layoutChild;

    private int mAdultNum = 1;
    private int mChildNum, mInfantNum = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger);
        initActionBar();
        ButterKnife.bind(this);

        initPassengerData();
    }

    private void initActionBar() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initPassengerData() {
        if(getIntent().hasExtra(Gb.INTENT_KODE_PASSENGER)){
            layoutChild.setVisibility(View.GONE);
        }
        else{
            layoutChild.setVisibility(View.VISIBLE);
        }

        mAdultNum = getIntent().getIntExtra(Gb.INTENT_PASSENGER_ADULT,0);
        mChildNum = getIntent().getIntExtra(Gb.INTENT_PASSENGER_CHILD, 0);
        mInfantNum = getIntent().getIntExtra(Gb.INTENT_PASSENGER_INFANT, 0);

        mTvAdult.setText("" + mAdultNum);
        mTvChild.setText("" + mChildNum);
        mTvInfant.setText("" + mInfantNum);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.iiv_add_adult)
    public void onAddAdult() {
        mAdultNum++;
        mTvAdult.setText("" + mAdultNum);
    }

    @OnClick(R.id.iiv_remove_adult)
    public void onRemoveAdult() {
        if(mAdultNum > 1) mAdultNum--;
        mTvAdult.setText("" + mAdultNum);
    }

    @OnClick(R.id.iiv_add_child)
    public void onAddChild() {
        mChildNum++;
        mTvChild.setText("" + mChildNum);
    }

    @OnClick(R.id.iiv_remove_child)
    public void onRemoveChild() {
        if(mChildNum > 0) mChildNum--;
        mTvChild.setText("" + mChildNum);
    }

    @OnClick(R.id.iiv_add_infant)
    public void onAddInfant() {
        mInfantNum++;
        mTvInfant.setText("" + mInfantNum);
    }

    @OnClick(R.id.iiv_remove_infant)
    public void onRemoveInfant() {
        if(mInfantNum > 0) mInfantNum--;
        mTvInfant.setText("" + mInfantNum);
    }

    @OnClick(R.id.btn_passenger_confirm)
    public void onPassengerConfirm() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(Gb.INTENT_PASSENGER_ADULT, mAdultNum);
        returnIntent.putExtra(Gb.INTENT_PASSENGER_CHILD, mChildNum);
        returnIntent.putExtra(Gb.INTENT_PASSENGER_INFANT, mInfantNum);

        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
