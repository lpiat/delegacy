package com.ketaipl.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ketaipl.R;
import com.ketaipl.activity.TestActivity;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * To change this template use File | Settings | File Templates.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup contentView = (ViewGroup) getLayoutInflater().inflate(R.layout.main_menu, null);

        //initialize buttons
        Button personButton = (Button) contentView.findViewById(R.id.button_person);
        setupButton(personButton, this, DelegationManagerActivity.class);

        //TODO: further remove and clear
        Button personAddingTestButton = (Button) contentView.findViewById(R.id.person_test_button);
        setupButton(personAddingTestButton, this, TestActivity.class);
        //END: further remove and clear

        setContentView(contentView);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help:
                Toast.makeText(this, "You have chosen the " + "help" + " menu option",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:
                Toast.makeText(this, "lukpia ver #1.alpha",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings:
                Toast.makeText(this, "tbd",
                        Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

