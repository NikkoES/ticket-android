
package com.roka.ticketing.rest.response.flight.helperpojo.issuing;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Segment {

    @SerializedName("item")
    private Item mItem;

    public Item getItem() {
        return mItem;
    }

    public static class Builder {

        private Item mItem;

        public Segment.Builder withItem(Item item) {
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
