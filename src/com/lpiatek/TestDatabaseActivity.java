package com.lpiatek;

import java.util.List;
import java.util.Random;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.provider.ContactsContract;
import android.content.Intent;

public class TestDatabaseActivity extends ListActivity {
    private PersonDataSource datasource;
    private Person per = null;
    {
        //static intializer fuck yeah
        per = new Person();
        per.setContactsId(14);
        per.setAccount(21316546854654L);
        per.setBank("ALIOR");
        per.setCity("Wrocław");
        per.setLastName("lastnejmski");
        per.setFirstName("firstnejmski");
    }
//
//    public void doLaunchContactPicker(View view) {
//        Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
//                Contacts.CONTENT_URI);
//        startActivityForResult(contactPickerIntent, CONTACT_PICKER_RESULT);
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        datasource = new PersonDataSource(this);
        datasource.open();

        List<Person> values = datasource.getAllPersons();

        // Use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Person> adapter = new ArrayAdapter<Person>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    // Will be called via the onClick attribute
    // of the buttons in main.xml
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Person> adapter = (ArrayAdapter<Person>) getListAdapter();
            Person person = null;
            switch (view.getId()) {
                case R.id.add:
                    // Save the new person to the database
                    person = datasource.createPerson(per);
                    adapter.add(person);
                    break;
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    person = (Person) getListAdapter().getItem(0);
                    datasource.deletePerson(person);
                    adapter.remove(person);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

} 