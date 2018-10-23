package com.roka.ticketing.home.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roka.ticketing.R;
import com.roka.ticketing.common.adapter.ImageSlideAdapter;
import com.roka.ticketing.home.adapter.HomePaymentAdapter;
import com.roka.ticketing.home.interfaces.HomeInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by roka on 20/02/18.
 */

public class HomeFragment extends Fragment {
    @BindView(R.id.rv_payment)
    RecyclerView mRvPayment;

    @BindView(R.id.vp_home_promo)
    ViewPager mVpPromo;

    @BindView(R.id.ci_indicator)
    CircleIndicator mCiIndicator;

    private HomePaymentAdapter mAdapter = null;
    private ImageSlideAdapter mImageSlideAdapter = null;
    private HomeInterface mCallback = null;

    public static HomeFragment newInstance(HomeInterface callback) {
        HomeFragment fragment = new HomeFragment();
        fragment.mCallback = callback;
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getResources().getString(R.string.title_home));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,v);

        initRecyclerView();
        initViewPager();
        return  v;
    }

    private void initRecyclerView() {
        mAdapter = new HomePaymentAdapter(mCallback);
        mRvPayment.setLayoutManager(new GridLayoutManager(getActivity(), 3,
                LinearLayoutManager.VERTICAL, false));
        mRvPayment.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    private void initViewPager() {
        List<String> data = new ArrayList<>();
        data.add("http://cdn2.tstatic.net/travel/foto/bank/images/kfc-indonesia_20160816_191054.jpg");
        data.add("http://www.serbapromosi.co/images/stories/serbapromosi/serbapromosi-mc-donald-prom-_-400xauto.jpg");
        mImageSlideAdapter = new ImageSlideAdapter(data, mCallback);
        mVpPromo.setAdapter(mImageSlideAdapter);
        mCiIndicator.setViewPager(mVpPromo);
        mImageSlideAdapter.registerDataSetObserver(mCiIndicator.getDataSetObserver());
    }

}
