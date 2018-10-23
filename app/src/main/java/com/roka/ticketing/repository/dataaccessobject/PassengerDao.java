package com.roka.ticketing.repository.dataaccessobject;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.roka.ticketing.repository.entity.PassengerEntity;

import java.util.List;

/**
 * Created by roka on 24/04/18.
 */

@Dao
public interface PassengerDao {
    @Query("SELECT * FROM passenger")
    LiveData<List<PassengerEntity>> getAllPassenger();

    @Insert
    void insertPassenger(PassengerEntity passengerEntity);

    @Delete
    void deletePassenger(PassengerEntity passengerEntity);
}
