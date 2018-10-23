package com.roka.ticketing.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "db_train";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_TABLE_TRAIN = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            DatabaseContract.TABLE_TRAIN_HISTORY,
            DatabaseContract.HistoryTrainColumns._ID,
            DatabaseContract.HistoryTrainColumns.GDS_BOOK_CODE,
            DatabaseContract.HistoryTrainColumns.DETAIL_BOOK
    );
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_TRAIN);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_TRAIN_HISTORY);
        onCreate(db);
    }
}
