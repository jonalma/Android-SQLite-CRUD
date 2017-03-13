package com.androidhive.androidsqlite;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class AndroidSQLiteTutorialActivity extends Activity {
    DatabaseHandler db = new DatabaseHandler(this);
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));
 
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        outputAllContacts();

        // Delete all contacts
        final Button deleteAllContactsButton = (Button) findViewById(R.id.deleteAllContacts);
        deleteAllContactsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                db.removeAll();
                outputAllContacts();
            }
        });
    }//end onCreate

    public void outputAllContacts(){
        List<Contact> contacts = db.getAllContacts();
        final TextView allContacts = (TextView) findViewById(R.id.allContactsTV);
        allContacts.setText("Currently in SQLite: \n");

        for (Contact cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);

            allContacts.append(log + "\n");
        }
    }
}