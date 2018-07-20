package com.example.admin.nav1.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
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
import com.example.admin.nav1.ui.TextFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.admin.nav1.MainActivity.fragmentManager;
import static com.example.admin.nav1.MainActivity.fragmentTransaction;
import static com.example.admin.nav1.MainActivity.replaceFragment;


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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        Chapter chapter = chapters.get(position);
        holder.textView.setText(chapter.getChapterText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextFragment textFragment = new TextFragment();
//                TextView textView = textFragment.getView().findViewById(R.id.textView);
//                textView.setText(position);
                FragmentManager fragmentManager = view.

                replaceFragment(textFragment, fragmentManager);

                Toast.makeText(view.getContext(),""+ position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewRV);

        }
    }


}
