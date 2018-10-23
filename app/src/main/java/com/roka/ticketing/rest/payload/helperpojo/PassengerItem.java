
package com.roka.ticketing.rest.payload.helperpojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PassengerItem {

    @SerializedName("Dob")
    private String mDob;
    @SerializedName("FirstName")
    private String mFirstName;
    @SerializedName("IdNo")
    private String mIdNo;
    @SerializedName("LastName")
    private String mLastName;
    @SerializedName("Suffix")
    private String mSuffix;

    public String getDob() {
        return mDob;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getIdNo() {
        return mIdNo;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getSuffix() {
        return mSuffix;
    }

    public static class Builder {

        private String mDob = "-";
        private String mFirstName;
        private String mIdNo;
        private String mLastName;
        private String mSuffix;

        public PassengerItem.Builder withDob(String Dob) {
            mDob = Dob;
            return this;
        }

        public PassengerItem.Builder withFirstName(String FirstName) {
            mFirstName = FirstName;
            return this;
        }

        public PassengerItem.Builder withIdNo(String IdNo) {
            mIdNo = IdNo;
            return this;
        }

        public PassengerItem.Builder withLastName(String LastName) {
            mLastName = LastName;
            return this;
        }

        public PassengerItem.Builder withSuffix(String Suffix) {
            mSuffix = Suffix;
            return this;
        }

        public PassengerItem build() {
            PassengerItem PassengerItem = new PassengerItem();
            PassengerItem.mDob = mDob;
            PassengerItem.mFirstName = mFirstName;
            PassengerItem.mIdNo = mIdNo;
            PassengerItem.mLastName = mLastName;
            PassengerItem.mSuffix = mSuffix;
            return PassengerItem;
        }

    }

}
