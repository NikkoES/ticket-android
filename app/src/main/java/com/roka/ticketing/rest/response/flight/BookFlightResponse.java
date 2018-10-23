
package com.roka.ticketing.rest.response.flight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.roka.ticketing.rest.response.flight.helperpojo.bookflight.Return;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BookFlightResponse {

    @SerializedName("return")
    private Return mReturn;

    public Return getReturn() {
        return mReturn;
    }

    public static class Builder {

        private Return mReturn;

        public BookFlightResponse.Builder withReturn(Return ret) {
            mReturn = ret;
            return this;
        }

        public BookFlightResponse build() {
            BookFlightResponse BookFlightResponse = new BookFlightResponse();
            BookFlightResponse.mReturn = mReturn;
            return BookFlightResponse;
        }

    }

}
