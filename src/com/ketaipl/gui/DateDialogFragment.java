package com.ketaipl.gui;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;


/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * To change this template use File | Settings | File Templates.
 */
public class DateDialogFragment extends DialogFragment {
    public static String TAG = "DateDialogFragment";
    OnDateSetListener onDateSetListener;
    private int year, month, day;

    public DateDialogFragment(FragmentManager fm, OnDateSetListener onDateSetListener,int year, int month,int day){
        this.year = year;
        this.month = month;
        this.day = day;

        this.setCallBack(onDateSetListener);
        this.show(fm, "Date Picker");
    }


    public void setCallBack(DatePickerDialog.OnDateSetListener onDateSetListener)
    {
        this.onDateSetListener = onDateSetListener;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity(), onDateSetListener, year, month, day);
    }
}
