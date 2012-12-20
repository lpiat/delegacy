package com.lpiatek;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 17.10.12
 * Time: 04:58
 * To change this template use File | Settings | File Templates.
 */
public class PersonDataSource {

    // Database fields
    private SQLiteDatabase database;
    private DBPersonTableAdapter dbHelper;
    private String[] allColumns = {
            DBPersonTableAdapter.PERSON_ID,
            DBPersonTableAdapter.PERSON_CONTACTS_ID,
            DBPersonTableAdapter.PERSON_FIRST_NAME,
            DBPersonTableAdapter.PERSON_LAST_NAME,
            DBPersonTableAdapter.PERSON_ACCOUNT,
            DBPersonTableAdapter.PERSON_BANK,
            DBPersonTableAdapter.PERSON_CITY,





    };

    public PersonDataSource(Context context) {
        dbHelper = new DBPersonTableAdapter(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Person createPerson(Person person) {
        ContentValues values = new ContentValues();
        values.put(DBPersonTableAdapter.PERSON_CONTACTS_ID, person.getContactsId());
        values.put(DBPersonTableAdapter.PERSON_LAST_NAME, person.getLastName());
        values.put(DBPersonTableAdapter.PERSON_FIRST_NAME, person.getFirstName());
        values.put(DBPersonTableAdapter.PERSON_ACCOUNT, person.getAccount());
        values.put(DBPersonTableAdapter.PERSON_BANK, person.getBank());
        values.put(DBPersonTableAdapter.PERSON_CITY, person.getCity());

        long insertId = database.insert(DBPersonTableAdapter.PERSON_TABLE_TAG, null,
                values);
        Cursor cursor = database.query(DBPersonTableAdapter.PERSON_TABLE_TAG,
                allColumns, DBPersonTableAdapter.PERSON_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Person newPerson = cursorToPerson(cursor);
        cursor.close();
        return newPerson;
    }

    public void deletePerson(Person person) {
        long id = person.getId();
        System.out.println("Person deleted with id: " + id);
        database.delete(DBPersonTableAdapter.PERSON_TABLE_TAG, DBPersonTableAdapter.PERSON_ID
                + " = " + id, null);
    }

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<Person>();

        Cursor cursor = database.query(DBPersonTableAdapter.PERSON_TABLE_TAG,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Person person = cursorToPerson(cursor);
            persons.add(person);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        return persons;
    }

    private Person cursorToPerson(Cursor cursor) {
        Person person = new Person();
        person.setId(cursor.getLong(0));
        person.setContactsId(cursor.getInt(1));
        person.setFirstName(cursor.getString(2));
        person.setLastName(cursor.getString(3));
        person.setAccount(cursor.getLong(4));
        person.setBank(cursor.getString(5));
        person.setCity(cursor.getString(6));
        return person;
    }
}