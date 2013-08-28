package com.ketaipl.db;

import java.sql.SQLException;
import java.util.List;
import android.content.Context;
import android.util.Log;
import com.j256.ormlite.dao.Dao;
import com.ketaipl.model.DbPersistent;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * To change this template use File | Settings | File Templates.
 */

public class DatabaseManager {

    static private DatabaseManager instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new DatabaseManager(ctx);
        }
    }

    static public DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseHelper helper;

    private DatabaseManager(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    private Dao<DbPersistent, Integer> getDao(Class<? extends DbPersistent> type){
        Log.d(type.getName(), "Return DAO");
        return (Dao<DbPersistent, Integer>) getHelper().daosFactory(type);
    }

    public List<? extends DbPersistent> getAllItems(Class<? extends DbPersistent> type){
        List<? extends DbPersistent> items = null;
        try {
            items = getDao(type).queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public DbPersistent getItemWithId(Class<? extends DbPersistent> type,int id) {
        DbPersistent item = null;
        try {
            item = getDao(type).queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public  <T extends DbPersistent> void addItem(Class<? extends DbPersistent> type,T item) {
        try {
            getDao(type).create(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public <T extends DbPersistent> void deleteItem(Class<? extends DbPersistent> type,T item) {
        try {
            getDao(type).delete(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public <T extends DbPersistent> void updateItem(Class<? extends DbPersistent> type,T item) {
        try {
            getDao(type).update(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public <T extends DbPersistent> void updateItemWithId(Class<? extends DbPersistent> type,T item, Integer id) {
        try {
            getDao(type).updateId(item, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}