package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * class used to read, update and delete item
 */
public class DetailViewActivity extends Activity {

    private EditText numberField, nameField, primaryField, addressField, provinceField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");
        appState = ((MyApplicationData) getApplicationContext());

        numberField = (EditText) findViewById(R.id.number);
        nameField = (EditText) findViewById(R.id.name);
        primaryField = (EditText) findViewById(R.id.primary);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            numberField.setText(String.valueOf(receivedPersonInfo.number));
            nameField.setText(receivedPersonInfo.name);
            primaryField.setText(receivedPersonInfo.primary);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    /**
     * update value for one specific item
     * @param v
     */
    public void updateContact(View v){

        String id = receivedPersonInfo.uid;
        String number = numberField.getText().toString();
        String name = nameField.getText().toString();
        String primary = primaryField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        int num = Integer.parseInt(number);
        Contact person = new Contact(id, num, name, primary, address, province);

        appState.firebaseReference.child(id).setValue(person);

        finish();
    }

    /**
     * delete a specific item
     * @param v
     */
    public void eraseContact(View v)
    {
        String id = receivedPersonInfo.uid;
        appState.firebaseReference.child(id).removeValue();
        finish();
    }
}
