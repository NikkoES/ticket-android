
package com.roka.ticketing.rest.payload.flight;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;
import com.roka.ticketing.rest.payload.helperpojo.AdultNames;
import com.roka.ticketing.rest.payload.helperpojo.InfantNames;
import com.roka.ticketing.rest.payload.helperpojo.Keys;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BookFlightPayload {

    @SerializedName("AdultNames")
    private List<AdultNames> mAdultNames;
    @SerializedName("ChildNames")
    private List<AdultNames> mChildNames;
    @SerializedName("Email")
    private String mEmail;
    @SerializedName("ExtraCoverAddOns")
    private String mExtraCoverAddOns;
    @SerializedName("InfantNames")
    private List<InfantNames> mInfantNames;
    @SerializedName("Keys")
    private List<Keys> mKeys;
    @SerializedName("Received")
    private String mReceived;
    @SerializedName("ReceivedPhone")
    private String mReceivedPhone;
    @SerializedName("SearchKey")
    private String mSearchKey;

    public List<AdultNames> getAdultNames() {
        return mAdultNames;
    }

    public List<AdultNames> getChildNames() {
        return mChildNames;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getExtraCoverAddOns() {
        return mExtraCoverAddOns;
    }

    public List<InfantNames> getInfantNames() {
        return mInfantNames;
    }

    public List<Keys> getKeys() {
        return mKeys;
    }

    public String getReceived() {
        return mReceived;
    }

    public String getReceivedPhone() {
        return mReceivedPhone;
    }

    public String getSearchKey() {
        return mSearchKey;
    }

    public static class Builder {

        private List<AdultNames> mAdultNames;
        private List<AdultNames> mChildNames;
        private String mEmail;
        private String mExtraCoverAddOns = "?";
        private List<InfantNames> mInfantNames;
        private List<Keys> mKeys;
        private String mReceived = "agent";
        private String mReceivedPhone;
        private String mSearchKey;

        public BookFlightPayload.Builder withAdultNames(List<AdultNames> AdultNames) {
            mAdultNames = AdultNames;
            return this;
        }

        public BookFlightPayload.Builder withChildNames(List<AdultNames> ChildNames) {
            mChildNames = ChildNames;
            return this;
        }

        public BookFlightPayload.Builder withEmail(String Email) {
            mEmail = Email;
            return this;
        }

        public BookFlightPayload.Builder withExtraCoverAddOns(String ExtraCoverAddOns) {
            mExtraCoverAddOns = ExtraCoverAddOns;
            return this;
        }

        public BookFlightPayload.Builder withInfantNames(List<InfantNames> InfantNames) {
            mInfantNames = InfantNames;
            return this;
        }

        public BookFlightPayload.Builder withKeys(List<Keys> Keys) {
            mKeys = Keys;
            return this;
        }

        public BookFlightPayload.Builder withReceived(String Received) {
            mReceived = Received;
            return this;
        }

        public BookFlightPayload.Builder withReceivedPhone(String ReceivedPhone) {
            mReceivedPhone = ReceivedPhone;
            return this;
        }

        public BookFlightPayload.Builder withSearchKey(String SearchKey) {
            mSearchKey = SearchKey;
            return this;
        }

        public BookFlightPayload build() {
            BookFlightPayload BookFlightPayload = new BookFlightPayload();
            BookFlightPayload.mAdultNames = mAdultNames;
            BookFlightPayload.mChildNames = mChildNames;
            BookFlightPayload.mEmail = mEmail;
            BookFlightPayload.mExtraCoverAddOns = mExtraCoverAddOns;
            BookFlightPayload.mInfantNames = mInfantNames;
            BookFlightPayload.mKeys = mKeys;
            BookFlightPayload.mReceived = mReceived;
            BookFlightPayload.mReceivedPhone = mReceivedPhone;
            BookFlightPayload.mSearchKey = mSearchKey;
            return BookFlightPayload;
        }

    }

}
