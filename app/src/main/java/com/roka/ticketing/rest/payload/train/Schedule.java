package com.roka.ticketing.rest.payload.train;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.roka.ticketing.rest.payload.flight.BookFlightPayload;

import java.io.Serializable;

public class Schedule implements Serializable {

    @Expose
    @SerializedName("org")
    private String org;
    @Expose
    @SerializedName("des")
    private String des;
    @Expose
    @SerializedName("vendor")
    private String vendor;
    @Expose
    @SerializedName("dep_datetime")
    private String dep_datetime;
    @Expose
    @SerializedName("arv_datetime")
    private String arv_datetime;
    @Expose
    @SerializedName("class")
    private String kelas;
    @Expose
    @SerializedName("transporter_no")
    private String transporter_no;
    @Expose
    @SerializedName("transporter_name")
    private String transporter_name;
    @Expose
    @SerializedName("subclass")
    private String subclass;
    @Expose
    @SerializedName("adult_fare")
    private String adult_fare;
    @Expose
    @SerializedName("adult_discount")
    private String adult_discount;
    @Expose
    @SerializedName("infant_fare")
    private String infant_fare;
    @Expose
    @SerializedName("infant_discount")
    private String infant_discount;
    @Expose
    @SerializedName("avb")
    private String avb;
    @Expose
    @SerializedName("exceed_booking_time")
    private String exceed_booking_time;

    private int adult_num;
    private int infant_num;
    private String returnStatus;
    private String returnDate;

    public String getOrg() {
        return org;
    }

    public String getDes() {
        return des;
    }

    public String getVendor() {
        return vendor;
    }

    public String getDep_datetime() {
        return dep_datetime;
    }

    public String getArv_datetime() {
        return arv_datetime;
    }

    public String getKelas() {
        return kelas;
    }

    public String getTransporter_no() {
        return transporter_no;
    }

    public String getTransporter_name() {
        return transporter_name;
    }

    public String getSubclass() {
        return subclass;
    }

    public String getAdult_fare() {
        return adult_fare;
    }

    public String getAdult_discount() {
        return adult_discount;
    }

    public String getInfant_fare() {
        return infant_fare;
    }

    public String getInfant_discount() {
        return infant_discount;
    }

    public String getAvb() {
        return avb;
    }

    public String getExceed_booking_time() {
        return exceed_booking_time;
    }

    public int getAdult_num() {
        return adult_num;
    }

    public int getInfant_num() {
        return infant_num;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public static class Builder {

        private String org;
        private String des;
        private String vendor;
        private String dep_datetime;
        private String arv_datetime;
        private String kelas;
        private String transporter_no;
        private String transporter_name;
        private String subclass;
        private String adult_fare;
        private String adult_discount;
        private String infant_fare;
        private String infant_discount;
        private String avb;
        private String exceed_booking_time;
        private int adult_num;
        private int infant_num;
        private String returnStatus;
        private String returnDate;

        public Builder(int adultNum, int infantNum){
            adult_num = adultNum;
            infant_num = infantNum;
        }

        public Schedule.Builder withOrigin(String origin) {
            org = origin;
            return this;
        }

        public Schedule.Builder withDestination(String destination) {
            des = destination;
            return this;
        }

        public Schedule.Builder withVendor(String vendor2) {
            vendor = vendor2;
            return this;
        }

        public Schedule.Builder withDepartureDate(String departureDate) {
            dep_datetime = departureDate;
            return this;
        }

        public Schedule.Builder withArriveDate(String arriveDate) {
            arv_datetime = arriveDate;
            return this;
        }

        public Schedule.Builder withKelas(String kelas2) {
            kelas = kelas2;
            return this;
        }

        public Schedule.Builder withTransporterNo(String transporterNo) {
            transporter_no = transporterNo;
            return this;
        }

        public Schedule.Builder withTransporterName(String transporterName) {
            transporter_name = transporterName;
            return this;
        }

        public Schedule.Builder withSubclass(String subclass2) {
            subclass = subclass2;
            return this;
        }

        public Schedule.Builder withAdultFare(String adultFare) {
            adult_fare = adultFare;
            return this;
        }

        public Schedule.Builder withAdultDiscount(String adultDiscount) {
            adult_discount = adultDiscount;
            return this;
        }

        public Schedule.Builder withInfantFate(String infantFare) {
            infant_fare = infantFare;
            return this;
        }

        public Schedule.Builder withInfantDiscount(String infantDiscount) {
            infant_discount = infantDiscount;
            return this;
        }

        public Schedule.Builder withAvailable(String available) {
            avb = available;
            return this;
        }

        public Schedule.Builder withExceedBookingTime(String exceedBookingTime) {
            exceed_booking_time = exceedBookingTime;
            return this;
        }

        public Schedule.Builder withReturnStatus(String returnStatus1) {
            returnStatus = returnStatus1;
            return this;
        }

        public Schedule.Builder withReturnDate(String returnDate1) {
            returnDate = returnDate1;
            return this;
        }

        public Schedule build() {
            Schedule schedule = new Schedule();
            schedule.adult_num = adult_num;
            schedule.infant_num = infant_num;
            schedule.org = org;
            schedule.des = des;
            schedule.vendor = vendor;
            schedule.dep_datetime = dep_datetime;
            schedule.arv_datetime = arv_datetime;
            schedule.kelas = kelas;
            schedule.transporter_no = transporter_no;
            schedule.transporter_name = transporter_name;
            schedule.subclass = subclass;
            schedule.adult_fare = adult_fare;
            schedule.adult_discount = adult_discount;
            schedule.infant_fare = infant_fare;
            schedule.infant_discount = infant_discount;
            schedule.avb = avb;
            schedule.exceed_booking_time = exceed_booking_time;
            schedule.returnStatus = returnStatus;
            schedule.returnDate = returnDate;

            return schedule;
        }

    }
}
