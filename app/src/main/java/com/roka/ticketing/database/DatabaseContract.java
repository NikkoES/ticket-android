package com.roka.ticketing.database;

import android.provider.BaseColumns;

public class DatabaseContract {

    static String TABLE_TRAIN_HISTORY = "tb_train_history";

    static final class HistoryTrainColumns implements BaseColumns {
        static String GDS_BOOK_CODE = "gds_book_code";
        static String DETAIL_BOOK = "detail_book";
    }

}
