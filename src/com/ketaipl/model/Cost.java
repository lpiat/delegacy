package com.ketaipl.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * To change this template use File | Settings | File Templates.
 */
@DatabaseTable(tableName = "cost")
public class Cost implements DbPersistent {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private int quantity;
    @DatabaseField
    private int price;
    @DatabaseField
    private Date endDate;
    @DatabaseField(foreign = true)
    private CostType costType;

    public Cost() {
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
}
