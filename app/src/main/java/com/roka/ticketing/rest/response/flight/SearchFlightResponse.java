
package com.roka.ticketing.rest.response.flight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.roka.ticketing.rest.response.flight.helperpojo.searchflight.Return;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SearchFlightResponse {

    @SerializedName("return")
    private Return mReturn;

    public Return getReturn() {
        return mReturn;
    }

    public void setReturn(Return returnFlight) {
        mReturn = returnFlight;
    }

}
