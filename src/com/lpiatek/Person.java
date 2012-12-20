package com.lpiatek;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 12.10.12
 * Time: 06:11
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    private long id;
    private String firstName;
    private String lastName;
    private long account;
    private String bank;
    private String city;
    private int contactsId;

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return lastName.concat(" ").concat(firstName);
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