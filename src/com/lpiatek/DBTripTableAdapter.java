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
//public class DBTripTableAdapter extends SQLiteOpenHelper {
//    private static final String DEBUG_TAG = "DBTripTableAdapter";
//    private static final int DB_VERSION = 1;
//    private static final String DB_NAME = "database.db";
//
//    private static final String TRIP_TABLE_TAG = "trip";
//
//    private static final String TRIP_COLUMN_ID = "_id";
//    private static final String TRIP_COLUMN_LOCATION = "location";
//
////    public static final String KEY_ID = "_id";
////    public static final String ID_OPTIONS = "INTEGER PRIMARY KEY AUTOINCREMENT";
////    public static final int ID_COLUMN = 0;
////    public static final String KEY_DESCRIPTION = "description";
////    public static final String DESCRIPTION_OPTIONS = "TEXT NOT NULL";
////    public static final int DESCRIPTION_COLUMN = 1;
////    public static final String KEY_COMPLETED = "completed";
////    public static final String COMPLETED_OPTIONS = "INTEGER DEFAULT 0";
////    public static final int COMPLETED_COLUMN = 2;
//
//    // Database creation sql statement
//    private static final String PERSON_TABLE_CREATE = "create table "
//            + PERSON_TABLE_TAG + "(" + PERSON_COLUMN_ID + " integer primary key autoincrement, " +
//            PERSON_COLUMN_SURNAME + " text not null" +
//            PERSON_COLUMN_LASTNAME + " text not null" +
//            PERSON_COLUMN_ACCOUNT + " text not null" +
//            PERSON_COLUMN_BANK + " text not null" +
//            PERSON_COLUMN_CITY + " text not null" +
//            PERSON_COLUMN_CONTACTS_ID + " text not null" +
//            ");";
//
//    // Database creation sql statement
//    private static final String TRIP_TABLE_CREATE = "create table "
//            + TRIP_TABLE_TAG + "(" + TRIP_COLUMN_ID + " integer primary key autoincrement, "
//            + ");";
//
//    private DatabaseHelper DBHelper;
//    private SQLiteDatabase db;
//
//    public DBTripTableAdapter(Context context) {
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
//        Log.w(DBTripTableAdapter.class.getName(),
//                "Upgrading database from version " + oldVersion + " to "
//                        + newVersion + ", which will destroy all old data");
//        db.execSQL("DROP TABLE IF EXISTS " + TRIP_TABLE_TAG);
//        onCreate(db);
//    }
//}
