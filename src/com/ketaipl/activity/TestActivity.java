package com.ketaipl.activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.widget.Toast;


import com.ketaipl.R;
import com.ketaipl.db.DatabaseManager;

/**
 * Created by Luke on 28.08.13.
 */
public class TestActivity extends BaseActivity {
    static final String DEBUG_TAG = "DEBUG";
    private final static int REQUEST_CONTACTPICKER = 11101;
    ListView listView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseManager.init(this);

        ViewGroup contentView = (ViewGroup) getLayoutInflater().inflate(R.layout.add_person, null);
        listView = (ListView) contentView.findViewById(R.id.list_view);

        //Button btn = (Button) contentView.findViewById(R.id.button_add);
        //setupButton(btn, this, this.getClass());
        setContentView(contentView);
    }

    private static final int CONTACT_PICKER_RESULT = 1001;

    public void launchContactPicker(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        startActivityForResult(intent, REQUEST_CONTACTPICKER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Uri result = data.getData(); //this is line 71

        // get the phone number id from the Uri
        String id = result.getLastPathSegment();

        // query the phone numbers for the selected phone number id
        Cursor c = getContentResolver().query(Phone.CONTENT_URI, null, Phone._ID + "=?", new String[]{id}, null);

        int phoneIdx = c.getColumnIndex(Phone.NUMBER);
        int nameIdx = c.getColumnIndex(Phone.DISPLAY_NAME);

        if(c.getCount() == 1) { // contact has a single phone number
            // get the only phone number
            if(c.moveToFirst()) {
                String phoneNumber = c.getString(phoneIdx);
                String contact = c.getString(nameIdx);

                //set text of view to name and number
                Toast.makeText(getApplicationContext(), contact + ": " + phoneNumber, Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getApplicationContext(), "There are no contacts to choose from.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
