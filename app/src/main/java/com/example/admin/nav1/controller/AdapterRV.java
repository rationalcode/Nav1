package com.example.admin.nav1.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.nav1.R;
import com.example.admin.nav1.model.Chapter;

import java.util.ArrayList;
import java.util.List;



public class AdapterRV extends RecyclerView.Adapter <AdapterRV.ViewHolder> {

    public static String TAG;
    private LayoutInflater inflater;
    public ArrayList<Chapter> chapters;

    public AdapterRV(Context context, ArrayList<Chapter> chapters) {
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Chapter chapter = chapters.get(position);
        holder.textView.setText(chapter.getChapterText());

    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textViewRV);

        }
    }


}
