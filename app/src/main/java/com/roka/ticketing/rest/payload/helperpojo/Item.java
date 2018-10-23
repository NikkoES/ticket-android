
package com.roka.ticketing.rest.payload.helperpojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Item {

    @SerializedName("AdultRefference")
    private String mAdultRefference;
    @SerializedName("Category")
    private String mCategory;
    @SerializedName("Dob")
    private String mDob;
    @SerializedName("FirstName")
    private String mFirstName;
    @SerializedName("IdNo")
    private String mIdNo;
    @SerializedName("Key")
    private String mKey;
    @SerializedName("LastName")
    private String mLastName;
    @SerializedName("Suffix")
    private String mSuffix;

    public String getAdultRefference() {
        return mAdultRefference;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getDob() {
        return mDob;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getIdNo() {
        return mIdNo;
    }

    public String getKey() {
        return mKey;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getSuffix() {
        return mSuffix;
    }

    public static class Builder {

        private String mAdultRefference;
        private String mCategory;
        private String mDob;
        private String mFirstName;
        private String mIdNo;
        private String mKey;
        private String mLastName;
        private String mSuffix;

        public Item.Builder withAdultRefference(String AdultRefference) {
            mAdultRefference = AdultRefference;
            return this;
        }

        public Item.Builder withCategory(String Category) {
            mCategory = Category;
            return this;
        }

        public Item.Builder withDob(String Dob) {
            mDob = Dob;
            return this;
        }

        public Item.Builder withFirstName(String FirstName) {
            mFirstName = FirstName;
            return this;
        }

        public Item.Builder withIdNo(String IdNo) {
            mIdNo = IdNo;
            return this;
        }

        public Item.Builder withKey(String Key) {
            mKey = Key;
            return this;
        }

        public Item.Builder withLastName(String LastName) {
            mLastName = LastName;
            return this;
        }

        public Item.Builder withSuffix(String Suffix) {
            mSuffix = Suffix;
            return this;
        }

        public Item build() {
            Item Item = new Item();
            Item.mAdultRefference = mAdultRefference;
            Item.mCategory = mCategory;
            Item.mDob = mDob;
            Item.mFirstName = mFirstName;
            Item.mIdNo = mIdNo;
            Item.mKey = mKey;
            Item.mLastName = mLastName;
            Item.mSuffix = mSuffix;
            return Item;
        }

    }

}
