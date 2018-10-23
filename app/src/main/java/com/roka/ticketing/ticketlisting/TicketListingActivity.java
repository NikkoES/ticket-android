package com.roka.ticketing.ticketlisting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikepenz.iconics.view.IconicsImageView;
import com.roka.ticketing.R;
import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.response.flight.LionSearchResponse;
import com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FlightRouteItem;
import com.roka.ticketing.rest.payload.train.Schedule;
import com.roka.ticketing.ticketdetail.TicketDetailActivity;
import com.roka.ticketing.ticketlisting.adapter.TicketListingPagerAdapter;
import com.roka.ticketing.ticketlisting.fragment.TicketListingPlaneFragment;
import com.roka.ticketing.ticketlisting.fragment.TicketListingTrainFragment;
import com.roka.ticketing.ticketlisting.interfaces.TicketListingInterface;
import com.roka.ticketing.utilities.Gb;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roka on 22/02/18.
 */

public class TicketListingActivity extends AppCompatActivity implements
        View.OnClickListener,
        TicketListingInterface{
    @BindView(R.id.tb_ticketlisting_toolbar)
    Toolbar mTbToolbar;

    @BindView(R.id.tl_tabs)
    TabLayout mTlTabs;

    @BindView(R.id.vp_ticketlisting_fragment)
    ViewPager mVpFragment;

    @BindView(R.id.ll_control)
    LinearLayout mLlControl;

    private IconicsImageView mIivBack;
    private TextView mTvChange, mTvOriginDestination, mTvDate, mTvRoute;
    private Fragment mFragment;
    private String mDest, mOri, mDate;
    private SharedPreferences mPref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketlisting);
        ButterKnife.bind(this);

        mPref = getSharedPreferences(Gb.PREF_NAME, MODE_PRIVATE);

        initActionBar();
        initFragment();

    }

    private void initFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft =  fm.beginTransaction();

        int fragmentType = getIntent().getIntExtra(Gb.INTENT_GENERAL_MODE, 0);

        //choose menu search
        if(fragmentType == 0){
            SearchFlightPayload mBody = (SearchFlightPayload) getIntent().getSerializableExtra(Gb.INTENT_GENERAL_BODY);
            mFragment = TicketListingPlaneFragment.newInstance(this, mBody);
        }
        else{
            Schedule mBody = (Schedule) getIntent().getSerializableExtra(Gb.INTENT_GENERAL_BODY);
            mFragment = TicketListingTrainFragment.newInstance(this, mBody);
        }
        ft.add(R.id.fr_fragment, mFragment);
        ft.commit();
    }

    private void initActionBar() {
        setSupportActionBar(mTbToolbar);
        mIivBack = mTbToolbar.findViewById(R.id.iiv_toolbar_back_icon);
        mTvChange = mTbToolbar.findViewById(R.id.tv_toolbar_change);
        mTvRoute = mTbToolbar.findViewById(R.id.tv_toolbar_route);
        mTvDate = mTbToolbar.findViewById(R.id.tv_toolbar_date);

        mOri = getIntent().getStringExtra(Gb.INTENT_GENERAL_ORI);
        mDest = getIntent().getStringExtra(Gb.INTENT_GENERAL_DEST);
        mDate = getIntent().getStringExtra(Gb.INTENT_GENERAL_DEPART_DATE);

        mTvDate.setText(mDate);
        mTvRoute.setText(mOri + " - " + mDest);
        mIivBack.setOnClickListener(this);
        mTvChange.setOnClickListener(this);
    }

    @Override
    public void showControlLayout(boolean isShown) {
        mLlControl.setVisibility(isShown ?  View.VISIBLE : View.GONE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iiv_toolbar_back_icon:
            case R.id.tv_toolbar_change:
                finish();

        }
    }

    @Override
    public void onPlaneTicketDetail(FlightRouteItem model, String totalDuration, SearchFlightPayload payload) {
        if(mFragment instanceof TicketListingPlaneFragment) {
            Intent intent = new Intent(this, TicketDetailActivity.class);
            intent.putExtra(Gb.INTENT_FLIGHT_ROUTE_ITEM, model);
            intent.putExtra(Gb.INTENT_PAYLOAD_ITEM , payload);
            intent.putExtra(Gb.INTENT_GENERAL_DEST, mDest);
            intent.putExtra(Gb.INTENT_GENERAL_ORI, mOri);
            intent.putExtra(Gb.INTENT_TOTAL_DURATION, totalDuration);
            intent.putExtra(Gb.INTENT_GENERAL_DEPART_DATE, mDate);
            intent.putExtra(Gb.INTENT_GENERAL_MODE, 0);

            mPref.edit().putString(Gb.PREF_CLASS_KEY, model
                    .getmClassesAvailable().getClassesAvailableItem().get(0)
                    .getClassesAvailableItemItem().get(0).getmKey().getvalue()).commit();
            startActivity(intent);
        }
    }

    @Override
    public void onPlaneTicketDetail(LionSearchResponse model, SearchFlightPayload payload) {

    }

    @Override
    public void onTrainTicketDetail(Schedule model, Schedule payload) {
        if(mFragment instanceof TicketListingTrainFragment) {
            Intent intent = new Intent(this, TicketDetailActivity.class);
            intent.putExtra(Gb.INTENT_FLIGHT_ROUTE_ITEM, model);
            intent.putExtra(Gb.INTENT_PAYLOAD_ITEM , payload);
            intent.putExtra(Gb.INTENT_GENERAL_DEST, mDest);
            intent.putExtra(Gb.INTENT_GENERAL_ORI, mOri);
            intent.putExtra(Gb.INTENT_GENERAL_DEPART_DATE, mDate);
            intent.putExtra(Gb.INTENT_GENERAL_MODE, 1);
            startActivity(intent);
        }
    }
}
