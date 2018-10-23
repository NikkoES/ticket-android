
package com.roka.ticketing.rest.payload.helperpojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Keys {

    @SerializedName("Category")
    private String mCategory;
    @SerializedName("Key")
    private String mKey;

    public String getCategory() {
        return mCategory;
    }

    public String getKey() {
        return mKey;
    }

    public static class Builder {

        private String mCategory;
        private String mKey;

        public Keys.Builder withCategory(String Category) {
            mCategory = Category;
            return this;
        }

        public Keys.Builder withKey(String Key) {
            mKey = Key;
            return this;
        }

        public Keys build() {
            Keys Keys = new Keys();
            Keys.mCategory = mCategory;
            Keys.mKey = mKey;
            return Keys;
        }

    }

}
