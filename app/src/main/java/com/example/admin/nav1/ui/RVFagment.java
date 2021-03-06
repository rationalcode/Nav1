package com.example.admin.nav1.ui;

import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.nav1.R;
import com.example.admin.nav1.controller.AdapterRV;
import com.example.admin.nav1.model.Chapter;
import com.example.admin.nav1.model.ChapterDao;

import java.util.ArrayList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static com.example.admin.nav1.MainActivity.db;
import static com.example.admin.nav1.MainActivity.model;


public class RVFagment extends android.support.v4.app.Fragment {


    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);


    View view = inflater.inflate(R.layout.rv_fragment, container, false);

    view.getLayoutParams().width = model.getWidthView();

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());


        recyclerView = view.findViewById(R.id.rv);

        recyclerView.setLayoutManager(llm);

        List <Chapter> chapterList = db.chapterDao().getAll();

        AdapterRV adapterRV = new AdapterRV(getActivity(),chapterList);
        recyclerView.setAdapter(adapterRV);


        return view;
        }
}
