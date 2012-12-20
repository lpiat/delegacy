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
//public class DBPaymentTableAdapter extends SQLiteOpenHelper {
//    private static final String DEBUG_TAG = "DBPaymentTableAdapter";
//    private static final int DB_VERSION = 1;
//    private static final String DB_NAME = "database.db";
//
//    private static final String PAYMENT_TABLE_TAG = "payment";
//
//    private static final String PAYMENT_COLUMN_EVENT_ID = "_eid";
//    private static final String PAYMENT_COLUMN_USER_ID = "_uid";
//    private static final String PAYMENT_COLUMN_AMOUNT = "amount";
//
//    // Database creation sql statement
//    private static final String PAYMENT_TABLE_CREATE = "create table "
//            + PAYMENT_TABLE_TAG + "(" + PERSON_COLUMN_ID + " integer primary key autoincrement, "
//            + ");";
//
//    private DatabaseHelper DBHelper;
//    private SQLiteDatabase db;
//
//    public DBPaymentTableAdapter(Context context) {
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
//        Log.w(DBPaymentTableAdapter.class.getName(),
//                "Upgrading database from version " + oldVersion + " to "
//                        + newVersion + ", which will destroy all old data");
//        db.execSQL("DROP TABLE IF EXISTS " + PAYMENT_TABLE_TAG);
//        onCreate(db);
//    }
//}
