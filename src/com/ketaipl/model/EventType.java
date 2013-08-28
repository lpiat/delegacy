package com.ketaipl.model;

import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * To change this template use File | Settings | File Templates.
 */
@DatabaseTable(tableName = "event_type")
public class EventType implements DbPersistent {
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private int quantity;
    @DatabaseField
    private int price;
    @DatabaseField
    private Date endDate;
    @DatabaseField(foreign = true)
    private CostType costType;

    public EventType() {
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
}
