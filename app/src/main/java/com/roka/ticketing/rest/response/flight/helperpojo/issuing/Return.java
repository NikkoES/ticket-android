
package com.roka.ticketing.rest.response.flight.helperpojo.issuing;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Return {

    @SerializedName("BookingCode")
    private BookingCode mBookingCode;
    @SerializedName("ErrorCode")
    private ErrorCode mErrorCode;
    @SerializedName("ErrorMessage")
    private ErrorMessage mErrorMessage;
    @SerializedName("Username")
    private Username mUsername;
    @SerializedName("YourItineraryDetails")
    private YourItineraryDetails mYourItineraryDetails;

    public BookingCode getBookingCode() {
        return mBookingCode;
    }

    public ErrorCode getErrorCode() {
        return mErrorCode;
    }

    public ErrorMessage getErrorMessage() {
        return mErrorMessage;
    }

    public Username getUsername() {
        return mUsername;
    }

    public YourItineraryDetails getYourItineraryDetails() {
        return mYourItineraryDetails;
    }

    public static class Builder {

        private BookingCode mBookingCode;
        private ErrorCode mErrorCode;
        private ErrorMessage mErrorMessage;
        private Username mUsername;
        private YourItineraryDetails mYourItineraryDetails;

        public Return.Builder withBookingCode(BookingCode BookingCode) {
            mBookingCode = BookingCode;
            return this;
        }

        public Return.Builder withErrorCode(ErrorCode ErrorCode) {
            mErrorCode = ErrorCode;
            return this;
        }

        public Return.Builder withErrorMessage(ErrorMessage ErrorMessage) {
            mErrorMessage = ErrorMessage;
            return this;
        }

        public Return.Builder withUsername(Username Username) {
            mUsername = Username;
            return this;
        }

        public Return.Builder withYourItineraryDetails(YourItineraryDetails YourItineraryDetails) {
            mYourItineraryDetails = YourItineraryDetails;
            return this;
        }

        public Return build() {
            Return Return = new Return();
            Return.mBookingCode = mBookingCode;
            Return.mErrorCode = mErrorCode;
            Return.mErrorMessage = mErrorMessage;
            Return.mUsername = mUsername;
            Return.mYourItineraryDetails = mYourItineraryDetails;
            return Return;
        }

    }

}
