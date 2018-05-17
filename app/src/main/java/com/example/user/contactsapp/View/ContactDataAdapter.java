package com.example.user.contactsapp.View;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.contactsapp.Model.ContactData;
import com.example.user.contactsapp.R;

import java.util.List;

/**
 * Created by giova on 02-Apr-18.
 */

public class ContactDataAdapter extends ArrayAdapter<ContactData> {
    private LayoutInflater mInflater;
    private LinearLayout container;
    private TextView tvName;
    private TextView tvPhoneNumber;
    private TextView tvAdress;
    private TextView tvPostCode;
    private List<ContactData> contactDataList;

    public ContactDataAdapter(@NonNull Context context, @NonNull List<ContactData> objects) {
        super(context, R.layout.contact_view, objects);


        contactDataList = objects;
        mInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.contact_view, parent, false);
        }

        tvName = convertView.findViewById(R.id.tvName);
        tvPhoneNumber = new TextView(convertView.getContext());
        tvAdress = new TextView(convertView.getContext());
        tvPostCode = new TextView(convertView.getContext());
        container = convertView.findViewById(R.id.linearLayout);

        tvName.setTextColor(Color.BLACK);
        tvPhoneNumber.setTextColor(Color.BLACK);
        tvAdress.setTextColor(Color.BLACK);
        tvPostCode.setTextColor(Color.BLACK);


        tvPhoneNumber.setTextSize(16);
        tvAdress.setTextSize(16);
        tvPostCode.setTextSize(16);

        container.removeAllViews();

        ContactData contactData = contactDataList.get(position);

        tvName.setText(contactData.getName());

        if (contactData.getAdress() != null) {
            tvAdress.setText("Adress               : "+contactData.getAdress());
            container.addView(tvAdress);
        }

        if (contactData.getPostCode() != null) {
            tvPostCode.setText("Post Code         : "+contactData.getPostCode());
            container.addView(tvPostCode);
        }

        tvPhoneNumber.setText("Phone Number : "+contactData.getPhoneNumber());
        container.addView(tvPhoneNumber);


        return convertView;
    }
}
