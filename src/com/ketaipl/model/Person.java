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
public class Person implements DbPersistent
{

    @DatabaseField(generatedId = true)
    private long id;

    public Person(long id, String firstName, String lastName, long account, String bank, String city, int contactsId, String adress, String email, long phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.city = city;
        this.contactsId = contactsId;
        this.adress = adress;
        this.email = email;
        this.phone = phone;
    }

    @DatabaseField
    private String firstName;
    @DatabaseField
    private String lastName;
    @DatabaseField
    private long account;
    @DatabaseField
    private String city;
    @DatabaseField
    private int contactsId;
    @DatabaseField
    private String adress;
    @DatabaseField
    private String email;
    @DatabaseField
    private long phone;

    public Person() {
    }


    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
}
