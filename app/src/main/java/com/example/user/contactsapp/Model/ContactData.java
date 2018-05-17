package com.example.user.contactsapp.Model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by giova on 02-Apr-18.
 */

public class ContactData {
    private ArrayList<Observer> observers;
    private String name;
    private String address;
    private String postCode;
    private String phoneNumber;

    public ContactData(@NonNull String name, @Nullable String adress,@Nullable String postCode, @NonNull String phoneNumber) {
        this.name = name;
        this.address = adress;
        this.postCode = postCode;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return address;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addObservers(Observer observer) {
        observers.add(observer);
    }
}
