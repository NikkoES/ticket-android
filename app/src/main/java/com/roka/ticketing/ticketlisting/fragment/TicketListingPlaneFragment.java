package com.roka.ticketing.ticketlisting.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.roka.ticketing.R;
import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.response.flight.LionSearchResponse;
import com.roka.ticketing.rest.response.flight.SearchFlightResponse;
import com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FlightRouteItem;
import com.roka.ticketing.rest.response.flight.helperpojo.searchflight.Item;
import com.roka.ticketing.rest.services.RestCalls;
import com.roka.ticketing.rest.services.RestServices;
import com.roka.ticketing.ticketlisting.adapter.PlaneTicketListingAdapter;
import com.roka.ticketing.ticketlisting.interfaces.TicketListingInterface;
import com.roka.ticketing.utilities.Gb;
import com.roka.ticketing.utilities.StringUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by roka on 22/02/18.
 */

public class TicketListingPlaneFragment extends Fragment {
    @BindView(R.id.rv_plane_ticket_listing)
    RecyclerView mRvPlaneListing;

    @BindView(R.id.pb_loading_bar)
    ProgressBar mPbProgress;

    private static final int TOTAL_PROGRESS = 3;
    private int currentProgress = 0;

    private PlaneTicketListingAdapter mAdapter = null;
    private TicketListingInterface mCallback = null;
    private SearchFlightPayload mBody = null;

    private RestCalls mServices = null;
    private List<FlightRouteItem> mData = new ArrayList<>();

    private MaterialDialog mDialog = null;
    private SharedPreferences mPref = null;


    public static TicketListingPlaneFragment newInstance(TicketListingInterface callback, SearchFlightPayload body) {
        TicketListingPlaneFragment fragment = new TicketListingPlaneFragment();
        fragment.mCallback = callback;
        fragment.mBody = body;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_ticket_listing_plane, container, false);
        ButterKnife.bind(this, v);
        initRecyclerView();

        mServices = RestServices.getService();
        mPref = getActivity().getSharedPreferences(Gb.PREF_NAME, Context.MODE_PRIVATE);
        initProgress();
        searchTicket();
        loadLion();
        loadCitilink();
        return v;
    }

    private void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mAdapter = new PlaneTicketListingAdapter(mCallback, mData, getContext(), mBody);
        mRvPlaneListing.setAdapter(mAdapter);
        mRvPlaneListing.setLayoutManager(manager);
        mAdapter.notifyDataSetChanged();
    }

    private void searchTicket() {
        mDialog = new MaterialDialog.Builder(getContext())
                .cancelable(false)
                .backgroundColor(getResources().getColor(R.color.white))
                .contentColor(getResources().getColor(R.color.black))
                .content("Please Wait...")
                .build();

//        mDialog.show();

        Call<SearchFlightResponse> call = mServices.searchFlight(mBody);
        call.enqueue(new Callback<SearchFlightResponse>() {
            @Override
            public void onResponse(Call<SearchFlightResponse> call, Response<SearchFlightResponse> response) {
                if (response.code() == 200) {
                    if (response.body() != null && response.body().getReturn() != null
                            && response.body().getReturn().getTripDetail() != null
                            && response.body().getReturn().getTripDetail().getItem() != null) {
                        List<Item> mTripDetailItem = response.body().getReturn().getTripDetail().getItem();
                        List<FlightRouteItem> data = mTripDetailItem.get(0).getFlightRoute().getItem();
                        int num = data.size();
                        Collections.sort(data, new Comparator<FlightRouteItem>() {
                            @Override
                            public int compare(FlightRouteItem o1, FlightRouteItem o2) {
                                double price1 = StringUtilities.getPriceTotal(o1);
                                double price2 = StringUtilities.getPriceTotal(o2);
                                if (price1 > price2)
                                    return 1;
                                else if (price1 < price2)
                                    return -1;
                                else
                                    return 0;
                            }
                        });
                        mData.addAll(data);

                        if (mTripDetailItem.size() > 1) {
                            List<FlightRouteItem> data2 = mTripDetailItem.get(1).getFlightRoute().getItem();
                            mData.addAll(data2);
                        }

                        mAdapter.notifyDataSetChanged();
                        mPref.edit().putString(Gb.PREF_SEARCH_KEY, response.body().getReturn().getSearchKey().getvalue()).commit();
                    }
                } else {
                    Toast.makeText(getContext(), "No Sriwijaya Data Found", Toast.LENGTH_SHORT).show();
                }
                addProgress();
            }

            @Override
            public void onFailure(Call<SearchFlightResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Errornya " + t.toString(), Toast.LENGTH_SHORT).show();
//                Log.e("ASDF", "" + t.toString());
                addProgress();
            }
        });
    }

    private void loadLion() {
        Call<List<LionSearchResponse>> call = mServices.searchLionFlight(mBody);
        call.enqueue(new Callback<List<LionSearchResponse>>() {
            @Override
            public void onResponse(Call<List<LionSearchResponse>> call, Response<List<LionSearchResponse>> response) {
                if (response.code() == 200) {
                    List<LionSearchResponse> data = response.body();

                    mAdapter.addAll(data);
                } else {
                    Toast.makeText(getContext(), "No Lion Data Found", Toast.LENGTH_SHORT).show();
                }
                addProgress();
            }

            @Override
            public void onFailure(Call<List<LionSearchResponse>> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.toString(), Toast.LENGTH_SHORT).show();
//                Log.e("ASDF", "" + t.toString());
                addProgress();

            }
        });
    }


    private void loadCitilink() {
        Call<List<LionSearchResponse>> call = mServices.searchCitilinkFlight(mBody);
        call.enqueue(new Callback<List<LionSearchResponse>>() {
            @Override
            public void onResponse(Call<List<LionSearchResponse>> call, Response<List<LionSearchResponse>> response) {
                if (response.code() == 200) {
                    List<LionSearchResponse> data = response.body();

                    mAdapter.addAll(data);
                } else {
                    Toast.makeText(getContext(), "No Lion Data Found", Toast.LENGTH_SHORT).show();
                }
                addProgress();
            }

            @Override
            public void onFailure(Call<List<LionSearchResponse>> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.toString(), Toast.LENGTH_SHORT).show();
//                Log.e("ASDF", "" + t.toString());
                addProgress();

            }
        });
    }

    private void initProgress() {
        mData.clear();
        currentProgress = 0;
        mPbProgress.setIndeterminate(true);
        mPbProgress.setVisibility(View.VISIBLE);
    }

    private void addProgress() {
        currentProgress++;
        if (currentProgress == TOTAL_PROGRESS) {
            mPbProgress.setVisibility(View.GONE);
            mCallback.showControlLayout(true);
        }
    }
}
