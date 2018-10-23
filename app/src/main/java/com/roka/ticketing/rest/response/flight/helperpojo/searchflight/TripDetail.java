
package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class TripDetail implements Serializable {
    @SerializedName("item")
    private List<Item> mItem;

    public List<Item> getItem() {
        return mItem;
    }

    public void setItem(List<Item> item) {
        mItem = item;
    }

}
