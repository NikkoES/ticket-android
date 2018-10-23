package com.roka.ticketing.home.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roka.ticketing.BuildConfig;
import com.roka.ticketing.R;
import com.roka.ticketing.rest.response.train.History;
import com.roka.ticketing.rest.response.train.HistoryTrain;
import com.roka.ticketing.rest.services.RestCalls;
import com.roka.ticketing.rest.services.RestTrainServices;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryTrainAdapter extends RecyclerView.Adapter<HistoryTrainAdapter.ViewHolder> {

    private List<History> listHistory;

    private RestCalls mServices;

    public HistoryTrainAdapter(List<History> listHistory){
        this.listHistory = listHistory;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_booking, parent, false);

        mServices = RestTrainServices.getService();

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final History history = listHistory.get(position);
        Call<HistoryTrain> call = mServices.detailBooking(BuildConfig.API_TRAIN_TOKEN, history.getGdsBook());
        call.enqueue(new Callback<HistoryTrain>() {
            @Override
            public void onResponse(Call<HistoryTrain> call, Response<HistoryTrain> response) {
                if (response.code() == 200) {
                    final HistoryTrain historyTrain = response.body();
                    Log.e("HISTORY", ""+historyTrain.getResultTrain().getRouteInfo().get(0).getDes());
                    holder.tv_rute.setText(historyTrain.getResultTrain().getRouteInfo().get(0).getOrg()+" - "+historyTrain.getResultTrain().getRouteInfo().get(0).getDes());
                    holder.tv_booking_code.setText(historyTrain.getResultTrain().getGdsBookCode());
                    holder.tv_flown.setText(historyTrain.getResultTrain().getRouteInfo().get(0).getDepDate());
                    holder.tv_maskapai_airport.setText(historyTrain.getResultTrain().getRouteInfo().get(0).getTransporterName());
                    holder.tv_status_issued.setText(historyTrain.getResultTrain().getGdsBookStatus());
                }
            }

            @Override
            public void onFailure(Call<HistoryTrain> call, Throwable t) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listHistory.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_rute)
        public TextView tv_rute;

        @BindView(R.id.tv_booking_code)
        public TextView tv_booking_code;

        @BindView(R.id.tv_flown)
        public TextView tv_flown;

        @BindView(R.id.tv_maskapai_airport)
        public TextView tv_maskapai_airport;

        @BindView(R.id.tv_status_issued)
        public TextView tv_status_issued;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
