package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by roka on 15/03/18.
 */

public class LegsItem implements Serializable {
    @SerializedName("DepartureStation")
    private DepartureStation mDepartureStation;
    @SerializedName("ArrivalStation")
    private ArrivalStation mArrivalStation;
    @SerializedName("Sta")
    private Sta mSta;
    @SerializedName("Std")
    private Std mStd;

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
}
