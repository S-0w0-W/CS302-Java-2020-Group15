package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class ListActivity extends AppCompatActivity implements ListActivityAdapter.SelectedManga{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;
    TextView title;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listactivity);

        title = findViewById(R.id.CategoryTitle);

        ArrayList<Manga> MangaCategory1 = TestDataProvider.getMangaCatagory1();
        ArrayList<Manga> MangaCategory2 = TestDataProvider.getMangagetMangaCatagory2();
        ArrayList<Manga> MangaCategory3 = TestDataProvider.getMangagetMangaCatagory3();

        mlayoutManager = new LinearLayoutManager(this);
        mRecyclerView = findViewById(R.id.recyclerView2);

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        //title.setText(category);
        if(Objects.equals("Category1", category)){
            title.setText("Action");
            mAdapter = new ListActivityAdapter(MangaCategory1, this);
        }else if(Objects.equals("Category2", category)){
            title.setText("Adventure");
            mAdapter = new ListActivityAdapter(MangaCategory2, this);
        }else if(Objects.equals("Category3", category)){
            title.setText("Slice of Life");
            mAdapter = new ListActivityAdapter(MangaCategory3, this);
        }

        // won't change size of recycle view
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void selectedManga(Manga manga) {
        startActivity(new Intent(ListActivity.this, DetailsActivity.class).putExtra("data", manga));
    }
}
