
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Segment {

    @SerializedName("item")
    private List<Item> mItem;

    public List<Item> getItem() {
        return mItem;
    }

    public static class Builder {

        private List<Item> mItem;

        public Segment.Builder withItem(List<Item> item) {
            mItem = item;
            return this;
        }

        public Segment build() {
            Segment Segment = new Segment();
            Segment.mItem = mItem;
            return Segment;
        }

    }

}
