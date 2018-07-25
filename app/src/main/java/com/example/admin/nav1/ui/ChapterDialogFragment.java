package com.example.admin.nav1.ui;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.example.admin.nav1.MainActivity;
import com.example.admin.nav1.R;

public class ChapterDialogFragment extends android.support.v4.app.DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("CHAPTERS")
                .setItems(R.array.numbers, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        MainActivity callingActivity = (MainActivity) getActivity();
                        callingActivity.onUserSelectValue(which);
                        dialog.dismiss();

                    }
                });

        return builder.create();
    }
}
