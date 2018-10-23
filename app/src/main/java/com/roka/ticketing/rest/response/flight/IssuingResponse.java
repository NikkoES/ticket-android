
package com.roka.ticketing.rest.response.flight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.roka.ticketing.rest.response.flight.helperpojo.issuing.Return;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class IssuingResponse {

    @SerializedName("return")
    private Return mReturn;

    public Return getReturn() {
        return mReturn;
    }

    public static class Builder {

        private Return mReturn;

        public IssuingResponse.Builder withReturn(Return ret) {
            mReturn = ret;
            return this;
        }

        public IssuingResponse build() {
            IssuingResponse IssuingResponse = new IssuingResponse();
            IssuingResponse.mReturn = mReturn;
            return IssuingResponse;
        }

    }

}
