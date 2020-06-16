package com.example.myapplication;

//import androidx.appcompat.app.AppCompatActivity;
//import androidx.cardview.widget.CardView;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView = findViewById(R.id.recycler_view);

        ArrayList<Manga> mangaListPopular = TestDataProvider.getMangaPopular();


        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this,LinearLayoutManager.HORIZONTAL, false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mainAdapter= new MainAdapter(MainActivity.this,mangaListPopular);
        recyclerView.setAdapter(mainAdapter);


        final


        CardView Category1 = (CardView) findViewById(R.id.categoryActivity1);
        Category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent3 = new Intent (getBaseContext(), ListActivity.class);
                startActivity(listIntent3.putExtra("category", "Category1"));
            }
        });

        CardView Category2 = (CardView) findViewById(R.id.categoryActivity2);
        Category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent4 = new Intent (getBaseContext(), ListActivity.class);
                startActivity(listIntent4.putExtra("category", "Category2"));
            }
        });

        CardView Category3 = (CardView) findViewById(R.id.categoryActivity3);
        Category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent4 = new Intent (getBaseContext(), ListActivity.class);
                startActivity(listIntent4.putExtra("category", "Category3"));
            }
        });

        CardView search = (CardView) findViewById(R.id.searchActivityView);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent5 = new Intent (getBaseContext(), SearchActivity.class);
                startActivity(listIntent5);
            }
        });
    }
}