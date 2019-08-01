package com.github.Sourav242.customdialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import com.gitlab.Sourav242.customdialogs.R;

/**
 * Created by Sourav242 on 22-03-2018.
 */

public class DialogBase {

    protected Context context;
    protected AlertDialog.Builder builder;
    protected Button dialog_ok, dialog_cancel;
    protected Dialog dialog;

    public void initializeOkCancel(final Dialog dialog) {
        this.dialog = dialog;
        dialog_ok = dialog.findViewById(R.id.dialog_ok);
        dialog_cancel = dialog.findViewById(R.id.dialog_cancel);

        dialog_ok.setVisibility(View.GONE);
        dialog_ok.setOnClickListener(view -> dialog.dismiss());
        dialog_cancel.setOnClickListener(view -> dialog.dismiss());
    }

    public void show() {
        if (builder != null) {
            builder.create().show();
        } else if (dialog != null) {
            dialog.show();
        }
    }

    public void dismiss() {
       dialog.dismiss();
    }

    public boolean isShowing() {
        return  dialog.isShowing();
    }

    /**
     * This method converts device specific density to pixels independent pixels.
     *
     * @param context Context to get resources and device specific display metrics
     * @param dp A value in dp (density independent pixel). Which we need to convert into px (pixel)
     * @return An int value to represent px equivalent to dp value
     */
    public static int dpToPx(Context context, float dp) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param context Context to get resources and device specific display metrics
     * @param px A value in px (pixels) unit. Which we need to convert into db (density independent pixel)
     * @return An int value to represent dp equivalent to px value
     */
    public static int pxToDp(Context context, float px) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return (int) dp;
    }
}
