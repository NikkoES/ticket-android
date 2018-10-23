package com.roka.ticketing.inputpassenger.interfaces;

import com.roka.ticketing.repository.entity.PassengerEntity;

/**
 * Created by roka on 26/04/18.
 */

public interface InputPassengerInterface {
    void onPassengerSelected(PassengerEntity passengerEntity);
}
