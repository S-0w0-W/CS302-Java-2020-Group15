package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardViewListActivity = (CardView) findViewById(R.id.cardViewListActivity);
        cardViewListActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent (getBaseContext(), ListActivity.class);
                startActivity(listIntent);
            }
        });

        CardView cardViewListActivity2 = (CardView) findViewById(R.id.cardViewListActivity2);
        cardViewListActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent2 = new Intent (getBaseContext(), ListActivity2.class);
                startActivity(listIntent2);
            }
        });
    }
}
