package com.tahaafarooq.pam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PasswordActivity extends AppCompatActivity {
    EditText usernameInp, passwordInp, hostInp;
    Button saveBtn;
    TextView key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        usernameInp = (EditText) findViewById(R.id.username_inp);
        passwordInp = (EditText) findViewById(R.id.password_inp);
        hostInp = (EditText) findViewById(R.id.host_inp);
        saveBtn = (Button) findViewById(R.id.save_btn);
        key = (TextView) findViewById(R.id.key);

        if (!(usernameInp.getText().toString().isEmpty() && passwordInp.getText().toString().isEmpty() && hostInp.getText().toString().isEmpty())) {
            // function to take the inputs and encrypt them and write into a file

        } else {
            key.setText("Try with correct inputs");
        }
    }
}