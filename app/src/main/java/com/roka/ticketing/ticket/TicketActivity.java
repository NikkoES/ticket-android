package com.roka.ticketing.ticket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mikepenz.iconics.IconicsDrawable;
import com.roka.ticketing.R;
import com.roka.ticketing.common.adapter.ImageSlideAdapter;
import com.roka.ticketing.ticket.adapter.TicketFragmentPagerAdapter;
import com.roka.ticketing.ticket.fragment.PlaneTicketFragment;
import com.roka.ticketing.ticket.fragment.TrainTicketFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by roka on 20/02/18.
 */

public class TicketActivity extends AppCompatActivity
    implements AppBarLayout.OnOffsetChangedListener{
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.vp_ticket_promo)
    ViewPager mVpPromo;

    @BindView(R.id.vp_fragment)
    ViewPager mVpFragment;

    @BindView(R.id.ci_ticket_indicator)
    CircleIndicator mCiIndicator;

    @BindView(R.id.appBar)
    AppBarLayout mAppBarLayout;

    @BindView(R.id.ctl_collapsing_toolbar)
    CollapsingToolbarLayout mCtlToolbar;

    @BindView(R.id.tl_tabs)
    TabLayout mTlTabs;

    @BindView(R.id.nsv_scroll)
    NestedScrollView mNsvScroll;

    private ImageSlideAdapter mImageSlideAdapter = null;
    private TicketFragmentPagerAdapter mAdapter = null;
    boolean mIsShow = true;
    int mScrollRange = -1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        initActionBar();
        initViewPager();
        initTabLayout();

        mAppBarLayout.addOnOffsetChangedListener(this);
    }

    private void initActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void initViewPager() {
        mNsvScroll.setFillViewport(true);
        List<String> data = new ArrayList<>();
        data.add("http://cdn2.tstatic.net/travel/foto/bank/images/kfc-indonesia_20160816_191054.jpg");
        data.add("http://www.serbapromosi.co/images/stories/serbapromosi/serbapromosi-mc-donald-prom-_-400xauto.jpg");
        mImageSlideAdapter = new ImageSlideAdapter(data, null);
        mVpPromo.setAdapter(mImageSlideAdapter);
        mCiIndicator.setViewPager(mVpPromo);
        mImageSlideAdapter.registerDataSetObserver(mCiIndicator.getDataSetObserver());
    }

    private void initTabLayout() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(PlaneTicketFragment.newInstance());
        fragments.add(TrainTicketFragment.newInstance());

        mAdapter = new TicketFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        mVpFragment.setAdapter(mAdapter);
        mTlTabs.setupWithViewPager(mVpFragment);

        mTlTabs.getTabAt(0).setIcon(R.drawable.ic_airplane_white_24dp);
        mTlTabs.getTabAt(1).setIcon(R.drawable.ic_train_white_24dp);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                finish();
                return true;

            default:
                return true;
        }
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (mScrollRange == -1) {
            mScrollRange = appBarLayout.getTotalScrollRange();
        }
        if (mScrollRange + verticalOffset == 0) {
            mCtlToolbar.setTitle(getString(R.string.ticket_manifest_label));
            mIsShow = true;
        } else if(mIsShow) {
            mCtlToolbar.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
            mIsShow = false;
        }
    }
}
