package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.util.Map;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Map<Integer, String> title = TestDataProvider.generateMangos();
        String text = "";
        for (Integer key: title.keySet()){
            text += String.valueOf(key) + " : " + title.get(key) + "\n";
        }
        TextView tempView = (TextView) findViewById(R.id.temp_text_view);
        tempView.setText(text);
    }
}
