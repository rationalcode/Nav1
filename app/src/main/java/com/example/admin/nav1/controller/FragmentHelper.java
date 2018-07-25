package com.example.admin.nav1.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


import com.example.admin.nav1.MainActivity;
import com.example.admin.nav1.R;


public class FragmentHelper extends FragmentActivity {


    private final FragmentActivity activity;
    public FragmentTransaction fragmentTransaction;

    public FragmentHelper(FragmentActivity activity) {
        this.activity = activity;
    }

    public void replaceFragment (Fragment fragment){

        fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction
                    .replace(R.id.fragment, fragment)
                    .addToBackStack(null)
                    .commit();

    }


}
