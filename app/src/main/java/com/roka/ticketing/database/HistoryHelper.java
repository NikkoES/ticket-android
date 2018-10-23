package com.roka.ticketing.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.roka.ticketing.rest.response.train.History;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static com.roka.ticketing.database.DatabaseContract.HistoryTrainColumns.DETAIL_BOOK;
import static com.roka.ticketing.database.DatabaseContract.HistoryTrainColumns.GDS_BOOK_CODE;
import static com.roka.ticketing.database.DatabaseContract.TABLE_TRAIN_HISTORY;

public class HistoryHelper {

    private static String DATABASE_TABLE = TABLE_TRAIN_HISTORY;
    private Context context;
    private DatabaseHelper dataBaseHelper;

    private SQLiteDatabase database;

    public HistoryHelper(Context context){
        this.context = context;
    }

    public HistoryHelper open() throws SQLException {
        dataBaseHelper = new DatabaseHelper(context);
        database = dataBaseHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dataBaseHelper.close();
    }

    public ArrayList<History> query(){
        ArrayList<History> arrayList = new ArrayList<History>();
        Cursor cursor = database.query(DATABASE_TABLE,null,null,null,null,null,_ID +" DESC",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            do {
                History history = new History();
                history.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                history.setGdsBook(cursor.getString(cursor.getColumnIndexOrThrow(GDS_BOOK_CODE)));
                history.setBookInfo(cursor.getString(cursor.getColumnIndexOrThrow(DETAIL_BOOK)));
                arrayList.add(history);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public long insert(String bookCode, String bookInfo){
        ContentValues initialValues =  new ContentValues();
        initialValues.put(GDS_BOOK_CODE, bookCode);
        initialValues.put(DETAIL_BOOK, bookInfo);
        return database.insert(DATABASE_TABLE, null, initialValues);
    }

}
