package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements ListActivityAdapter.SelectedManga{

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;
    TextView title;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        title = findViewById(R.id.CategoryTitle);
        EditText editText = findViewById(R.id.SearchBar);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        ArrayList<Manga> allManga = TestDataProvider.getManga();

        mlayoutManager = new LinearLayoutManager(this);
        mRecyclerView = findViewById(R.id.recyclerView2);
        mAdapter = new ListActivityAdapter(allManga, this);

        // won't change size of recycle view
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void selectedManga(Manga manga) {
        startActivity(new Intent(SearchActivity.this, DetailsActivity.class).putExtra("data", manga));
    }

    public void filter(String userInput){
        ArrayList<Manga> filteredList = new ArrayList<>();
        ArrayList<Manga> allManga = TestDataProvider.getManga();
        title = findViewById(R.id.SearchInput);

        for(Manga manga: allManga){
            if(manga.getMangaName().toLowerCase().startsWith(userInput.toLowerCase())){
                filteredList.add(manga);
            }
            if(filteredList.size() == allManga.size()){
                title.setText("All Manga");
            }else if (filteredList.size() <= 0){
                title.setText("Sorry, no results found for " + "\"" + userInput + "\"");
            }else {
                title.setText(String.valueOf(filteredList.size())+ " Results for " + "\"" + userInput + "\"");
            }
        }
        mAdapter = new ListActivityAdapter(filteredList, this);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
