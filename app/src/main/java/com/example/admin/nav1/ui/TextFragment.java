package com.example.admin.nav1.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.nav1.R;

import static com.example.admin.nav1.MainActivity.fragmentHelper;
import static com.example.admin.nav1.MainActivity.recyclerView;
import static com.example.admin.nav1.MainActivity.rvFagment;

public class TextFragment extends Fragment {

    public static String text = "HELLO";
    public static FloatingActionButton fab;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.text_fragment,container,false);

        TextView textView = view.findViewById(R.id.textView2);
        textView.setText(text);

        fab = view.findViewById(R.id.floatingActionButton);

                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fragmentHelper.replaceFragment(rvFagment);
                    }
                });

        return view;
    }
}
