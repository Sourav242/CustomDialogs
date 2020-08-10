package com.github.Sourav242.customdialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by JOY on 23-03-2018.
 */

public class ProgressCircleDialog extends DialogBase {

    private final TextView dialog_message;
    private final ProgressBar progressBar;
    private final LinearLayout btn_container;

    public ProgressCircleDialog(Context context) {
        this.context = context;

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog_progress);

        dialog_message = dialog.findViewById(R.id.dialog_message);
        progressBar = dialog.findViewById(R.id.progressBar);
        btn_container = dialog.findViewById(R.id.btn_container);
        btn_container.setVisibility(View.GONE);
        initializeOkCancel();

    }
    public ProgressCircleDialog setMessage(String msg) {
        dialog_message.setText(msg);
        dialog_message.setVisibility(View.VISIBLE);
        return this;
    }

    public ProgressCircleDialog setCancelable(boolean bool) {
        if(!bool) {
            btn_container.setVisibility(View.GONE);
        }
        dialog.setCancelable(bool);
        return this;
    }

    public ProgressCircleDialog setCancelButton(String btnName, final DialogButtonClickListener listner) {
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
        dialog_cancel.setVisibility(View.GONE);
        dialog_ok.setOnClickListener(view -> dialog.dismiss());
        //dialog_cancel.setOnClickListener(view -> dialog.dismiss());
    }
}
