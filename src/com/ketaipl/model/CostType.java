package com.ketaipl.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 27.02.13
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 */
@DatabaseTable(tableName = "cost_type")
public class CostType implements DbPersistent {
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private int name;
    @DatabaseField
    private String comment;
    @DatabaseField(foreign = true)
    private Person payer;

    public CostType() {
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
}
