
package com.roka.ticketing.rest.payload.helperpojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class AdultNames {

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

        public AdultNames.Builder withDob(String Dob) {
            mDob = Dob;
            return this;
        }

        public AdultNames.Builder withFirstName(String FirstName) {
            mFirstName = FirstName;
            return this;
        }

        public AdultNames.Builder withIdNo(String IdNo) {
            mIdNo = IdNo;
            return this;
        }

        public AdultNames.Builder withLastName(String LastName) {
            mLastName = LastName;
            return this;
        }

        public AdultNames.Builder withSuffix(String Suffix) {
            mSuffix = Suffix;
            return this;
        }

        public AdultNames build() {
            AdultNames AdultNames = new AdultNames();
            AdultNames.mDob = mDob;
            AdultNames.mFirstName = mFirstName;
            AdultNames.mIdNo = mIdNo;
            AdultNames.mLastName = mLastName;
            AdultNames.mSuffix = mSuffix;
            return AdultNames;
        }

    }

}
