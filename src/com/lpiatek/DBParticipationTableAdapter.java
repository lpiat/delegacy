/*
package com.lpiatek;
*/
/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 04.10.12
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 *//*


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBParticipationTableAdapter extends SQLiteOpenHelper {
    private static final String DEBUG_TAG = "DBParticipationTableAdapter";
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "database.db";

    private static final String PARTICIPATION_TABLE_TAG = "participation";

    private static final String PARTICIPATION_COLUMN_USER_ID = "_uid";
    private static final String PARTICIPATION_COLUMN_EVENT_ID = "_eid";


//    public static final String KEY_ID = "_id";
//    public static final String ID_OPTIONS = "INTEGER PRIMARY KEY AUTOINCREMENT";
//    public static final int ID_COLUMN = 0;
//    public static final String KEY_DESCRIPTION = "description";
//    public static final String DESCRIPTION_OPTIONS = "TEXT NOT NULL";
//    public static final int DESCRIPTION_COLUMN = 1;
//    public static final String KEY_COMPLETED = "completed";
//    public static final String COMPLETED_OPTIONS = "INTEGER DEFAULT 0";
//    public static final int COMPLETED_COLUMN = 2;

    // Database creation sql statement
    private static final String PARTICIPATION_TABLE_CREATE = "create table "
            + PARTICIPATION_TABLE_TAG + "(" + PERSON_COLUMN_ID + " integer primary key autoincrement, "
            + ");";

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBParticipationTableAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBParticipationTableAdapter.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + PARTICIPATION_TABLE_TAG);
        onCreate(db);
    }
}
*/
