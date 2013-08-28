package com.ketaipl.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 27.02.13
 * Time: 13:50
 * To change this template use File | Settings | File Templates.
 */

    @DatabaseTable(tableName = "transit")
    public class Transit implements DbPersistent {

        @DatabaseField(generatedId = true)
        private int id;
        @DatabaseField
        private String startLocation;
        @DatabaseField
        private String endLocation;
        @DatabaseField
        private Date date;
        @DatabaseField(foreign=true,foreignAutoRefresh=true)
        private TransitType transitType;
        @DatabaseField(foreign=true,foreignAutoRefresh=true)
        private Delegation delegation;

        public Transit() {
        }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
}
