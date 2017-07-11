package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText numberField, nameField,primaryField, addressField, provinceField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        numberField = (EditText) findViewById(R.id.number);
        nameField = (EditText) findViewById(R.id.name);
        primaryField = (EditText) findViewById(R.id.primary);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String number = numberField.getText().toString();
        String name = nameField.getText().toString();
        String primary = primaryField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        int num = Integer.parseInt(number);
        Contact person = new Contact(personID, num, name, primary, address, province);

        appState.firebaseReference.child(personID).setValue(person);

        finish();

    }
}
