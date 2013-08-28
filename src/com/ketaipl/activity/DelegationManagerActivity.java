package com.ketaipl.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import android.view.ContextMenu.ContextMenuInfo;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;

import com.ketaipl.Constants;

import com.ketaipl.R;
import com.ketaipl.db.DatabaseManager;
import com.ketaipl.model.Delegation;


/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * To change this template use File | Settings | File Templates.
 */
public class DelegationManagerActivity extends BaseActivity {
    ListView listView;

    private DatabaseManager getDbManager()
    {
        return DatabaseManager.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseManager.init(this);
        ViewGroup contentView = (ViewGroup) getLayoutInflater().inflate(R.layout.main, null);
        listView = (ListView) contentView.findViewById(R.id.list_view);

        Button btnAdd = (Button) contentView.findViewById(R.id.button_add);
        setupButton(btnAdd, this, AddDelegationActivity.class);
        setContentView(contentView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupListView(listView);
        registerForContextMenu(listView);
    }

    private void setupListView(ListView lv) {
            final List<Delegation> delegations = (List<Delegation>) getDbManager().getAllItems(Delegation.class);


        ///TODO: if no delegations you want to add one  ?
            List<String> titles = new ArrayList<String>();
            if(delegations != null)
            {
                for (Delegation delegation : delegations)
                    titles.add(delegation.getName());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles);
            lv.setAdapter(adapter);

            final Activity activity = this;
            lv.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Delegation item = delegations.get(position);
                    Intent intent = new Intent(activity,AddDelegationActivity.class);
                    intent.putExtra(Constants.keyDelegationId, item.getId());
                    startActivity(intent);
                }
            });

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.help:
                Toast.makeText(this, "help!" + " " + item.getItemId(),
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.about:
                Toast.makeText(this, "about!",
                        Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void setupAddButton(Button btnAdd) {
        final Activity activity = this;
        btnAdd.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(activity, AddDelegationActivity.class);
                startActivity(intent);
            }
        });
    }
}