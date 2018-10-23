
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ErrorCode {

    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public static class Builder {

        private String mvalue;

        public ErrorCode.Builder withvalue(String value) {
            mvalue = value;
            return this;
        }

        public ErrorCode build() {
            ErrorCode ErrorCode = new ErrorCode();
            ErrorCode.mvalue = mvalue;
            return ErrorCode;
        }

    }

}
