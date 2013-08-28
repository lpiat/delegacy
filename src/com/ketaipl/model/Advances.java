package com.ketaipl.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * To change this template use File | Settings | File Templates.
 */
@DatabaseTable(tableName = "advances")
public class Advances implements DbPersistent {
    @DatabaseField(foreign = true, uniqueCombo = true, columnDefinition = "integer references parent(id) on delete cascade")
    private Delegation delegation;

    @DatabaseField
    private int generalAdvancePayed;
    @DatabaseField
    private int accomodationLumpsum;
    @DatabaseField
    private int commuteLumpsum;
    @DatabaseField(foreign = true, uniqueCombo = true, columnDefinition = "integer references parent(id) on delete cascade")
    private Person person;

    public Advances() {
    }

    public Delegation getDelegation() {
        return delegation;
    }

    public int getGeneralAdvancePayed() {
        return generalAdvancePayed;
    }

    public int getAccomodationLumpsum() {
        return accomodationLumpsum;
    }

    public int getCommuteLumpsum() {
        return commuteLumpsum;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
}
