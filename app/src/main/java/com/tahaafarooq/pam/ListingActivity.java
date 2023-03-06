package com.tahaafarooq.pam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListingActivity extends AppCompatActivity {

    private ArrayList<PasswordModal> passwordModalArrayList;
    private DBHandler dbHandler;
    private HostRVAdapter hostRVAdapter;
    private RecyclerView hostRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        passwordModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ListingActivity.this);

        passwordModalArrayList = dbHandler.readCredentials();

        hostRVAdapter = new HostRVAdapter(passwordModalArrayList, ListingActivity.this);
        hostRV = findViewById(R.id.idRVHosts);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListingActivity.this, RecyclerView.VERTICAL, false);
        hostRV.setLayoutManager(linearLayoutManager);

        hostRV.setAdapter(hostRVAdapter);

    }
}