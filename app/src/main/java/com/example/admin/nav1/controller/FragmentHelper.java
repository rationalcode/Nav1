package com.example.admin.nav1.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


import com.example.admin.nav1.MainActivity;
import com.example.admin.nav1.R;
import com.example.admin.nav1.ui.TextFragment;


public class FragmentHelper extends FragmentActivity {


    private final FragmentActivity activity;
    FragmentTransaction fragmentTransaction;

    public FragmentHelper(FragmentActivity activity) {
        this.activity = activity;
    }

    public void replaceFragment (Fragment fragment){

        fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction
                    .replace(R.id.container, fragment)
                    .addToBackStack(null);

//        if(fragment instanceof TextFragment) {
//                    fragmentTransaction.addToBackStack(null);
//        }
                    fragmentTransaction.commit();

    }


}
