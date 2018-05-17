package com.example.user.contactsapp.Model;

import java.util.ArrayList;

/**
 * Created by giova on 02-Apr-18.
 */

public class ContactDataProvider {
    public static ArrayList<ContactData> contactDataList;

    static {
        contactDataList = new ArrayList<>();

        contactDataList.add(new ContactData("hendrik", null, null, "090909090909"));
        contactDataList.add(new ContactData("some", "swamp", "idk242", "0909090909"));
        contactDataList.add(new ContactData("once", "sewer", "hello", "090909090"));
        contactDataList.add(new ContactData("human", null, "shut up", "0633507403894"));
    }

    public static void addNew(ContactData contactData){
        contactDataList.add(contactData);
    }
}
