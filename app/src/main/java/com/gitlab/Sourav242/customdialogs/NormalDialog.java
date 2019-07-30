package com.gitlab.Sourav242.customdialogs;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

/**
 * Created by Sourav242 on 22-03-2018.
 */

public class NormalDialog extends DialogBase {

    String positiveButtonName, negativeButtonName;

    public NormalDialog(Context context) {
        this.context = context;
        positiveButtonName = "Ok";
        negativeButtonName = "Cancel";
        builder = new AlertDialog.Builder(context);
        builder.setNegativeButton(negativeButtonName, (dialog, which) -> {

        });
    }

    public NormalDialog setTitle(String title) {
        builder.setTitle(title);
        return this;
    }

    public NormalDialog setMessage(String message) {
        builder.setMessage(message);
        return this;
    }

    public NormalDialog setIcon(int resId) {
        builder.setIcon(resId);
        return this;
    }

    public NormalDialog setCancelable(boolean bool) {
        builder.setCancelable(bool);
        return this;
    }

    public NormalDialog setPositiveButton(final DialogButtonClickListener listener) {
        builder.setPositiveButton(positiveButtonName, (dialog, which) -> listener.onClick(dialog));
        return this;
    }

    public NormalDialog setOnCancelListener(final DialogButtonClickListener listener) {
        builder.setNegativeButton(negativeButtonName, (dialog, which) -> listener.onClick(dialog));
        return this;
    }

    public NormalDialog setPositiveButton(String positiveButtonName, final DialogButtonClickListener listener) {
        builder.setPositiveButton(positiveButtonName, (dialog, which) -> listener.onClick(dialog));
        return this;
    }

    public NormalDialog setNegativeButton(String negativeButtonName, final DialogButtonClickListener listener) {
        builder.setNegativeButton(negativeButtonName, (dialog, which) -> listener.onClick(dialog));
        return this;
    }

    public NormalDialog setNeutralButton(String nutralButtonName, final DialogButtonClickListener listener) {
        builder.setNeutralButton(nutralButtonName, (dialog, which) -> listener.onClick(dialog));
        return this;
    }
}
