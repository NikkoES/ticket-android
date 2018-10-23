
package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Nta1 implements Serializable {

    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public static class Builder {

        private String mvalue;

        public Nta1 .Builder withvalue(String value) {
            mvalue = value;
            return this;
        }

        public Nta1 build() {
            Nta1 Nta1 = new Nta1();
            Nta1 .mvalue = mvalue;
            return Nta1;
        }

    }

}
