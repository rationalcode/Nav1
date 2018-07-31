package com.example.admin.nav1.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.example.admin.nav1.R;
import com.example.admin.nav1.ui.TextFragment;


public class ChapterViewModel extends AndroidViewModel {

    public static Fragment fragment = new TextFragment();

    public ChapterViewModel(@NonNull Application application) {
        super(application);
    }


    public void getCurrentFragment(Fragment fragment){

        this.fragment = fragment;
    }

    public Fragment getData(){

        return fragment;
    }

}
