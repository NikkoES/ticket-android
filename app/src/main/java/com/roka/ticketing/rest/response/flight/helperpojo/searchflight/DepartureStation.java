
package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DepartureStation implements Serializable {

    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public void setvalue(String value) {
        mvalue = value;
    }

}
