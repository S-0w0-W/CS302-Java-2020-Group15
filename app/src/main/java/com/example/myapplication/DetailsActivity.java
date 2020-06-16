package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    // initialize variables
    //ImageView imageView;
    TextView title;
    TextView price;
    TextView catagory;
    TextView descL;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Assign variables
        title = findViewById(R.id.details_TextView_Title);
        price = findViewById(R.id.details_TextView_Price);
        descL = findViewById(R.id.details_TextView_DescL);
        description = findViewById(R.id.details_TextView_Description);
        catagory= findViewById(R.id.details_TextView_Catagory);
        Intent intent = getIntent();
        if(intent.getExtras() != null) {
            Manga manga = (Manga) intent.getSerializableExtra("data");
            title.setText(manga.getMangaName());
            price.setText( "$"+manga.getPrice());
            descL.setText( manga.getDescriptionL());
            description.setText( manga.getDescription());
            catagory.setText(manga.getCatagory());
            //ImageView img= (ImageView) findViewById(R.id.details_ImageView);
            //img.setImageResource(manga.getDigit());
            ViewPager viewPager = findViewById(R.id.viewPager);
            ImageAdapter adapter = new ImageAdapter(this, manga);
            viewPager.setAdapter(adapter);
        }

    }
}
