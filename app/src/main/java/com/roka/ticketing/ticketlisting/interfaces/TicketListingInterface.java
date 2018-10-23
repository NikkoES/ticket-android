package com.roka.ticketing.ticketlisting.interfaces;


import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.response.flight.LionSearchResponse;
import com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FlightRouteItem;
import com.roka.ticketing.rest.payload.train.Schedule;

/**
 * Created by roka on 25/02/18.
 */

public interface TicketListingInterface  {
    void onPlaneTicketDetail(FlightRouteItem model, String totalDuration, SearchFlightPayload payload);
    void onPlaneTicketDetail(LionSearchResponse model, SearchFlightPayload payload);
    void onTrainTicketDetail(Schedule model, Schedule payload);
    void showControlLayout(boolean isShown);
}
