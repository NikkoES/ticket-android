
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Journey {

    @SerializedName("item")
    private Item mItem;

    public Item getItem() {
        return mItem;
    }

    public static class Builder {

        private Item mItem;

        public Journey.Builder withItem(Item item) {
            mItem = item;
            return this;
        }

        public Journey build() {
            Journey Journey = new Journey();
            Journey.mItem = mItem;
            return Journey;
        }

    }

}
