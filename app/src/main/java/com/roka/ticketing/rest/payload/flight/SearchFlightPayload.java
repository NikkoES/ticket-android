
package com.roka.ticketing.rest.payload.flight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class SearchFlightPayload implements Serializable {

    @SerializedName("Adult")
    private int mAdult;
    @SerializedName("Child")
    private int mChild = 0;
    @SerializedName("Infant")
    private int mInfant = 0;
    @SerializedName("CityFrom")
    private String mCityFrom;
    @SerializedName("CityTo")
    private String mCityTo;
    @SerializedName("DepartDate")
    private String mDepartDate;
    @SerializedName("PromoCode")
    private String mPromoCode = "?";
    @SerializedName("ReturnDate")
    private String mReturnDate = "?";
    @SerializedName("ReturnStatus")
    private String mReturnStatus = "No";

    public int getAdult() {
        return mAdult;
    }

    public int getChild() {
        return mChild;
    }

    public int getInfant() {
        return mInfant;
    }

    public String getCityFrom() {
        return mCityFrom;
    }

    public String getCityTo() {
        return mCityTo;
    }

    public String getDepartDate() {
        return mDepartDate;
    }

    public String getPromoCode() {
        return mPromoCode;
    }

    public String getReturnDate() {
        return mReturnDate;
    }

    public String getReturnStatus() {
        return mReturnStatus;
    }

    public static class Builder {

        private int mAdult;
        private int mChild = 0;
        private int mInfant = 0;
        private String mCityFrom;
        private String mCityTo;
        private String mDepartDate;
        private String mPromoCode = "?";
        private String mReturnDate = "?";
        private String mReturnStatus = "No";

        public Builder(int adult, String from, String to, String departDate) {
            mAdult = adult;
            mCityFrom = from;
            mCityTo = to;
            mDepartDate = departDate;
        }

        public SearchFlightPayload.Builder withAdult(int Adult) {
            mAdult = Adult;
            return this;
        }

        public SearchFlightPayload.Builder withChild(int Child) {
            mChild = Child;
            return this;
        }

        public SearchFlightPayload.Builder withInfant(int Infant) {
            mInfant = Infant;
            return this;
        }

        public SearchFlightPayload.Builder withCityFrom(String CityFrom) {
            mCityFrom = CityFrom;
            return this;
        }

        public SearchFlightPayload.Builder withCityTo(String CityTo) {
            mCityTo = CityTo;
            return this;
        }

        public SearchFlightPayload.Builder withDepartDate(String DepartDate) {
            mDepartDate = DepartDate;
            return this;
        }

        public SearchFlightPayload.Builder withPromoCode(String PromoCode) {
            mPromoCode = PromoCode;
            return this;
        }

        public SearchFlightPayload.Builder withReturnDate(String ReturnDate) {
            mReturnDate = ReturnDate;
            return this;
        }

        public SearchFlightPayload.Builder withReturnStatus(String ReturnStatus) {
            mReturnStatus = ReturnStatus;
            return this;
        }

        public SearchFlightPayload build() {
            SearchFlightPayload SearchFlightPayload = new SearchFlightPayload();
            SearchFlightPayload.mAdult = mAdult;
            SearchFlightPayload.mChild = mChild;
            SearchFlightPayload.mCityFrom = mCityFrom;
            SearchFlightPayload.mCityTo = mCityTo;
            SearchFlightPayload.mDepartDate = mDepartDate;
            SearchFlightPayload.mInfant = mInfant;
            SearchFlightPayload.mPromoCode = mPromoCode;
            SearchFlightPayload.mReturnDate = mReturnDate;
            SearchFlightPayload.mReturnStatus = mReturnStatus;
            return SearchFlightPayload;
        }

    }

}
