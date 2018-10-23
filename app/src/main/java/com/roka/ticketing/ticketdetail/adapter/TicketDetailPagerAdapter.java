package com.roka.ticketing.ticketdetail.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by roka on 22/02/18.
 */

public class TicketDetailPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments = null;
    private String[] mTitles = new String[]{"Flight","Price Detail"};

    public TicketDetailPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public int getCount() {
        return 2;
    }
}
