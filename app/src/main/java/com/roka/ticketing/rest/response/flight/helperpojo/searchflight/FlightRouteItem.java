package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by roka on 15/03/18.
 */

public class FlightRouteItem implements Serializable {

    @SerializedName("CityFrom")
    private CityFrom mCityFrom;

    @SerializedName("CityTo")
    private CityTo mCityTo;

    @SerializedName("Sta")
    private Sta mSta;

    @SerializedName("Std")
    private Std mStd;

    @SerializedName("FlightTime")
    private FlightTime mFlightTime;

    @SerializedName("Segments")
    private Segments mSegments;

    @SerializedName("ClassesAvailable")
    private ClassesAvailable mClassesAvailable;

    public CityFrom getmCityFrom() {
        return mCityFrom;
    }

    public void setmCityFrom(CityFrom mCityFrom) {
        this.mCityFrom = mCityFrom;
    }

    public CityTo getmCityTo() {
        return mCityTo;
    }

    public void setmCityTo(CityTo mCityTo) {
        this.mCityTo = mCityTo;
    }

    public Sta getmSta() {
        return mSta;
    }

    public void setmSta(Sta mSta) {
        this.mSta = mSta;
    }

    public Std getmStd() {
        return mStd;
    }

    public void setmStd(Std mStd) {
        this.mStd = mStd;
    }

    public FlightTime getmFlightTime() {
        return mFlightTime;
    }

    public void setmFlightTime(FlightTime mFlightTime) {
        this.mFlightTime = mFlightTime;
    }

    public Segments getmSegments() {
        return mSegments;
    }

    public void setmSegments(Segments mSegments) {
        this.mSegments = mSegments;
    }

    public ClassesAvailable getmClassesAvailable() {
        return mClassesAvailable;
    }

    public void setmClassesAvailable(ClassesAvailable mClassesAvailable) {
        this.mClassesAvailable = mClassesAvailable;
    }
}
