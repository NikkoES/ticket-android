package com.roka.ticketing.home.fragment;


import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.roka.ticketing.BuildConfig;
import com.roka.ticketing.R;
import com.roka.ticketing.database.HistoryHelper;
import com.roka.ticketing.home.adapter.BookingAdapter;
import com.roka.ticketing.home.adapter.HistoryTrainAdapter;
import com.roka.ticketing.rest.payload.train.DataCaller;
import com.roka.ticketing.rest.response.flight.helperpojo.listbooking.ListBookingResponse;
import com.roka.ticketing.rest.response.train.History;
import com.roka.ticketing.rest.response.train.HistoryTrain;
import com.roka.ticketing.rest.services.RestCalls;
import com.roka.ticketing.rest.services.RestServices;
import com.roka.ticketing.rest.services.RestTrainServices;

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
public class BookingListTrainFragment extends Fragment {

    @BindView(R.id.rv_list)
    RecyclerView mRvBooking;

    @BindView(R.id.pb_loading_bar)
    ProgressBar mPbLoading;

    private List<History> mData;

    private HistoryTrainAdapter mAdapter = null;

    private HistoryHelper helper;

    public static BookingListTrainFragment newInstance() {
        BookingListTrainFragment fragment = new BookingListTrainFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_booking_list_train, container, false);

        ButterKnife.bind(this, v);

        initRecyclerView();

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getResources().getString(R.string.title_transaction_train));
    }

    public void initRecyclerView() {
        mData = new ArrayList<>();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRvBooking.setLayoutManager(manager);
        mAdapter = new HistoryTrainAdapter(mData);
        mRvBooking.setAdapter(mAdapter);

        loadListBooking();
    }

    private void loadListBooking() {
        helper = new HistoryHelper(getContext());
        helper.open();

        new LoadHistoryAsync().execute();
    }

    private class LoadHistoryAsync extends AsyncTask<Void, Void, ArrayList<History>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mPbLoading.setVisibility(View.VISIBLE);

            if (mData.size() > 0){
                mData.clear();
            }
        }

        @Override
        protected ArrayList<History> doInBackground(Void... voids) {
            return helper.query();
        }

        @Override
        protected void onPostExecute(ArrayList<History> gdsBook) {
            super.onPostExecute(gdsBook);
            mPbLoading.setVisibility(View.GONE);
            mData.addAll(gdsBook);
            mRvBooking.setAdapter(new HistoryTrainAdapter(mData));
            mAdapter.notifyDataSetChanged();
        }
    }

}
