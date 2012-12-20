package com.lpiatek;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.util.List;

public class MyActivity extends Activity { //} implements SensorEventListener {

    private static final String TAG = "Delegacy";

    //private final SensorManager mSensorManager;
    //private final Sensor mAccelerometer;

    public MyActivity() {
    }


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        System.out.println("Print works");
        Log.i(TAG, "This is informational message");

    }

}
