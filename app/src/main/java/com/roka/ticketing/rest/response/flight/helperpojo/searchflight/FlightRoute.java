
package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FlightRoute implements Serializable{

    @SerializedName("item")
    private List<FlightRouteItem> mItem;

    public List<FlightRouteItem> getItem() {
        return mItem;
    }

    public void setItem(List<FlightRouteItem> item) {
        mItem = item;
    }

}
