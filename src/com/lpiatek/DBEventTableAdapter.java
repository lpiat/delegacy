//package com.lpiatek;
///**
// * Created with IntelliJ IDEA.
// * User: Luke
// * Date: 04.10.12
// * Time: 14:34
// * To change this template use File | Settings | File Templates.
// */
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
//public class DBEventTableAdapter extends SQLiteOpenHelper {
//    private static final String DEBUG_TAG = "DBAdapter";
//    private static final int DB_VERSION = 1;
//    private static final String DB_NAME = "database.db";
//
//    private static final String EVENT_TABLE_TAG = "event";
//
//    private static final String EVENT_COLUMN_ID = "_id";
//    private static final String EVENT_COLUMN_NAME = "name";
//    private static final String EVENT_COLUMN_LOCATION = "location";
//    private static final String EVENT_COLUMN_AMOUNT = "amount";
//    private static final String EVENT_COLUMN_CURRENCY = "currency";
//    private static final String EVENT_COLUMN_DISTRIBUTION = "distribution";
//
//    private static final String EVENT_TABLE_CREATE = "create table "
//            + EVENT_TABLE_TAG + "(" + PERSON_COLUMN_ID + " integer primary key autoincrement, "
//            + ");";
//
//    private DatabaseHelper DBHelper;
//    private SQLiteDatabase db;
//
//    public DBEventTableAdapter(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase database) {
//        database.execSQL(DATABASE_CREATE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Log.w(DBEventTableAdapter.class.getName(),
//                "Upgrading database from version " + oldVersion + " to "
//                        + newVersion + ", which will destroy all old data");
//        db.execSQL("DROP TABLE IF EXISTS " + PERSON_TABLE_TAG);
//        db.execSQL("DROP TABLE IF EXISTS " + EVENT_TABLE_TAG);
//        db.execSQL("DROP TABLE IF EXISTS " + TRIP_TABLE_TAG);
//        db.execSQL("DROP TABLE IF EXISTS " + PAYMENT_TABLE_TAG);
//        db.execSQL("DROP TABLE IF EXISTS " + PARTICIPATION_TABLE_TAG);
//        onCreate(db);
//    }
//}
