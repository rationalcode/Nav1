package com.example.admin.nav1.model;

public class Chapter {

    int id;

    int num;

    String chapterTitle;
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
