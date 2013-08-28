package com.ketaipl.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * To change this template use File | Settings | File Templates.
 */
@DatabaseTable(tableName = "event")
public class Event implements DbPersistent {
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
    @DatabaseField(foreign=true, foreignAutoRefresh=true)
    private Delegation delegation;


    public Event() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CostType getCostType() {
        return costType;
    }

    public void setCostType(CostType costType) {
        this.costType = costType;
    }

    public Delegation getDelegation() {
        return delegation;
    }

    public void setDelegation(Delegation delegation) {
        this.delegation = delegation;
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
}
