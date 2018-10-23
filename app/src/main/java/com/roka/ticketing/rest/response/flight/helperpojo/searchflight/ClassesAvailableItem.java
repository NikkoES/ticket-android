package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by roka on 15/03/18.
 */

public class ClassesAvailableItem implements Serializable {

    @SerializedName("item")
    private List<ClassesAvailableItemItem> mItem;

    @SerializedName("totalAvailSeat")
    private int totalAvailSeat;

    public List<ClassesAvailableItemItem> getClassesAvailableItemItem() {
        return mItem;
    }

    public int getTotalAvailSeat() {
        return totalAvailSeat;
    }
}
