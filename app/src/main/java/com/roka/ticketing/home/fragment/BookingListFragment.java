package com.roka.ticketing.home.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.roka.ticketing.R;
import com.roka.ticketing.home.adapter.BookingAdapter;
import com.roka.ticketing.rest.response.flight.helperpojo.listbooking.ListBookingResponse;
import com.roka.ticketing.rest.services.RestCalls;
import com.roka.ticketing.rest.services.RestServices;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookingListFragment extends Fragment {
    @BindView(R.id.rv_list)
    RecyclerView mRvBooking;

    @BindView(R.id.pb_loading_bar)
    ProgressBar mPbLoading;

    private List<ListBookingResponse> mData;

    private BookingAdapter mAdapter = null;
    private RestCalls mServices;

    public static BookingListFragment newInstance() {
        BookingListFragment fragment = new BookingListFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getResources().getString(R.string.title_transaction));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_booking_list, container, false);
        ButterKnife.bind(this, v);

        mServices = RestServices.getService();

        initRecyclerView();
        return v;
    }

    public void initRecyclerView() {
        mData = new ArrayList<>();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mAdapter = new BookingAdapter(mData, this);

        mRvBooking.setLayoutManager(manager);
        mRvBooking.setAdapter(mAdapter);

        loadListBooking();
    }

    private void loadListBooking() {
        Call<List<ListBookingResponse>> call = mServices.getListBooking();
        call.enqueue(new Callback<List<ListBookingResponse>>() {
            @Override
            public void onResponse(Call<List<ListBookingResponse>> call, Response<List<ListBookingResponse>> response) {
                if (response.code() == 200) {
                    List<ListBookingResponse> data = response.body();
                    mData.clear();
                    mData.addAll(data);
                    mAdapter.notifyDataSetChanged();
                }
                mPbLoading.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<ListBookingResponse>> call, Throwable t) {
                mPbLoading.setVisibility(View.GONE);
            }
        });
    }

}
