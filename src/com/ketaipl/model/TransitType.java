package com.ketaipl.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 27.02.13
 * Time: 16:22
 * To change this template use File | Settings | File Templates.
 */
@DatabaseTable(tableName = "transit_type")
public class TransitType implements DbPersistent
{

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String commment;

    public TransitType() {
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
}
