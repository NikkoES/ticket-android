
package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Legs implements Serializable {

    @SerializedName("item")
    private List<LegsItem> mItem;

    public List<LegsItem> getItem() {
        return mItem;
    }

    public void setItem(List<LegsItem> item) {
        mItem = item;
    }

}
