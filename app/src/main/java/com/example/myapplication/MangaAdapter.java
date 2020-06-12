package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MangaAdapter extends ArrayAdapter {

    int nlayoutID;
    List<Manga> nMangas;
    Context nContext;

    public MangaAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        nContext = context;
        nlayoutID = resource;
        nMangas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Get a reference to the current ListView item
        View currentListViewItem = convertView;

        // Check if the existing view is being reused, otherwise inflate the view
        if (currentListViewItem == null) {
            currentListViewItem = LayoutInflater.from(getContext()).inflate(nlayoutID, parent, false);
        }
        //Get the Number object for the current position
        Manga currentManga = nMangas.get(position);

        //Set the attributed of list_view_number_item views
        ImageView iconImageView = (ImageView) currentListViewItem.findViewById(R.id.icon_image_view);
        int i = nContext.getResources().getIdentifier(currentManga.getIconName(), "drawable", nContext.getPackageName());

        //Setting the icon
        iconImageView.setImageResource(i);

        TextView MangaTitle = (TextView) currentListViewItem.findViewById(R.id.manga_title);
        MangaTitle.setText(currentManga.getMangaName());

        TextView MangaPrice = (TextView) currentListViewItem.findViewById(R.id.manga_price);
        MangaPrice.setText("$ " + currentManga.getPrice());

//        //Getting the audio resource id for the current Number object
//        final String audio = currentNumber.getAudioFilename();
//        final ImageView play = (ImageView) currentListViewItem.findViewById(R.id.play_image_view);
//
//        //Setting the image click handler
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Operations to perform when the play ImageView is clicked
//                int i = mContext.getResources().getIdentifier(
//                        audio, "raw",
//                        mContext.getPackageName());
//                //Using MediaPlayer to play the audio file
//                if (mediaPlayer != null)
//                    mediaPlayer.release();
//                mediaPlayer = MediaPlayer.create(mContext, i);
//                mediaPlayer.start();
//
//            }
//        });

        return currentListViewItem;
    }
}
