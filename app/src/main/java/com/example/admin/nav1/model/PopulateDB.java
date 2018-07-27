package com.example.admin.nav1.model;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.String.valueOf;

public class PopulateDB extends AsyncTask{

    private ChapterDao chapterDao;

    public PopulateDB(ChapterRoomDatabase db) {
        chapterDao = db.chapterDao();
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        List<Chapter> chapterList = new ArrayList<>();
        for (int i = 1; i <21 ; i++) {
            chapterList.add(new Chapter(i,"Глава "+i, " Термины"));
        }

        chapterDao.insertAll(chapterList);

        return null;
    }
}
