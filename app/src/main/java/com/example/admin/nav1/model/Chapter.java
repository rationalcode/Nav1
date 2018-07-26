package com.example.admin.nav1.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity (tableName = "chapters")
public class Chapter {

    @PrimaryKey (autoGenerate = true)
    int id;

    @ColumnInfo (name = "number")
    int num;

    @ColumnInfo (name = "chapter_title")
    String chapterTitle;

    @ColumnInfo (name = "chapter_text")
    String chapterText;

    public Chapter(int num, String chapterTitle, String chapterText) {
        this.num = num;
        this.chapterTitle = chapterTitle;
        this.chapterText = chapterText;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public String getChapterText() {
        return chapterText;
    }

    public void setChapterText(String chapterText) {
        this.chapterText = chapterText;
    }
}
