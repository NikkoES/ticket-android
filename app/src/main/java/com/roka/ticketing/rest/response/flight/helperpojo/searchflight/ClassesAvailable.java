
package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ClassesAvailable implements Serializable{

    @SerializedName("item")
    private List<ClassesAvailableItem> mItem;

    public List<ClassesAvailableItem> getClassesAvailableItem() {
        return mItem;
    }

    public void setItem(List<ClassesAvailableItem> item) {
        mItem = item;
    }

}
