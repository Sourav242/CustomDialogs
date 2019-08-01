package com.github.Sourav242.customdialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by JOY on 26-03-2018.
 */

public class NewProgressDialog extends DialogBase {

    public static final int PROGRESS_NORMAL = 0;
    public static final int PROGRESS_HORIZONTAL = 1;

    private final TextView dialog_message;
    private final ProgressBar progressBar;

    private final LinearLayout btn_container;

    public NewProgressDialog(Context context, Integer type) {
        this.context = context;

        dialog = new Dialog(context);
        if (type == PROGRESS_HORIZONTAL)
            dialog.setContentView(R.layout.custom_dialog_horizontal_progress);
        else
            dialog.setContentView(R.layout.custom_dialog_progress);

        dialog_message = dialog.findViewById(R.id.dialog_message);
        progressBar = dialog.findViewById(R.id.progressBar);
        btn_container = dialog.findViewById(R.id.btn_container);

        btn_container.setVisibility(View.GONE);


        initializeOkCancel();
    }

    public NewProgressDialog setMessage(String msg) {
        dialog_message.setText(msg);
        return this;
    }

    public NewProgressDialog setMaxProgress(int maxProgress) {
        progressBar.setMax(maxProgress);
        return this;
    }

    public NewProgressDialog setProgress(int maxProgress) {
        progressBar.setProgress(maxProgress);
        return this;
    }


    public NewProgressDialog setCancelable(boolean bool) {
        if (!bool) {
            btn_container.setVisibility(View.GONE);
        }
        dialog.setCancelable(bool);
        return this;
    }


    public NewProgressDialog setCancelButton(String btnName, final DialogButtonClickListener listner) {
        btn_container.setVisibility(View.VISIBLE);
        dialog_cancel.setVisibility(View.VISIBLE);
        dialog_cancel.setText(btnName);
        dialog_cancel.setOnClickListener(view -> {
            dialog.dismiss();
            listner.onClick(dialog);

        });
        return this;
    }

    private void initializeOkCancel() {

        dialog_ok = dialog.findViewById(R.id.dialog_ok);
        dialog_cancel = dialog.findViewById(R.id.dialog_cancel);

        dialog_ok.setVisibility(View.GONE);
        dialog_ok.setOnClickListener(view -> dialog.dismiss());
        //dialog_cancel.setOnClickListener(view -> dialog.dismiss());
    }
}
