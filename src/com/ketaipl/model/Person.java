package com.ketaipl.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 27.02.13
 * Time: 13:59
 * To change this template use File | Settings | File Templates.
 */

@DatabaseTable(tableName = "person")
public class Person {

    @DatabaseField(id = true)
    private long id;
    @DatabaseField
    private String firstName;
    @DatabaseField
    private String lastName;
    @DatabaseField
    private long account;
    @DatabaseField
    private String bank;
    @DatabaseField
    private String city;
    @DatabaseField
    private int contactsId;

    public Person() {
        // ORMLite needs a no-arg constructor
    }

    public Person(long id, String firstName, String lastName, long account, String bank, String city, int contactsId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.bank = bank;
        this.city = city;
        this.contactsId = contactsId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getContactsId() {
        return contactsId;
    }

    public void setContactsId(int contactsId) {
        this.contactsId = contactsId;
    }
}
