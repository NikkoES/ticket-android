
package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Return implements Serializable {

    @SerializedName("Adult")
    private Adult mAdult;
    @SerializedName("Child")
    private Child mChild;
    @SerializedName("ErrorCode")
    private ErrorCode mErrorCode;
    @SerializedName("ErrorMessage")
    private ErrorMessage mErrorMessage;
    @SerializedName("Infant")
    private Infant mInfant;
    @SerializedName("SearchKey")
    private SearchKey mSearchKey;
    @SerializedName("TripDetail")
    private TripDetail mTripDetail;
    @SerializedName("Username")
    private Username mUsername;

    public Adult getAdult() {
        return mAdult;
    }

    public void setAdult(Adult Adult) {
        mAdult = Adult;
    }

    public Child getChild() {
        return mChild;
    }

    public void setChild(Child Child) {
        mChild = Child;
    }

    public ErrorCode getErrorCode() {
        return mErrorCode;
    }

    public void setErrorCode(ErrorCode ErrorCode) {
        mErrorCode = ErrorCode;
    }

    public ErrorMessage getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(ErrorMessage ErrorMessage) {
        mErrorMessage = ErrorMessage;
    }

    public Infant getInfant() {
        return mInfant;
    }

    public void setInfant(Infant Infant) {
        mInfant = Infant;
    }

    public SearchKey getSearchKey() {
        return mSearchKey;
    }

    public void setSearchKey(SearchKey SearchKey) {
        mSearchKey = SearchKey;
    }

    public TripDetail getTripDetail() {
        return mTripDetail;
    }

    public void setTripDetail(TripDetail TripDetail) {
        mTripDetail = TripDetail;
    }

    public Username getUsername() {
        return mUsername;
    }

    public void setUsername(Username Username) {
        mUsername = Username;
    }

}
