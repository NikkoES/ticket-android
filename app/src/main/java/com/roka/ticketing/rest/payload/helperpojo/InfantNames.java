
package com.roka.ticketing.rest.payload.helperpojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InfantNames {

    @SerializedName("Dob")
    private String mDob;
    @SerializedName("FirstName")
    private String mFirstName;
    @SerializedName("LastName")
    private String mLastName;
    @SerializedName("AdultRefference")
    private String mAdultRefference;

    public String getDob() {
        return mDob;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getAdultRefference() {
        return mAdultRefference;
    }

    public static class Builder {

        private String mDob = "-";
        private String mFirstName;
        private String mLastName;
        private String mAdultRefference;

        public InfantNames.Builder withDob(String Dob) {
            mDob = Dob;
            return this;
        }

        public InfantNames.Builder withFirstName(String FirstName) {
            mFirstName = FirstName;
            return this;
        }

        public InfantNames.Builder withLastName(String LastName) {
            mLastName = LastName;
            return this;
        }

        public InfantNames.Builder withAdultRefference(String adultRefference) {
            mAdultRefference = adultRefference;
            return this;
        }

        public InfantNames build() {
            InfantNames infantNames = new InfantNames();
            infantNames.mDob = mDob;
            infantNames.mFirstName = mFirstName;
            infantNames.mLastName = mLastName;
            infantNames.mAdultRefference = mAdultRefference;
            return infantNames;
        }

    }

}
