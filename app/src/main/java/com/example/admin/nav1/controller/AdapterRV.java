package com.example.admin.nav1.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.nav1.MainActivity;
import com.example.admin.nav1.R;
import com.example.admin.nav1.model.Chapter;
import com.example.admin.nav1.ui.ScrollViewFragment;
import com.example.admin.nav1.ui.TextFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.admin.nav1.MainActivity.fragmentHelper;


public class AdapterRV extends RecyclerView.Adapter <AdapterRV.ViewHolder> {

    Context context;
    public static String TAG;
    private LayoutInflater inflater;
    private List<Chapter> chapters;



    public AdapterRV(Context context, List<Chapter> chapters) {
        this.context = context;
        this.chapters = chapters;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.rv_item, parent, false);

        return (new ViewHolder(v));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        Chapter chapter = chapters.get(position);
        holder.textViewNum.setText(Integer.toString(chapter.getNum()));
        holder.textViewChapterTitle.setText(chapter.getChapterTitle());
        holder.textViewChapterText.setText(chapter.getChapterText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                TextFragment.text = Integer.toString(position);
//                TextFragment.addButton = true;
//                TextFragment textFragment = new TextFragment();
//
//                fragmentHelper.replaceFragment(textFragment);

                fragmentHelper.replaceFragment(new ScrollViewFragment());


                //Toast.makeText(view.getContext(),""+ position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

         TextView textViewNum;
         TextView textViewChapterTitle;
         TextView textViewChapterText;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewNum = itemView.findViewById(R.id.textViewNum);
            textViewChapterTitle = itemView.findViewById(R.id.textViewChapterTitle);
            textViewChapterText = itemView.findViewById(R.id.textViewChapterText);

        }
    }


}
