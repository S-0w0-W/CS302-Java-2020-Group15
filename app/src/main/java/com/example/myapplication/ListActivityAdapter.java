package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivityAdapter extends RecyclerView.Adapter<ListActivityAdapter.ListActivity3_v2_ViewHolder>{

    // Initialize the information that is passed into the adaptor
    private List<Manga> mMangaList;
    private SelectedManga mselectedManga;

    // If need context: "parent.getContext()"

    // put the extracted information from the item into the adapter
    public ListActivityAdapter(ArrayList<Manga> MangaList, SelectedManga selectedManga) {

        // We can now use these data that is passed in
        this.mMangaList = MangaList;
        this.mselectedManga = selectedManga;
    }

    // Where the different item views of a xml is passed into the adapter
    public class ListActivity3_v2_ViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mTextView1;
        TextView mTextView2;
        TextView mTextView3;

        public ListActivity3_v2_ViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.Image_view);
            mTextView1 = itemView.findViewById(R.id.TextView1);
            mTextView2 = itemView.findViewById(R.id.TextView2);
            mTextView3 = itemView.findViewById(R.id.TextView3);

            // Set OnClickListener when a itemView is tapped
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mselectedManga.selectedManga(mMangaList.get(getAdapterPosition()));
                }
            });
        }
    }

    // Where data will be passed into the views
    @Override
    public void onBindViewHolder(@NonNull ListActivity3_v2_ViewHolder holder, int position) {
        final Manga currentManga = mMangaList.get(position);
        holder.mImageView.setImageResource(currentManga.getDigit());
        holder.mTextView1.setText(currentManga.getMangaName());
        holder.mTextView2.setText(currentManga.getDescription());
        holder.mTextView3.setText("$" + currentManga.getPrice());
    }

    //  Where the layout of the xml is passed in (also stores the current view: ViewHolder)
    @NonNull
    @Override
    public ListActivity3_v2_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listactivity_item, parent, false);
        ListActivity3_v2_ViewHolder evh = new ListActivity3_v2_ViewHolder(v);
        return evh;
    }

    @Override
    public int getItemCount() {
        return mMangaList.size();
    }

    public void filterList (ArrayList<Manga> filteredList){
        mMangaList = filteredList;
        notifyDataSetChanged();
    }

    public interface SelectedManga{
        void selectedManga(Manga manga);
    }

}
