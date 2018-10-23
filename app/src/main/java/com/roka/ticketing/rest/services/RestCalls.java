package com.roka.ticketing.rest.services;

import com.roka.ticketing.rest.payload.flight.BookFlightPayload;
import com.roka.ticketing.rest.payload.IssuingPayload;
import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.payload.train.BookingRail;
import com.roka.ticketing.rest.response.flight.BookFlightResponse;
import com.roka.ticketing.rest.response.flight.IssuingResponse;
import com.roka.ticketing.rest.response.flight.LionSearchResponse;
import com.roka.ticketing.rest.response.flight.SearchFlightResponse;
import com.roka.ticketing.rest.response.flight.helperpojo.listbooking.ListBookingResponse;
import com.roka.ticketing.rest.response.train.BookResponse;
import com.roka.ticketing.rest.response.train.HistoryTrain;
import com.roka.ticketing.rest.response.train.StationResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by roka on 15/03/18.
 */

public interface RestCalls {
    @Headers({"Content-Type: application/json"})
    @POST("/searchFlights")
    Call<SearchFlightResponse> searchFlight(@Body SearchFlightPayload payload);

    @Headers({"Content-Type: application/json"})
    @POST("/lionSearch")
    Call<List<LionSearchResponse>> searchLionFlight(@Body SearchFlightPayload payload);

    @Headers({"Content-Type: application/json"})
    @POST("/citilinkSearchFlight")
    Call<List<LionSearchResponse>> searchCitilinkFlight(@Body SearchFlightPayload payload);

    @Headers({"Content-Type: application/json"})
    @POST("/generatePNR")
    Call<BookFlightResponse> bookFlight(@Body BookFlightPayload payload);

    @Headers({"Content-Type: application/json"})
    @POST("/issuing")
    Call<IssuingResponse> issueFlight(@Body IssuingPayload payload);

    @Headers({"Content-Type: application/json"})
    @GET("/getListBooking")
    Call<List<ListBookingResponse>> getListBooking();

    //============== TRAIN ==================
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @FormUrlEncoded
    @POST("data/get-station")
    Call<StationResponse> getStation(@Field("token") String token);

    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @FormUrlEncoded
    @POST("information/get-rail-schedule")
    Call<StationResponse> getRailSchedule(@Field("token") String token,
                                          @Field("org") String org,
                                          @Field("des") String des,
                                          @Field("departure_date") String departure_date,
                                          @Field("adult_quantity") String adult_quantity,
                                          @Field("infant_quantity") String infant_quantity);

    @Headers({"Content-Type: application/json"})
    @POST("transaction/booking-rail")
    Call<BookResponse> bookingRail(@Body BookingRail bookingRail);

    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @FormUrlEncoded
    @POST("information/get-book-info")
    Call<HistoryTrain> detailBooking(@Field("token") String token, @Field("gds_book_code") String gdsBookCode);
}
