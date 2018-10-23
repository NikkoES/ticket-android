
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class TicketNumber {

    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public static class Builder {

        private String mvalue;

        public TicketNumber.Builder withvalue(String value) {
            mvalue = value;
            return this;
        }

        public TicketNumber build() {
            TicketNumber TicketNumber = new TicketNumber();
            TicketNumber.mvalue = mvalue;
            return TicketNumber;
        }

    }

}
