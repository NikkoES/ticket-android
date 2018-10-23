
package com.roka.ticketing.rest.response.flight.helperpojo.issuing;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Item {

    @SerializedName("CheckInStatus")
    private CheckInStatus mCheckInStatus;
    @SerializedName("CityFrom")
    private CityFrom mCityFrom;
    @SerializedName("CityFromName")
    private CityFromName mCityFromName;
    @SerializedName("CityTo")
    private CityTo mCityTo;
    @SerializedName("CityToName")
    private CityToName mCityToName;
    @SerializedName("PassengerClass")
    private PassengerClass mPassengerClass;
    @SerializedName("Description")
    private Description mDescription;
    @SerializedName("FirstName")
    private FirstName mFirstName;
    @SerializedName("FlightNo")
    private FlightNo mFlightNo;
    @SerializedName("FlownDate")
    private FlownDate mFlownDate;
    @SerializedName("LastName")
    private LastName mLastName;
    @SerializedName("No")
    private No mNo;
    @SerializedName("ReservationStatus")
    private ReservationStatus mReservationStatus;
    @SerializedName("SeatQty")
    private SeatQty mSeatQty;
    @SerializedName("Segment")
    private Segment mSegment;
    @SerializedName("SpecialRequest")
    private SpecialRequest mSpecialRequest;
    @SerializedName("StaLT")
    private StaLT mStaLT;
    @SerializedName("StdLT")
    private StdLT mStdLT;
    @SerializedName("Suffix")
    private Suffix mSuffix;
    @SerializedName("TicketNumber")
    private TicketNumber mTicketNumber;
    @SerializedName("Type")
    private Type mType;
    @SerializedName("Value")
    private Value mValue;

    public CheckInStatus getCheckInStatus() {
        return mCheckInStatus;
    }

    public CityFrom getCityFrom() {
        return mCityFrom;
    }

    public CityFromName getCityFromName() {
        return mCityFromName;
    }

    public CityTo getCityTo() {
        return mCityTo;
    }

    public CityToName getCityToName() {
        return mCityToName;
    }

    public PassengerClass getPassengerClass() {
        return mPassengerClass;
    }

    public Description getDescription() {
        return mDescription;
    }

    public FirstName getFirstName() {
        return mFirstName;
    }

    public FlightNo getFlightNo() {
        return mFlightNo;
    }

    public FlownDate getFlownDate() {
        return mFlownDate;
    }

    public LastName getLastName() {
        return mLastName;
    }

    public No getNo() {
        return mNo;
    }

    public ReservationStatus getReservationStatus() {
        return mReservationStatus;
    }

    public SeatQty getSeatQty() {
        return mSeatQty;
    }

    public Segment getSegment() {
        return mSegment;
    }

    public SpecialRequest getSpecialRequest() {
        return mSpecialRequest;
    }

    public StaLT getStaLT() {
        return mStaLT;
    }

    public StdLT getStdLT() {
        return mStdLT;
    }

    public Suffix getSuffix() {
        return mSuffix;
    }

    public TicketNumber getTicketNumber() {
        return mTicketNumber;
    }

    public Type getType() {
        return mType;
    }

    public Value getValue() {
        return mValue;
    }

    public static class Builder {

        private CheckInStatus mCheckInStatus;
        private CityFrom mCityFrom;
        private CityFromName mCityFromName;
        private CityTo mCityTo;
        private CityToName mCityToName;
        private PassengerClass mPassengerClass;
        private Description mDescription;
        private FirstName mFirstName;
        private FlightNo mFlightNo;
        private FlownDate mFlownDate;
        private LastName mLastName;
        private No mNo;
        private ReservationStatus mReservationStatus;
        private SeatQty mSeatQty;
        private Segment mSegment;
        private SpecialRequest mSpecialRequest;
        private StaLT mStaLT;
        private StdLT mStdLT;
        private Suffix mSuffix;
        private TicketNumber mTicketNumber;
        private Type mType;
        private Value mValue;

        public Item.Builder withCheckInStatus(CheckInStatus CheckInStatus) {
            mCheckInStatus = CheckInStatus;
            return this;
        }

        public Item.Builder withCityFrom(CityFrom CityFrom) {
            mCityFrom = CityFrom;
            return this;
        }

        public Item.Builder withCityFromName(CityFromName CityFromName) {
            mCityFromName = CityFromName;
            return this;
        }

        public Item.Builder withCityTo(CityTo CityTo) {
            mCityTo = CityTo;
            return this;
        }

        public Item.Builder withCityToName(CityToName CityToName) {
            mCityToName = CityToName;
            return this;
        }

        public Item.Builder withClass(PassengerClass PassengerClass) {
            mPassengerClass = PassengerClass;
            return this;
        }

        public Item.Builder withDescription(Description Description) {
            mDescription = Description;
            return this;
        }

        public Item.Builder withFirstName(FirstName FirstName) {
            mFirstName = FirstName;
            return this;
        }

        public Item.Builder withFlightNo(FlightNo FlightNo) {
            mFlightNo = FlightNo;
            return this;
        }

        public Item.Builder withFlownDate(FlownDate FlownDate) {
            mFlownDate = FlownDate;
            return this;
        }

        public Item.Builder withLastName(LastName LastName) {
            mLastName = LastName;
            return this;
        }

        public Item.Builder withNo(No No) {
            mNo = No;
            return this;
        }

        public Item.Builder withReservationStatus(ReservationStatus ReservationStatus) {
            mReservationStatus = ReservationStatus;
            return this;
        }

        public Item.Builder withSeatQty(SeatQty SeatQty) {
            mSeatQty = SeatQty;
            return this;
        }

        public Item.Builder withSegment(Segment Segment) {
            mSegment = Segment;
            return this;
        }

        public Item.Builder withSpecialRequest(SpecialRequest SpecialRequest) {
            mSpecialRequest = SpecialRequest;
            return this;
        }

        public Item.Builder withStaLT(StaLT StaLT) {
            mStaLT = StaLT;
            return this;
        }

        public Item.Builder withStdLT(StdLT StdLT) {
            mStdLT = StdLT;
            return this;
        }

        public Item.Builder withSuffix(Suffix Suffix) {
            mSuffix = Suffix;
            return this;
        }

        public Item.Builder withTicketNumber(TicketNumber TicketNumber) {
            mTicketNumber = TicketNumber;
            return this;
        }

        public Item.Builder withType(Type Type) {
            mType = Type;
            return this;
        }

        public Item.Builder withValue(Value Value) {
            mValue = Value;
            return this;
        }

        public Item build() {
            Item Item = new Item();
            Item.mCheckInStatus = mCheckInStatus;
            Item.mCityFrom = mCityFrom;
            Item.mCityFromName = mCityFromName;
            Item.mCityTo = mCityTo;
            Item.mCityToName = mCityToName;
            Item.mPassengerClass = mPassengerClass;
            Item.mDescription = mDescription;
            Item.mFirstName = mFirstName;
            Item.mFlightNo = mFlightNo;
            Item.mFlownDate = mFlownDate;
            Item.mLastName = mLastName;
            Item.mNo = mNo;
            Item.mReservationStatus = mReservationStatus;
            Item.mSeatQty = mSeatQty;
            Item.mSegment = mSegment;
            Item.mSpecialRequest = mSpecialRequest;
            Item.mStaLT = mStaLT;
            Item.mStdLT = mStdLT;
            Item.mSuffix = mSuffix;
            Item.mTicketNumber = mTicketNumber;
            Item.mType = mType;
            Item.mValue = mValue;
            return Item;
        }

    }

}
