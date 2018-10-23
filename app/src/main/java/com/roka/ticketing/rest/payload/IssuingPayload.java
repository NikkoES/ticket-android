
package com.roka.ticketing.rest.payload;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class IssuingPayload {

    public IssuingPayload(String bookCode) {
        this.mBookingCode = bookCode;
    }

    @SerializedName("BookingCode")
    private String mBookingCode;

    public String getBookingCode() {
        return mBookingCode;
    }

    public void setBookingCode(String BookingCode) {
        mBookingCode = BookingCode;
    }

}
