package com.roka.ticketing.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.roka.ticketing.repository.dataaccessobject.PassengerDao;
import com.roka.ticketing.repository.entity.PassengerEntity;

import java.util.List;

/**
 * Created by roka on 24/04/18.
 */

public class PassengerRepository {
    private PassengerDao mPassengerDao;
    private LiveData<List<PassengerEntity>> mAllPassengers;

    public PassengerRepository(Application app) {
        AppDatabase db = AppDatabase.getAppDatabase(app);
        mPassengerDao = db.passengerDao();
        mAllPassengers = mPassengerDao.getAllPassenger();
    }

    public void insert(PassengerEntity passengerEntity) {
        new InsertAsyncTask(mPassengerDao).execute(passengerEntity);
    }

    public LiveData<List<PassengerEntity>> getAllPassenger() {
        return mAllPassengers;
    }

    private static class InsertAsyncTask extends AsyncTask<PassengerEntity, Void, Void> {

        private PassengerDao mAsyncTaskDao;

        InsertAsyncTask(PassengerDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final PassengerEntity... params) {
            mAsyncTaskDao.insertPassenger(params[0]);
            return null;
        }
    }
}
