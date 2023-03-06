package com.tahaafarooq.pam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ManagerActivity extends AppCompatActivity {

    Button showBtn;
    EditText keyInp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        showBtn = (Button) findViewById(R.id.show_btn);
        keyInp = (EditText) findViewById(R.id.key_inp);

        File fileEvents = new File(ManagerActivity.this.getFilesDir()+"/files/key.txt");
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileEvents));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = sb.toString();

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = keyInp.getText().toString();
                if (key.isEmpty()) {
                    Toast.makeText(ManagerActivity.this, "Key Not Inserted", Toast.LENGTH_SHORT).show();
                } else if (key.equals(result)) {
                    Intent intent = new Intent(ManagerActivity.this, ListingActivity.class);
                    startActivity(intent);
                } else {
                    // Toast.makeText(ManagerActivity.this, "Invalid Key", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ManagerActivity.this, ListingActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}