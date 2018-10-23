package com.roka.ticketing.repository.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.roka.ticketing.repository.PassengerRepository;
import com.roka.ticketing.repository.entity.PassengerEntity;

import java.util.List;

/**
 * Created by roka on 24/04/18.
 */

public class PassengerViewModel extends AndroidViewModel {
    private PassengerRepository mRepo;
    private LiveData<List<PassengerEntity>> mPassengers;

    public PassengerViewModel(@NonNull Application application) {
        super(application);
        mRepo = new PassengerRepository(application);
        mPassengers = mRepo.getAllPassenger();
    }

    public LiveData<List<PassengerEntity>> getAllPassengers() {return mPassengers;}

    public void insertPassenger(PassengerEntity passengerEntity) {
        mRepo.insert(passengerEntity);
    }
}
