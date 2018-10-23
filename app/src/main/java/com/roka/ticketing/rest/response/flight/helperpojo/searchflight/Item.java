
package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Item implements Serializable {

    @SerializedName("ArrivalStation")
    private ArrivalStation mArrivalStation;
    @SerializedName("Availability")
    private Availability mAvailability;
    @SerializedName("CarrierCode")
    private CarrierCode mCarrierCode;
    @SerializedName("Category")
    private Category mCategory;
    @SerializedName("CityFrom")
    private CityFrom mCityFrom;
    @SerializedName("CityTo")
    private CityTo mCityTo;
    @SerializedName("PassengerClass")
    private PassengerClass mPassengerClass;
    @SerializedName("ClassesAvailable")
    private ClassesAvailable mClassesAvailable;
    @SerializedName("Currency")
    private Currency mCurrency;
    @SerializedName("DepartureStation")
    private DepartureStation mDepartureStation;
    @SerializedName("FlightRoute")
    private FlightRoute mFlightRoute;
    @SerializedName("FlightTime")
    private FlightTime mFlightTime;
    @SerializedName("item")
    private List<Item> mItem;
    @SerializedName("Key")
    private Key mKey;
    @SerializedName("Legs")
    private Legs mLegs;
    @SerializedName("NoFlight")
    private NoFlight mNoFlight;
    @SerializedName("Price")
    private Price mPrice;
    @SerializedName("SeatAvail")
    private SeatAvail mSeatAvail;
    @SerializedName("Segments")
    private Segments mSegments;
    @SerializedName("Sta")
    private Sta mSta;
    @SerializedName("StatusAvail")
    private StatusAvail mStatusAvail;
    @SerializedName("Std")
    private Std mStd;

    public ArrivalStation getArrivalStation() {
        return mArrivalStation;
    }

    public void setArrivalStation(ArrivalStation ArrivalStation) {
        mArrivalStation = ArrivalStation;
    }

    public Availability getAvailability() {
        return mAvailability;
    }

    public void setAvailability(Availability Availability) {
        mAvailability = Availability;
    }

    public CarrierCode getCarrierCode() {
        return mCarrierCode;
    }

    public void setCarrierCode(CarrierCode CarrierCode) {
        mCarrierCode = CarrierCode;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category Category) {
        mCategory = Category;
    }

    public CityFrom getCityFrom() {
        return mCityFrom;
    }

    public void setCityFrom(CityFrom CityFrom) {
        mCityFrom = CityFrom;
    }

    public CityTo getCityTo() {
        return mCityTo;
    }

    public void setCityTo(CityTo CityTo) {
        mCityTo = CityTo;
    }

    public PassengerClass getPassengerClass() {
        return mPassengerClass;
    }

    public void setClass(PassengerClass PassengerClass) {
        mPassengerClass = PassengerClass;
    }

    public ClassesAvailable getClassesAvailable() {
        return mClassesAvailable;
    }

    public void setClassesAvailable(ClassesAvailable ClassesAvailable) {
        mClassesAvailable = ClassesAvailable;
    }

    public Currency getCurrency() {
        return mCurrency;
    }

    public void setCurrency(Currency Currency) {
        mCurrency = Currency;
    }

    public DepartureStation getDepartureStation() {
        return mDepartureStation;
    }

    public void setDepartureStation(DepartureStation DepartureStation) {
        mDepartureStation = DepartureStation;
    }

    public FlightRoute getFlightRoute() {
        return mFlightRoute;
    }

    public void setFlightRoute(FlightRoute FlightRoute) {
        mFlightRoute = FlightRoute;
    }

    public FlightTime getFlightTime() {
        return mFlightTime;
    }

    public void setFlightTime(FlightTime FlightTime) {
        mFlightTime = FlightTime;
    }

    public List<Item> getItem() {
        return mItem;
    }

    public void setItem(List<Item> item) {
        mItem = item;
    }

    public Key getKey() {
        return mKey;
    }

    public void setKey(Key Key) {
        mKey = Key;
    }

    public Legs getLegs() {
        return mLegs;
    }

    public void setLegs(Legs Legs) {
        mLegs = Legs;
    }

    public NoFlight getNoFlight() {
        return mNoFlight;
    }

    public void setNoFlight(NoFlight NoFlight) {
        mNoFlight = NoFlight;
    }

    public Price getPrice() {
        return mPrice;
    }

    public void setPrice(Price Price) {
        mPrice = Price;
    }

    public SeatAvail getSeatAvail() {
        return mSeatAvail;
    }

    public void setSeatAvail(SeatAvail SeatAvail) {
        mSeatAvail = SeatAvail;
    }

    public Segments getSegments() {
        return mSegments;
    }

    public void setSegments(Segments Segments) {
        mSegments = Segments;
    }

    public Sta getSta() {
        return mSta;
    }

    public void setSta(Sta Sta) {
        mSta = Sta;
    }

    public StatusAvail getStatusAvail() {
        return mStatusAvail;
    }

    public void setStatusAvail(StatusAvail StatusAvail) {
        mStatusAvail = StatusAvail;
    }

    public Std getStd() {
        return mStd;
    }

    public void setStd(Std Std) {
        mStd = Std;
    }

}
