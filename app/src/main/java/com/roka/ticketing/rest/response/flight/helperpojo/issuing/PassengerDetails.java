
package com.roka.ticketing.rest.response.flight.helperpojo.issuing;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PassengerDetails {

    @SerializedName("item")
    private Item mItem;

    public Item getItem() {
        return mItem;
    }

    public static class Builder {

        private Item mItem;

        public PassengerDetails.Builder withItem(Item item) {
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
