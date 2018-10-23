
package com.roka.ticketing.rest.payload.train;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.roka.ticketing.rest.payload.flight.BookFlightPayload;
import com.roka.ticketing.rest.payload.helperpojo.AdultNames;
import com.roka.ticketing.rest.payload.helperpojo.InfantNames;
import com.roka.ticketing.rest.payload.helperpojo.Keys;

import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BookingRail {

    @Expose
    private String token;

    @SerializedName("data_schedule_depart")
    private DataScheduleDepart dataScheduleDepart;

    @SerializedName("data_caller")
    private DataCaller dataCaller;

    @SerializedName("data_passenger")
    private DataPassenger dataPassenger;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DataScheduleDepart getDataScheduleDepart() {
        return dataScheduleDepart;
    }

    public void setDataScheduleDepart(DataScheduleDepart dataScheduleDepart) {
        this.dataScheduleDepart = dataScheduleDepart;
    }

    public DataCaller getDataCaller() {
        return dataCaller;
    }

    public void setDataCaller(DataCaller dataCaller) {
        this.dataCaller = dataCaller;
    }

    public DataPassenger getDataPassenger() {
        return dataPassenger;
    }

    public void setDataPassenger(DataPassenger dataPassenger) {
        this.dataPassenger = dataPassenger;
    }

    public static class Builder {

        private String mToken;
        private DataScheduleDepart mDataScheduleDepart;
        private DataCaller mDataCaller ;
        private DataPassenger mDataPassenger;
        private List<Adult> listAdult;
        private List<Infant> listInfant;

        public BookingRail.Builder withToken(String token) {
            mToken = token;
            return this;
        }

        public BookingRail.Builder withAdultNames(List<Adult> AdultNames) {
            listAdult = AdultNames;
            return this;
        }

        public BookingRail.Builder withChildNames(List<Infant> infantNames) {
            listInfant = infantNames;
            return this;
        }

        public BookingRail.Builder withDataScheduleDepart(DataScheduleDepart dataScheduleDepart) {
            mDataScheduleDepart = dataScheduleDepart;
            return this;
        }

        public BookingRail.Builder withDataCaller(DataCaller dataCaller) {
            mDataCaller = dataCaller;
            return this;
        }

        public BookingRail.Builder withDataPassenger(DataPassenger dataPassenger) {
            mDataPassenger = dataPassenger;
            return this;
        }

        public BookingRail build() {
            BookingRail bookingRail = new BookingRail();
            bookingRail.token = mToken;
            bookingRail.dataScheduleDepart = mDataScheduleDepart;
            bookingRail.dataCaller = mDataCaller;
            bookingRail.dataPassenger = mDataPassenger;
            bookingRail.dataPassenger.setAdult(listAdult);
            bookingRail.dataPassenger.setInfant(listInfant);
            return bookingRail;
        }

    }
}
