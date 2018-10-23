
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PassengerDetails {

    @SerializedName("item")
    private List<Item> mItem;

    public List<Item> getItem() {
        return mItem;
    }

    public static class Builder {

        private List<Item> mItem;

        public PassengerDetails.Builder withItem(List<Item> item) {
            mItem = item;
            return this;
        }

        public PassengerDetails build() {
            PassengerDetails PassengerDetails = new PassengerDetails();
            PassengerDetails.mItem = mItem;
            return PassengerDetails;
        }

    }

}
