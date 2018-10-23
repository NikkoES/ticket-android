package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by roka on 15/03/18.
 */

public class SegmentsItem implements Serializable {
    @SerializedName("CarrierCode")
    private CarrierCode mCarrierCode;
    @SerializedName("NoFlight")
    private NoFlight mNoFlight;
    @SerializedName("DepartureStation")
    private DepartureStation mDepartureStation;
    @SerializedName("ArrivalStation")
    private ArrivalStation mArrivalStation;
    @SerializedName("Sta")
    private Sta mSta;
    @SerializedName("Std")
    private Std mStd;
    @SerializedName("Legs")
    private Legs mLegs;

    public CarrierCode getmCarrierCode() {
        return mCarrierCode;
    }

    public void setmCarrierCode(CarrierCode mCarrierCode) {
        this.mCarrierCode = mCarrierCode;
    }

    public NoFlight getmNoFlight() {
        return mNoFlight;
    }

    public void setmNoFlight(NoFlight mNoFlight) {
        this.mNoFlight = mNoFlight;
    }

    public DepartureStation getmDepartureStation() {
        return mDepartureStation;
    }

    public void setmDepartureStation(DepartureStation mDepartureStation) {
        this.mDepartureStation = mDepartureStation;
    }

    public ArrivalStation getmArrivalStation() {
        return mArrivalStation;
    }

    public void setmArrivalStation(ArrivalStation mArrivalStation) {
        this.mArrivalStation = mArrivalStation;
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

    public Legs getmLegs() {
        return mLegs;
    }

    public void setmLegs(Legs mLegs) {
        this.mLegs = mLegs;
    }
}
