package com.example.user.contactsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.contactsapp.Model.ContactData;
import com.example.user.contactsapp.Model.ContactDataProvider;
import com.example.user.contactsapp.View.ContactDataAdapter;

import java.util.ArrayList;

import static com.example.user.contactsapp.MainActivity.INDEX;
import static com.example.user.contactsapp.MainActivity.TYPE;

public class ContactEditActivity extends AppCompatActivity {
    private ContactData contactData;
    private EditText etName;
    private EditText etAdress;
    private EditText etPostCode;
    private EditText etPhoneNumber;
    private Button back;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_edit);

        etName = findViewById(R.id.etName);
        etAdress = findViewById(R.id.etAdress);
        etPostCode = findViewById(R.id.etPostCode);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        back = findViewById(R.id.button);


        intent = getIntent();

        if (intent.getStringExtra(TYPE).equals("edit")){
            int index = intent.getIntExtra(INDEX, -1);

            if (index >= 0 && index < ContactDataProvider.contactDataList.size()) {
                contactData = ContactDataProvider.contactDataList.get(index);

                updateViews();

                back.setText("Finish editing");
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finishEditing();
                    }
                });
            }
        } else if (intent.getStringExtra(TYPE).equals("new")) {
            back.setText("Add new Contact");
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addNewContact();
                }
            });
        }
    }

    private void updateViews() {
        etName.setText(contactData.getName());
        etName.setSelection(etName.getText().length());
        etPhoneNumber.setText(contactData.getPhoneNumber());
        etPhoneNumber.setSelection(etPhoneNumber.getText().length());
        if (contactData.getAdress() != null) {
            etAdress.setText(contactData.getAdress());
            etName.setSelection(etName.getText().length());
        }
        if (contactData.getPostCode() != null) {
            etPostCode.setText(contactData.getPostCode());
            etName.setSelection(etName.getText().length());
        }

    }

    private boolean finishEditing(){
        boolean finish = true;
        String name = etName.getText().toString();
        if (TextUtils.isEmpty(name)) {
            etName.setError("Name cannot be empty");
            finish=false;
        }

        String phoneNumber = etPhoneNumber.getText().toString();
        if (TextUtils.isEmpty(phoneNumber)) {
            etPhoneNumber.setError("Phone number cannot be empty");
            finish=false;
        }

        if (finish){
            contactData.setName(name);
            contactData.setPhoneNumber(phoneNumber);

            String adress= etAdress.getText().toString();
            if (TextUtils.isEmpty(adress)) {
                contactData.setAdress(null);
            }

            String postcode= etPostCode.getText().toString();
            if (TextUtils.isEmpty(postcode)) {
                contactData.setPostCode(null);
            }

            Intent back = new Intent(this, MainActivity.class);
            startActivity(back);
            return true;

        }

        return false;
    }

    private boolean addNewContact(){
        boolean finish = true;
        String name = etName.getText().toString();
        if (TextUtils.isEmpty(name)) {
            etName.setError("Name cannot be empty");
            finish=false;
        }

        String phoneNumber = etPhoneNumber.getText().toString();
        if (TextUtils.isEmpty(phoneNumber)) {
            etPhoneNumber.setError("Phone number cannot be empty");
            finish=false;
        }

        if (finish){
            String adress= etAdress.getText().toString();
            if (TextUtils.isEmpty(adress)) {
                adress=null;
            }

            String postcode= etPostCode.getText().toString();
            if (TextUtils.isEmpty(postcode)) {
                postcode=null;
            }

            ContactDataProvider.addNew(new ContactData(name,adress,postcode,phoneNumber));
            Intent back = new Intent(this, MainActivity.class);
            startActivity(back);
            return true;

        }

        return false;
    }

    @Override
    public void onBackPressed() {
        if (intent.getStringExtra(TYPE).equals("edit")){
            if (finishEditing()) {
                super.onBackPressed();
            }
        } else if (intent.getStringExtra(TYPE).equals("new")) {
            if (addNewContact()) {
                super.onBackPressed();
            }
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
    }
}
