package com.roka.ticketing.ticketdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.iconics.view.IconicsImageView;
import com.roka.ticketing.R;
import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FlightRouteItem;
import com.roka.ticketing.rest.payload.train.Schedule;
import com.roka.ticketing.ticketdetail.adapter.TicketDetailPagerAdapter;
import com.roka.ticketing.ticketdetail.fragment.TicketDetailFlightFragment;
import com.roka.ticketing.ticketdetail.fragment.TicketDetailFlightPriceFragment;
import com.roka.ticketing.ticketdetail.fragment.TicketDetailTrainFragment;
import com.roka.ticketing.ticketdetail.fragment.TicketDetailTrainPriceFragment;
import com.roka.ticketing.utilities.Gb;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roka on 22/02/18.
 */

public class TicketDetailActivity extends AppCompatActivity implements
        View.OnClickListener{
    @BindView(R.id.tb_ticketlisting_toolbar)
    Toolbar mTbToolbar;

    @BindView(R.id.tl_tabs)
    TabLayout mTlTabs;

    @BindView(R.id.vp_ticketlisting_fragment)
    ViewPager mVpFragment;

    private IconicsImageView mIivBack;
    private TextView mTvChange, mTvOriginDestination, mTvBrand, mTvRoute;
    private String mTotalDuration;
    private int fragmentType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketdetail);
        ButterKnife.bind(this);

        fragmentType = getIntent().getIntExtra("mode", 0);

        initActionBar();
        initTabLayout();
    }

    private void initActionBar() {
        setSupportActionBar(mTbToolbar);
        mIivBack = mTbToolbar.findViewById(R.id.iiv_toolbar_back_icon);
        mTvChange = mTbToolbar.findViewById(R.id.tv_toolbar_change);
        mTvRoute = mTbToolbar.findViewById(R.id.tv_toolbar_route);
        mTvBrand = mTbToolbar.findViewById(R.id.tv_toolbar_brand);

        String origin = getIntent().getStringExtra(Gb.INTENT_GENERAL_ORI);
        String dest = getIntent().getStringExtra(Gb.INTENT_GENERAL_DEST);
        String date = getIntent().getStringExtra(Gb.INTENT_GENERAL_DEPART_DATE);
        mTotalDuration = getIntent().getStringExtra(Gb.INTENT_TOTAL_DURATION);

        mTvRoute.setText(origin + " - " + dest);

        if(fragmentType == 0){
            FlightRouteItem flightRouteItem = (FlightRouteItem) getIntent().getSerializableExtra(Gb.INTENT_FLIGHT_ROUTE_ITEM);

        }
        else{
            Schedule schedule = (Schedule) getIntent().getSerializableExtra(Gb.INTENT_FLIGHT_ROUTE_ITEM);
            mTvBrand.setText(schedule.getTransporter_name());
        }

        mIivBack.setOnClickListener(this);
        mTvChange.setOnClickListener(this);
    }

    private void initTabLayout() {
        List<Fragment> fragments = new ArrayList<>();

        //choose menu search
        if(fragmentType == 0){
            FlightRouteItem flightRouteItem = (FlightRouteItem) getIntent().getSerializableExtra(Gb.INTENT_FLIGHT_ROUTE_ITEM);
            SearchFlightPayload mPayload = (SearchFlightPayload) getIntent().getSerializableExtra(Gb.INTENT_PAYLOAD_ITEM);
            fragments.add(TicketDetailFlightFragment.newInstance(flightRouteItem, mTotalDuration, mPayload));
            fragments.add(TicketDetailFlightPriceFragment.newInstance(flightRouteItem, mPayload));
        }
        else{
            Schedule schedule = (Schedule) getIntent().getSerializableExtra(Gb.INTENT_FLIGHT_ROUTE_ITEM);
            Schedule mPayload = (Schedule) getIntent().getSerializableExtra(Gb.INTENT_PAYLOAD_ITEM);
            fragments.add(TicketDetailTrainFragment.newInstance(schedule, mPayload));
            fragments.add(TicketDetailTrainPriceFragment.newInstance(schedule, mPayload));
        }

        FragmentManager fm = getSupportFragmentManager();
        mVpFragment.setAdapter(new TicketDetailPagerAdapter(fm, fragments));
        mTlTabs.setupWithViewPager(mVpFragment);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iiv_toolbar_back_icon:
            case R.id.tv_toolbar_change:
                finish();

        }
    }
}
