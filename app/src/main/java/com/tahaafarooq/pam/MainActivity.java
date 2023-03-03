package com.tahaafarooq.pam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button AddCreds, ShowCreds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddCreds = (Button) findViewById(R.id.add_creds_btn);
        ShowCreds = (Button) findViewById(R.id.retrieve_creds_btn);

        AddCreds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PasswordActivity.class);
                startActivity(intent);
            }
        });

        ShowCreds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ManagerActivity.class);
                startActivity(intent);
            }
        });
    }
}