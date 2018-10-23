package com.roka.ticketing.utilities;

import android.util.Log;

import com.roka.ticketing.rest.response.flight.helperpojo.searchflight.ClassesAvailableItem;
import com.roka.ticketing.rest.response.flight.helperpojo.searchflight.ClassesAvailableItemItem;
import com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FlightRouteItem;
import com.roka.ticketing.rest.response.flight.helperpojo.searchflight.LegsItem;
import com.roka.ticketing.rest.response.train.Schedule;

import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created by roka on 15/03/18.
 */

public class StringUtilities {
    public static String timeResponseToHour(String dateString) {
        DateFormat dateStringToDateFormatter = new SimpleDateFormat("dd-MMM-yyyy hh.mm.ss aaa", Locale.US);
        DateFormat dateToHourFormatter = new SimpleDateFormat("HH.mm");

        try {
            Date date = dateStringToDateFormatter.parse(dateString);
            return dateToHourFormatter.format(date);
        } catch (ParseException e) {
            Log.e("ASDF", e.toString());
        }

        return "";
    }

    public static String dateResponseToDate(String dateString) {
        DateFormat dateStringToDateFormatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        DateFormat dateNewStringToDateFormatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = dateStringToDateFormatter.parse(dateString);
            return dateNewStringToDateFormatter.format(date);
        }
        catch (ParseException e) {
            Log.e("ASDF", e.toString());
        }

        return "";
    }

    public static String dateResponseToDate(String dateString, String oldPattern, String newPattern) {
        DateFormat dateStringToDateFormatter = new SimpleDateFormat(oldPattern, Locale.US);
        DateFormat dateNewStringToDateFormatter = new SimpleDateFormat(newPattern, Locale.US);

        try {
            Date date = dateStringToDateFormatter.parse(dateString);
            return dateNewStringToDateFormatter.format(date);
        }
        catch (ParseException e) {
            Log.e("ASDF", e.toString());
        }

        return "";
    }

    public static String timeResponseToHourTrain(String dateString) {
        DateFormat dateStringToDateFormatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm", Locale.US);
        DateFormat dateToHourFormatter = new SimpleDateFormat("HH.mm");

        try {
            Date date = dateStringToDateFormatter.parse(dateString);
            return dateToHourFormatter.format(date);
        } catch (ParseException e) {
            Log.e("ASDF", e.toString());
        }

        return "";
    }

    public static String duration(String startDate, String endDate) {
        DateFormat dateStringToDateFormatter = new SimpleDateFormat("dd-MMM-yyyy hh.mm.ss aaa", Locale.US);

        try {
            Date start = dateStringToDateFormatter.parse(startDate);
            Date end = dateStringToDateFormatter.parse(endDate);

            long hour = TimeUnit.MILLISECONDS.toHours(end.getTime() - start.getTime());

            return "" + hour;
        } catch (ParseException e) {
            Log.e("ASDF", e.toString());
        }

        return "";
    }

    public static String durationTrain(String startDate, String endDate) {
        DateFormat dateStringToDateFormatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm", Locale.US);

        try {
            Date start = dateStringToDateFormatter.parse(startDate);
            Date end = dateStringToDateFormatter.parse(endDate);

            long hour = TimeUnit.MILLISECONDS.toHours(end.getTime() - start.getTime());
            long minute = TimeUnit.MILLISECONDS.toMinutes(end.getTime() - start.getTime()) % 60;
            return hour + "h " + minute + "m";
        } catch (ParseException e) {
            Log.e("ASDF", e.toString());
        }

        return "";
    }


    public static String duration(FlightRouteItem item) {
        DateFormat dateStringToDateFormatter = new SimpleDateFormat("dd-MMM-yyyy hh.mm.ss aaa", Locale.US);
        String startDate = item.getmStd().getvalue();
        String endDate = item.getmSta().getvalue();

        try {
            Date start = dateStringToDateFormatter.parse(startDate);
            Date end = dateStringToDateFormatter.parse(endDate);

            long hour = TimeUnit.MILLISECONDS.toHours(end.getTime() - start.getTime());
            long minute = TimeUnit.MILLISECONDS.toMinutes(end.getTime() - start.getTime()) % 60;
            return hour + "h " + minute + "m";
        } catch (ParseException e) {
            Log.e("ASDF", e.toString());
        }

        return "";
    }

    public static String duration(LegsItem item) {
        DateFormat dateStringToDateFormatter = new SimpleDateFormat("dd-MMM-yyyy hh.mm.ss aaa", Locale.US);
        String startDate = item.getmStd().getvalue();
        String endDate = item.getmSta().getvalue();

        try {
            Date start = dateStringToDateFormatter.parse(startDate);
            Date end = dateStringToDateFormatter.parse(endDate);

            long hour = TimeUnit.MILLISECONDS.toHours(end.getTime() - start.getTime());
            long minute = TimeUnit.MILLISECONDS.toMinutes(end.getTime() - start.getTime()) % 60;
            return hour + "h " + minute + "m";
        } catch (ParseException e) {
            Log.e("ASDF", e.toString());
        }

        return "";
    }

    public static String directStatus(FlightRouteItem item) {
        int num = item.getmSegments().getItem().get(0).getmLegs().getItem().size();
        if (num <= 1) return "Direct";
        else return num + " Stops";
    }

    public static String getAirportCode(String airportName) {
        return airportName.substring(airportName.length() - 4, airportName.length() - 1);
    }

    public static String getPriceTotalInCurrency(FlightRouteItem item) {
        List<ClassesAvailableItem> singleClass = item.getmClassesAvailable().getClassesAvailableItem();
        String currency = "IDR";
        double priceDouble = 0;
        if (singleClass.size() > 0) {
            List<ClassesAvailableItemItem> singleClassItem = singleClass.get(0).getClassesAvailableItemItem();

            if (singleClassItem.size() > 0) {
                currency = singleClassItem.get(0).getmCurrency().getvalue();
                String price = singleClassItem.get(0).getmPrice().getvalue();
                priceDouble = Double.parseDouble(price);

            }
        }
        String formattedNumber = NumberFormat.getNumberInstance(Locale.ENGLISH).format(priceDouble);

        return currency + " " + formattedNumber;
    }

    public static double getPriceTotal(FlightRouteItem item) {
        List<ClassesAvailableItem> singleClass = item.getmClassesAvailable().getClassesAvailableItem();
        String currency = "IDR";
        double priceDouble = 0;
        if (singleClass.size() > 0) {
            List<ClassesAvailableItemItem> singleClassItem = singleClass.get(0).getClassesAvailableItemItem();

            if (singleClassItem.size() > 0) {
                currency = singleClassItem.get(0).getmCurrency().getvalue();
                String price = singleClassItem.get(0).getmPrice().getvalue();
                priceDouble = Double.parseDouble(price);

            }
        }

        return priceDouble;
    }


    public static String getPriceInCurrency(FlightRouteItem item) {
        List<ClassesAvailableItem> singleClass = item.getmClassesAvailable().getClassesAvailableItem();
        String currency = "IDR";
        double priceDouble = 0;
        if (singleClass.size() > 0) {
            List<ClassesAvailableItemItem> singleClassItem = singleClass.get(0).getClassesAvailableItemItem();

            if (singleClassItem.size() > 0) {
                currency = singleClassItem.get(0).getmCurrency().getvalue();
                String price = singleClassItem.get(0).getmPriceDetail().getPriceDetailItem().get(0).getTotal1().getvalue();
                priceDouble = Double.parseDouble(price);

            }
        }
        String formattedNumber = NumberFormat.getNumberInstance(Locale.ENGLISH).format(priceDouble);

        return currency + " " + formattedNumber;
    }

    public static double getPrice(FlightRouteItem item) {
        List<ClassesAvailableItem> singleClass = item.getmClassesAvailable().getClassesAvailableItem();
        String currency = "IDR";
        double priceDouble = 0;
        if (singleClass.size() > 0) {
            List<ClassesAvailableItemItem> singleClassItem = singleClass.get(0).getClassesAvailableItemItem();

            if (singleClassItem.size() > 0) {
                currency = singleClassItem.get(0).getmCurrency().getvalue();
                String price = singleClassItem.get(0).getmPriceDetail().getPriceDetailItem().get(0).getTotal1().getvalue();
                priceDouble = Double.parseDouble(price);

            }
        }

        return priceDouble;
    }

    public static String getFlightCodeAndClass(FlightRouteItem item) {
        String flightCode = item.getmSegments().getItem().get(0).getmCarrierCode().getvalue();
        String flightNumber = item.getmSegments().getItem().get(0).getmNoFlight().getvalue();
//        String flightClass = item.getmClassesAvailable().getClassesAvailableItem().get(0).getClassesAvailableItemItem().get(0).getmPassengerClass().getvalue();

        return flightCode + " " + flightNumber + " - "  + " PassengerClass";
    }

    public static String getPrettyDate(String string) {
        DateFormat dateStringToDateFormatter = new SimpleDateFormat("dd-MMM-yy hh.mm.ss aaa", Locale.US);
        DateFormat dateToPrettyStringFormatter= new SimpleDateFormat("dd MMM yyyy, hh.mm", Locale.US);

        try {
            Date date = dateStringToDateFormatter.parse(string);
            String prettyString = dateToPrettyStringFormatter.format(date);
            return prettyString;
        } catch (ParseException e) {

        }

        return "";
    }
}
