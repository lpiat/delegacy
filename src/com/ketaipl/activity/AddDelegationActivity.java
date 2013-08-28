package com.ketaipl.activity;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * To change this template use File | Settings | File Templates.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.app.DatePickerDialog.OnDateSetListener;

import com.ketaipl.Constants;
import com.ketaipl.R;
import com.ketaipl.db.DatabaseManager;
import com.ketaipl.model.Delegation;
import com.ketaipl.gui.DateDialogFragment;
import com.ketaipl.model.Person;

import java.util.Calendar;
import java.util.Date;

public class AddDelegationActivity extends BaseActivity{

    public static final String TAG = "AddDelegationActivity";
    private EditText edit;
    private Delegation delegation;

    private TextView startDateDisplay;
    private Button pickStartDateButton;
    private TextView endDateDisplay;
    private Button pickEndDateButton;

    private TextView personNameDisplay;
    private Button pickPersonButton;

    private int year, month, day;
    {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        this.day = c.get(Calendar.DAY_OF_MONTH);
    }

    private DatabaseManager getDbManager()
    {
            return DatabaseManager.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup contentView = (ViewGroup) getLayoutInflater().inflate(R.layout.add_delegation_activity, null);
        setContentView(contentView);

        edit = (EditText) contentView.findViewById(R.id.editDelegationName);
        startDateDisplay = (TextView) findViewById(R.id.startDateDisplay);
        pickStartDateButton = (Button) findViewById(R.id.pickStartDate);
        endDateDisplay = (TextView) findViewById(R.id.endDateDisplay);
        pickEndDateButton = (Button) findViewById(R.id.pickEndDate);
        personNameDisplay = (TextView) findViewById(R.id.endDateDisplay);
        pickPersonButton = (Button) findViewById(R.id.pickPersonName);
        Button btn = (Button) contentView.findViewById(R.id.delegationSaveButtton);

        startDateDisplay.setText(dateStringBuilder(year, month, day));
        endDateDisplay.setText(dateStringBuilder(year, month, day));

        setupPersonButton(pickPersonButton);
        setupStartDateButton(pickStartDateButton);
        setupEndDateButton(pickEndDateButton);
        setupSaveButton(btn);
        setupDelegations();
    }

    //lol
    private String dateStringBuilder(int year, int month, int day) {
        return new StringBuilder().append(day).append("-").append(month + 1).append("-").append(year).append(" ").toString();
        // Month is 0 based so add 1
    }

    private Date dateBuilder(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        return new Date(c.getTimeInMillis());
    }

    private void showDatePicker(OnDateSetListener listener) {
        DateDialogFragment date = new DateDialogFragment(getFragmentManager(), listener, year, month, day);
    }


    private void setupStartDateButton(Button button) {
        final OnDateSetListener onStartDateSet = new OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                startDateDisplay.setText(dateStringBuilder(year, monthOfYear, dayOfMonth));
                delegation.setStartDate(dateBuilder(year, monthOfYear, dayOfMonth));
            }
        };

        pickStartDateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDatePicker(onStartDateSet);
            }
        });
    }

    private void setupEndDateButton(Button button) {
        final OnDateSetListener onEndDateSet = new OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                endDateDisplay.setText(dateStringBuilder(year, monthOfYear, dayOfMonth));
                delegation.setEndDate(dateBuilder(year, monthOfYear, dayOfMonth));
            }
        };

        pickEndDateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDatePicker(onEndDateSet);
            }
        });
    }

    private void setupDelegations() {
        Bundle bundle = getIntent().getExtras();
        if (null != bundle && bundle.containsKey(Constants.keyDelegationId)) {
            int delegationId = bundle.getInt(Constants.keyDelegationId);
            delegation = (Delegation) getDbManager().getItemWithId(Delegation.class, delegationId);
            edit.setText(delegation.getName());
            Date d = delegation.getStartDate();
            if(d!= null) startDateDisplay.setText(d.toString());
            d = delegation.getEndDate();
            if(d!= null) endDateDisplay.setText(d.toString());
        }else
            delegation = new Delegation();
    }

    private void setupPersonButton(Button button) {
        pickPersonButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(contactPickerIntent, 1);
            }
        });
    }

    private void setupSaveButton(Button btn) {
        final Activity activity = this;
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = edit.getText().toString();
                if (null != name && name.length() > 0) {
                    if (null != delegation) {
                        updateDelegation(name);
                    } else {
                        createNewDelegation(name);
                    }
                    finish();
                } else {
                    new AlertDialog.Builder(activity)
                            .setTitle("Error")
                            .setMessage("Invalid name!")
                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).show();
                }
            }
        });
    }

    private void updateDelegation(String name) {
        if (null != delegation) {
            delegation.setName(name);
            getDbManager().updateItem(Delegation.class, delegation);
        }
    }

    private void createNewDelegation(String name) {



        //Person x = new Person("raz", "dwa", 9872653978654L, "zimbabwe", "Harare", 0);
        //Person y = new Person("trzy", "cztery", 10000000L, "pol", "war", 0);


         //delegation.setName(name);
         //delegation.setPerson(y);
         //getDbManager().addItem(Delegation.class,delegation);
         //getDbManager().addItem(Delegation.class, x);


    }
}
