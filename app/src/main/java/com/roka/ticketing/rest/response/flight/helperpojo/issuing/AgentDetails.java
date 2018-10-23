
package com.roka.ticketing.rest.response.flight.helperpojo.issuing;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class AgentDetails {

    @SerializedName("BookedBy")
    private BookedBy mBookedBy;
    @SerializedName("IssuedBy")
    private IssuedBy mIssuedBy;

    public BookedBy getBookedBy() {
        return mBookedBy;
    }

    public IssuedBy getIssuedBy() {
        return mIssuedBy;
    }

    public static class Builder {

        private BookedBy mBookedBy;
        private IssuedBy mIssuedBy;

        public AgentDetails.Builder withBookedBy(BookedBy BookedBy) {
            mBookedBy = BookedBy;
            return this;
        }

        public AgentDetails.Builder withIssuedBy(IssuedBy IssuedBy) {
            mIssuedBy = IssuedBy;
            return this;
        }

        public AgentDetails build() {
            AgentDetails AgentDetails = new AgentDetails();
            AgentDetails.mBookedBy = mBookedBy;
            AgentDetails.mIssuedBy = mIssuedBy;
            return AgentDetails;
        }

    }

}
