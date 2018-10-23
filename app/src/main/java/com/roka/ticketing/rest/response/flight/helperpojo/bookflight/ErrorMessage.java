
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ErrorMessage {

    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public static class Builder {

        private String mvalue;

        public ErrorMessage.Builder withvalue(String value) {
            mvalue = value;
            return this;
        }

        public ErrorMessage build() {
            ErrorMessage ErrorMessage = new ErrorMessage();
            ErrorMessage.mvalue = mvalue;
            return ErrorMessage;
        }

    }

}
