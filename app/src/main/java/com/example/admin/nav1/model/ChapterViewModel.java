package com.example.admin.nav1.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.example.admin.nav1.R;
import com.example.admin.nav1.ui.TextFragment;


public class ChapterViewModel extends AndroidViewModel {

    private static Fragment fragment = new TextFragment();
    private static int widthView = 0;

    public ChapterViewModel(@NonNull Application application) {
        super(application);
    }


    public void getCurrentFragment(Fragment fragment){

        ChapterViewModel.fragment = fragment;
    }

    public void setWidthView(int widthView) {
        ChapterViewModel.widthView = widthView;
    }

    public int getWidthView (){

        return widthView;
    }
    public Fragment getData(){

        return fragment;
    }

}
