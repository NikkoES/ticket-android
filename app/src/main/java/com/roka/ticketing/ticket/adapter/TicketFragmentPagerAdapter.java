package com.roka.ticketing.ticket.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by roka on 20/02/18.
 */

public class TicketFragmentPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> mFragmentList = null;

    public TicketFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragmentList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
