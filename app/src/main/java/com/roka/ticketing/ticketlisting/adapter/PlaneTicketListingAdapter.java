package com.roka.ticketing.ticketlisting.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.roka.ticketing.R;
import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.response.flight.LionSearchResponse;
import com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FlightRouteItem;
import com.roka.ticketing.ticketlisting.interfaces.TicketListingInterface;
import com.roka.ticketing.ticketlisting.viewholder.PlaneTicketListingViewHolder;
import com.roka.ticketing.utilities.StringUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by roka on 25/02/18.
 */

public class PlaneTicketListingAdapter extends BaseTicketListingAdapter
        implements View.OnClickListener {
    private final Context mContext;
    private SearchFlightPayload mPayload;
    private List<FlightRouteItem> mData = null;
    private List<LionSearchResponse> mData2;

    public PlaneTicketListingAdapter(TicketListingInterface callback, List<FlightRouteItem> data, Context context,
                                     SearchFlightPayload payload) {
        super(callback);
        mData = data;
        mData2 = new ArrayList<>();
        mContext = context;
        mPayload = payload;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_ticketlisting_plane, parent, false);
        return new PlaneTicketListingViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PlaneTicketListingViewHolder vh = (PlaneTicketListingViewHolder) holder;

        if (position < mData.size()) {
            FlightRouteItem item = mData.get(position);

            String brand = item.getmSegments().getItem().get(0).getmCarrierCode().getvalue() +
                    item.getmSegments().getItem().get(0).getmNoFlight().getvalue();
            vh.brand.setText(brand);

            String sriwijayaUrl = "https://firebasestorage.googleapis.com/v0/b/ticketapp-pasarprodukbumn.appspot.com/o/logos%2Fsriwijaya_air.png?alt=media&token=0ead5d8d-2c09-4d03-8fb3-a5a2792b7a41";
            Glide.with(mContext).load(sriwijayaUrl).into(vh.thumbnail);


            vh.price.setText(StringUtilities.getPriceTotalInCurrency(item));

//        String seats = item.getmClassesAvailable().getClassesAvailableItem().get(0).getClassesAvailableItemItem().size() + " Seats Available";
            String seats = item.getmClassesAvailable().getClassesAvailableItem().get(0).getTotalAvailSeat() + " Seats Available";
            vh.seats.setText(seats);

            String time = StringUtilities.timeResponseToHour(item.getmStd().getvalue()) + " - " +
                    StringUtilities.timeResponseToHour(item.getmSta().getvalue());
            vh.time.setText(time);

            String direct = StringUtilities.directStatus(item) + " (" + StringUtilities.duration(item) + ")";
            vh.direct.setText(direct);

            vh.detail.setOnClickListener(this);
            vh.container.setOnClickListener(this);

            vh.detail.setTag(item);
            vh.container.setTag(item);
        } else {
            LionSearchResponse item = mData2.get(position - mData.size());

            String batikUrl = "https://firebasestorage.googleapis.com/v0/b/ticketapp-pasarprodukbumn.appspot.com/o/logos%2Fbatik_air.png?alt=media&token=00cbef71-2924-497d-95d1-a07ff9a9c27f";
            String lionUrl = "https://firebasestorage.googleapis.com/v0/b/ticketapp-pasarprodukbumn.appspot.com/o/logos%2Flion_air.jpg?alt=media&token=bb64220c-5348-47ca-94c4-0959ba9a4453";
            String citilinkUrl = "https://firebasestorage.googleapis.com/v0/b/ticketapp-pasarprodukbumn.appspot.com/o/logos%2Fcitilink.png?alt=media&token=b1546cf8-1745-4596-a6ee-1d6ac62c8560";


            String brand = item.getFlightData().get(0).getFlightId();
            vh.brand.setText(brand);

            if (item.getFlightData().get(0).getMaskapaiName().equalsIgnoreCase("Batik Air"))
                Glide.with(mContext).load(batikUrl).into(vh.thumbnail);
            else if (item.getFlightData().get(0).getMaskapaiName().equalsIgnoreCase("Citilink"))
                Glide.with(mContext).load(citilinkUrl).into(vh.thumbnail);
            else
                Glide.with(mContext).load(lionUrl).into(vh.thumbnail);

            vh.price.setText("IDR " + item.getPrice());
            String seats = "Seats Available";
            if (item.getAvailable_count() != null)
                seats = item.getAvailable_count() + " " + seats;
            vh.seats.setText(seats);

            int totalFlight = item.getFlightData().size();
            String time = item.getFlightData().get(0).getDepartureTime() + " - " +
                    item.getFlightData().get(totalFlight - 1).getArrivalTime();
            vh.time.setText(time);

            String direct = "Direct";
            if (item.getFlightData().size() > 1)
                direct = totalFlight + " Stops";
            String duration = "";
            if (item.getTotalFlightDuration() != null)
                duration = item.getTotalFlightDuration();
            else
                duration = item.getFlightData().get(0).getFlightDuration().split("Duration: ")[1];
            direct = direct + " (" + duration + ")";
            vh.direct.setText(direct);


            vh.detail.setOnClickListener(this);
            vh.container.setOnClickListener(this);

            vh.detail.setTag(item);
            vh.container.setTag(item);


        }
    }

    @Override
    public int getItemCount() {
        return mData.size() + mData2.size();
    }

    @Override
    public void onClick(View view) {
        if (view.getTag() instanceof FlightRouteItem) {
            FlightRouteItem item = (FlightRouteItem) view.getTag();
            if (item != null)
                mCallback.onPlaneTicketDetail(item, StringUtilities.duration(item), mPayload);
        } else if (view.getTag() instanceof LionSearchResponse){
            LionSearchResponse item = (LionSearchResponse) view.getTag();
            if (item.getFlightData().get(0).getMaskapaiName().equalsIgnoreCase("Citilink")){
                mCallback.onPlaneTicketDetail(item, mPayload);
            }else{
                String firstMaskapai = item.getFlightData().get(0).getMaskapaiName();
                Toast.makeText(mContext, "maskapai = "+firstMaskapai, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void addAll(List<LionSearchResponse> data) {
        mData2.addAll(data);
        Collections.sort(mData2, new Comparator<LionSearchResponse>() {
            @Override
            public int compare(LionSearchResponse o1, LionSearchResponse o2) {
                String strPrice1 = o1.getPrice().replace(".", "");
                String strPrice2 = o2.getPrice().replace(".", "");
                strPrice1 = strPrice1.replace(",", "");
                strPrice2 = strPrice2.replace(",", "");
                long price1 = 0l;
                long price2 = 0l;
                try {
                    price1 = Long.parseLong(strPrice1);
                } catch (NumberFormatException e) {
                }
                try {
                    price2 = Long.parseLong(strPrice2);
                } catch (NumberFormatException e) {
                }
                if (price1 > price2) {
                    return 1;
                } else if (price1 < price2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        notifyDataSetChanged();
    }
}
