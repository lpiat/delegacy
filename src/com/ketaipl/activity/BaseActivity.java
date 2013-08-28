package com.ketaipl.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Luke on 28.08.13.
 */
public abstract class BaseActivity extends Activity {

    protected void setupButton(Button button, BaseActivity baseActivity, Class<? extends BaseActivity> activityClass) {
        final Activity activity = baseActivity;
        final Class<? extends BaseActivity> ac = activityClass;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(activity, ac);
                startActivity(intent);
            }
        });
    }

}
