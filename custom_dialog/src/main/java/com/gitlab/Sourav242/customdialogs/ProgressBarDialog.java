package com.gitlab.Sourav242.customdialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by Sourav242 on 22-03-2018.
 */

public class ProgressBarDialog extends DialogBase {

    private final TextView dialog_message, progressCount;
    private final ProgressBar progressBar;
    private final LinearLayout btn_container;

    public ProgressBarDialog(Context context) {
        this.context = context;

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog_horizontal_progress);

        dialog_message = dialog.findViewById(R.id.dialog_message);
        progressCount = dialog.findViewById(R.id.progressCount);
        progressBar = dialog.findViewById(R.id.progressBar);
        btn_container = dialog.findViewById(R.id.btn_container);
        btn_container.setVisibility(View.GONE);
        initializeOkCancel();
    }

    public ProgressBarDialog setMessage(String msg) {
        dialog_message.setText(msg);
        return this;
    }
    public ProgressBarDialog setMaxProgress(int maxProgress) {
        progressBar.setMax(maxProgress);
        return this;
    }

    public ProgressBarDialog setProgress(int progress) {
        progressBar.setProgress(progress);
        progressCount.setText(String.format(Locale.getDefault(), "%d%%", progress));
        return this;
    }

    public ProgressBarDialog setCancelButton(String btnName, final DialogButtonClickListener listner) {
        btn_container.setVisibility(View.VISIBLE);
        dialog_cancel.setText(btnName);
        dialog_cancel.setOnClickListener(view -> {
            dialog.dismiss();
            listner.onClick(dialog);

        });
        return this;
    }

    private void initializeOkCancel() {
        dialog_ok = (Button) dialog.findViewById(R.id.dialog_ok);
        dialog_cancel = (Button) dialog.findViewById(R.id.dialog_cancel);

        dialog_ok.setVisibility(View.GONE);
        dialog_ok.setOnClickListener(view -> dialog.dismiss());
    }

    public ProgressBarDialog setCancelable(boolean bool) {
        if(!bool) {
            btn_container.setVisibility(View.GONE);
        }
        dialog.setCancelable(bool);
        return this;
    }
}
