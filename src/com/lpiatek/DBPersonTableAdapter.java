package com.lpiatek;
/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 04.10.12
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBPersonTableAdapter extends SQLiteOpenHelper {
    private static final String DEBUG_TAG = DBPersonTableAdapter.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "database.db";

    public static final String PERSON_TABLE_TAG = "person";

    public static final String PERSON_ID = "name";
    private static final String PERSON_ID_OPTIONS = "INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final String PERSON_FIRST_NAME = "lastname";
    private static final String PERSON_FIRST_NAME_OPTIONS = "TEXT NOT NULL";
    public static final String PERSON_LAST_NAME = "surname";
    private static final String PERSON_LAST_NAME_OPTIONS = "TEXT NOT NULL";
    public static final String PERSON_ACCOUNT = "account";
    private static final String PERSON_ACCOUNT_OPTIONS = "TEXT NOT NULL";
    public static final String PERSON_BANK = "bank";
    private static final String PERSON_BANK_OPTIONS = "TEXT NOT NULL";
    public static final String PERSON_CITY = "city";
    private static final String PERSON_CITY_OPTIONS = "TEXT NOT NULL";
    public static final String PERSON_CONTACTS_ID = "cid";
    private static final String PERSON_CONTACTS_ID_OPTIONS = "INTEGER DEFAULT 0";

    private static final String PERSON_TABLE_CREATE =
            "CREATE TABLE " + PERSON_TABLE_TAG + "( " +
                    PERSON_ID + " " + PERSON_ID_OPTIONS + ", " +
                    PERSON_FIRST_NAME + " " + PERSON_FIRST_NAME_OPTIONS + ", " +
                    PERSON_LAST_NAME + " " + PERSON_LAST_NAME_OPTIONS + ", " +
                    PERSON_ACCOUNT + " " + PERSON_ACCOUNT_OPTIONS + ", " +
                    PERSON_BANK + " " + PERSON_BANK_OPTIONS + ", " +
                    PERSON_CITY + " " + PERSON_CITY_OPTIONS + ", " +
                    PERSON_CONTACTS_ID + " " + PERSON_CONTACTS_ID_OPTIONS +
                    ");";

    private static final String DROP_PERSON_TABLE =
            "DROP TABLE IF EXISTS " + PERSON_TABLE_TAG;


    public DBPersonTableAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(PERSON_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBPersonTableAdapter.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + PERSON_TABLE_TAG);
        onCreate(db);
    }

}
