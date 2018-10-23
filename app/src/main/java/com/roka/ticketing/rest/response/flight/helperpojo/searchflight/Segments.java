
package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Segments implements Serializable {

    @SerializedName("item")
    private List<SegmentsItem> mItem;

    public List<SegmentsItem> getItem() {
        return mItem;
    }

    public void setItem(List<SegmentsItem> item) {
        mItem = item;
    }

}
