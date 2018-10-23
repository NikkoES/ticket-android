package com.roka.ticketing.rest.response.train;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDep_datetime() {
        return dep_datetime;
    }

    public void setDep_datetime(String dep_datetime) {
        this.dep_datetime = dep_datetime;
    }

    public String getArv_datetime() {
        return arv_datetime;
    }

    public void setArv_datetime(String arv_datetime) {
        this.arv_datetime = arv_datetime;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getTransporter_no() {
        return transporter_no;
    }

    public void setTransporter_no(String transporter_no) {
        this.transporter_no = transporter_no;
    }

    public String getTransporter_name() {
        return transporter_name;
    }

    public void setTransporter_name(String transporter_name) {
        this.transporter_name = transporter_name;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getAdult_fare() {
        return adult_fare;
    }

    public void setAdult_fare(String adult_fare) {
        this.adult_fare = adult_fare;
    }

    public String getAdult_discount() {
        return adult_discount;
    }

    public void setAdult_discount(String adult_discount) {
        this.adult_discount = adult_discount;
    }

    public String getInfant_fare() {
        return infant_fare;
    }

    public void setInfant_fare(String infant_fare) {
        this.infant_fare = infant_fare;
    }

    public String getInfant_discount() {
        return infant_discount;
    }

    public void setInfant_discount(String infant_discount) {
        this.infant_discount = infant_discount;
    }

    public String getAvb() {
        return avb;
    }

    public void setAvb(String avb) {
        this.avb = avb;
    }

    public String getExceed_booking_time() {
        return exceed_booking_time;
    }

    public void setExceed_booking_time(String exceed_booking_time) {
        this.exceed_booking_time = exceed_booking_time;
    }

}
