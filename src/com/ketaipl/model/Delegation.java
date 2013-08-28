package com.ketaipl.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;


import java.util.Collection;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * To change this template use File | Settings | File Templates.
 */

@DatabaseTable(tableName = "delegation")
public class Delegation implements DbPersistent
{
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String name;
    @DatabaseField
    private Date startDate;
    @DatabaseField
    private Date endDate;
    @DatabaseField(foreign = true)
    private Person person;

    @ForeignCollectionField(eager = true)
    private Collection<Event> eventList;

    @ForeignCollectionField(eager = true)
    private Collection<Transit> transitList;

    public Delegation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Collection<Event> getEventList() {
        return eventList;
    }

    public void setEventList(Collection<Event> eventList) {
        this.eventList = eventList;
    }

    public Collection<Transit> getTransitList() {
        return transitList;
    }

    public void setTransitList(Collection<Transit> transitList) {
        this.transitList = transitList;
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
}
