package com.example.admin.nav1.model;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

public class PopulateDB extends AsyncTask{

    private ChapterDao chapterDao;

    public PopulateDB(ChapterRoomDatabase db) {
        chapterDao = db.chapterDao();
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        List<Chapter> chapterList = new ArrayList<>();
        for (int i = 0; i <15 ; i++) {
            chapterList.add(new Chapter(i,"Chapter "+i, " ueiugfieg"));
        }

        chapterDao.insertAll(chapterList);

        return null;
    }
}
