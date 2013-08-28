package com.ketaipl.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.ketaipl.model.*;


/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "dbTest.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;
    //static final String DATABASE_PATH = "/data/1234/";

    // the DAO object we use to access the tables
    private Map<Class, Dao> daos = null;

    //constructor, create map for dao/type pairs
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        daos = new HashMap<Class, Dao>();
    }

    private Class[] tableClasses = {
            Advances.class,
            Cost.class, CostType.class, Delegation.class, Event.class, EventType.class,
            Person.class, Transit.class, TransitType.class
    };

    private void clearDatabase() {
        try {
            for (Class type : tableClasses) {
                Log.i(type.getName(), "onDrop");
                TableUtils.dropTable(connectionSource, type, true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Dao<? extends DbPersistent, Integer> daosFactory(Class<? extends DbPersistent> type) {
        if (!daos.containsKey(type)) {
            try {
                final Dao<DbPersistent, Integer> tempDao = getDao((Class<DbPersistent>) type);
                // tempDao = getDao((Class<DbPersistent>) type);
                daos.put(type, tempDao);
                return tempDao;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return daos.get(type);
    }

    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            for (Class type : tableClasses) {
                Log.i(type.getName(), "onCreate");
                TableUtils.dropTable(connectionSource, type, true);
            }

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
     * the various data to match the new version number.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        List<String> allSql = new ArrayList<String>();
        if (oldVersion != newVersion) {
            clearDatabase();
            try {
                for (Class type : tableClasses) {
                    Log.i(type.getName(), "onCreate");
                    TableUtils.dropTable(connectionSource, type, true);
                }
            } catch (SQLException e) {
                Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
                throw new RuntimeException(e);
            }
        }
    }
}
