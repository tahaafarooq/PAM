package com.tahaafarooq.pam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class PasswordActivity extends AppCompatActivity {
    EditText usernameInp, passwordInp, hostInp;
    Button saveBtn;
    TextView key;
    DBHandler dbHandler;
    KeyGenerator keyGen;

    static final int READ_BLOCK_SIZE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        usernameInp = (EditText) findViewById(R.id.username_inp);
        passwordInp = (EditText) findViewById(R.id.password_inp);
        hostInp = (EditText) findViewById(R.id.host_inp);
        saveBtn = (Button) findViewById(R.id.save_btn);
        key = (TextView) findViewById(R.id.key);

        dbHandler = new DBHandler(PasswordActivity.this);
        keyGen = new KeyGenerator();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyOut = keyGen.generateKey(8);
                String username = usernameInp.getText().toString();
                String password = passwordInp.getText().toString();
                String host = hostInp.getText().toString();

                if (username.isEmpty() && password.isEmpty() && host.isEmpty()) {
                    key.setText("Please Enter The Data Required");
                    return;
                }

                try {
                    FileOutputStream file = openFileOutput("key.txt", MODE_PRIVATE);
                    OutputStreamWriter writer = new OutputStreamWriter(file);
                    writer.write(keyOut);
                    writer.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                dbHandler.pushCredentials(username, password, host);
                key.setText("Key Is : "+ keyOut);
                usernameInp.setText("");
                passwordInp.setText("");
                hostInp.setText("");
            }
        });
    }
}