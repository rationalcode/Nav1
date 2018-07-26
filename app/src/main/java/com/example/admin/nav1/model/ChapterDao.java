package com.example.admin.nav1.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ChapterDao {

    @Query("SELECT * FROM chapters")
    List <Chapter> getAll();

    @Insert
    void insertAll (List<Chapter> chapterList);
}
