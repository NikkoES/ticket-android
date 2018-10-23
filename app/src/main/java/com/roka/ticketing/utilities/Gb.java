package com.roka.ticketing.utilities;

/**
 * Created by roka on 15/03/18.
 */

public class Gb {
    public static final String INTENT_KODE_PASSENGER = "kodepassenger";
    public static final String INTENT_PASSENGER_ADULT = "adult";
    public static final String INTENT_PASSENGER_CHILD = "child";
    public static final String INTENT_PASSENGER_INFANT = "infant";

    public static final String INTENT_GENERAL_TYPE_PROVIDER = "type_provider";
    public static final String INTENT_GENERAL_BODY = "body";
    public static final String INTENT_GENERAL_MODE = "mode";
    public static final String INTENT_GENERAL_DEST = "dest";
    public static final String INTENT_GENERAL_ORI = "ori";
    public static final String INTENT_TOTAL_DURATION = "totalduration";
    public static final String INTENT_GENERAL_DEPART_DATE = "departdate";
    public static final String INTENT_FLIGHT_ROUTE_ITEM = "flightrouteitem";

    public static final String INTENT_PAYLOAD_ITEM = "payloaditem";

    public static final String REQ_CALENDAR_RESULT = "calendarresult";
    public static final String REQ_PASSENGER_DATA = "passengerdata";
    public static final String INTENT_IS_RANGE_SELECTION = "rangeselection";
    public static final String INTENT_TITLE = "title";

    public static final int PROGRESS_REFRESH_RATE = 1 * 1000;

    // REQUEST CODE ACTIVITY
    public static final int PASSENGER_SELECT = 1;
    public static final int DEPARTURE_DATE = 2;
    public static final int ARRIVAL_DATE = 3;
    public static final int INPUT_PASSENGER_DATA = 4;

    // SHARED PREFERENCES
    public static final String PREF_NAME = "ticketingpref";
    public static final String PREF_SEARCH_KEY = "searchkey";
    public static final String PREF_CLASS_KEY = "classkey";
    public static final String PREF_ADULT_NUM = "adultnum";
    public static final String PREF_CHILD_NUM = "childnum";
    public static final String PREF_INFANT_NUM = "infantnum";

    // TRAIN
    public static final String GDS_BOOK_CODE = "gds_book_code";
}
