package com.example.user.contactsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.contactsapp.Model.ContactData;
import com.example.user.contactsapp.Model.ContactDataProvider;
import com.example.user.contactsapp.View.ContactDataAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String INDEX = "Index";
    public static final String TYPE = "type";
    private ListView lvContacts;

    ContactDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContacts = findViewById(R.id.lvContacts);
        adapter = new ContactDataAdapter(this,ContactDataProvider.contactDataList);
        lvContacts.setAdapter(adapter);


        lvContacts.setDividerHeight(20);
        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ContactEditActivity.class);
                intent.putExtra(TYPE, "edit");
                intent.putExtra(INDEX,position);
                startActivity(intent);
            }
        });
    }

    public void addNewContact(View view){
        Intent intent = new Intent(MainActivity.this, ContactEditActivity.class);
        intent.putExtra(TYPE, "new");
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }


}
