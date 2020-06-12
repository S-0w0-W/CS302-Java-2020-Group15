package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        List<Manga> mangaList = TestDataProvider.getManga();
        MangaAdapter itemsAdapter = new MangaAdapter(this, R.layout.manga_list_view_item, mangaList);
        ListView listView = (ListView) findViewById(R.id.temp_text_view2);
        listView.setAdapter(itemsAdapter);
    }
}
