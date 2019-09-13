package com.github.Sourav242.customdialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Sourav242 on 22-03-2018.
 */

public class NormalImageDialog extends DialogBase {

    private final TextView dialog_title, dialog_message;
    private final ImageView dialog_icon, dialog_image;
    private final LinearLayout dialog_main, dialog_icon_title_container, btn_container;
    public static final int CENTER = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    public static final class Text {
        public static final int NORMAL = 1;
        public static final int BOLD = 2;
    }

    public NormalImageDialog(Context context) {
        this.context = context;

        dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog_simple);

        dialog_main = dialog.findViewById(R.id.dialog_main);
        dialog_icon_title_container = dialog.findViewById(R.id.dialog_icon_title_container);
        dialog_title = dialog.findViewById(R.id.dialog_title);
        dialog_message = dialog.findViewById(R.id.dialog_message);
        dialog_icon = dialog.findViewById(R.id.dialog_icon);
        dialog_image = dialog.findViewById(R.id.dialog_image);
        btn_container = dialog.findViewById(R.id.btn_container);
        btn_container.setVisibility(View.GONE);
        initializeOkCancel();
    }

    public NormalImageDialog setGravity(int gravity) {
        switch (gravity) {
            case CENTER :
                dialog_title.setGravity(Gravity.CENTER);
                dialog_message.setGravity(Gravity.CENTER);
                dialog_icon_title_container.setGravity(Gravity.CENTER);
                dialog_main.setGravity(Gravity.CENTER);
                break;
            case LEFT :
                dialog_title.setGravity(Gravity.START);
                dialog_message.setGravity(Gravity.START);
                dialog_icon_title_container.setGravity(Gravity.START);
                dialog_main.setGravity(Gravity.START);
                break;
            case RIGHT :
                dialog_title.setGravity(Gravity.END);
                dialog_message.setGravity(Gravity.END);
                dialog_icon_title_container.setGravity(Gravity.END);
                dialog_main.setGravity(Gravity.END);
                break;
        }
        return this;
    }

    public NormalImageDialog setTitle(String title) {
        return setTitle(title, 0, Text.NORMAL, 16);
    }

    public NormalImageDialog setTitle(String title, int color, int style, int size) {
        dialog_title.setText(title);
        dialog_icon_title_container.setVisibility(View.VISIBLE);
        dialog_title.setVisibility(View.VISIBLE);
        if (color != 0) {
            dialog_title.setTextColor(color);
        }
        switch (style) {
            case Text.NORMAL :
                dialog_title.setTypeface(Typeface.DEFAULT);
                break;
            case Text.BOLD :
                dialog_title.setTypeface(Typeface.DEFAULT_BOLD);
                break;
        }
        dialog_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        return this;
    }

    public NormalImageDialog setMessage(String msg) {
        return setMessage(msg, 0, Text.NORMAL, 16);
    }

    public NormalImageDialog setMessage(String msg, int color, int style, int size) {
        dialog_message.setVisibility(View.VISIBLE);
        dialog_message.setText(msg);
        if (color != 0) {
            dialog_message.setTextColor(color);
        }
        switch (style) {
            case Text.NORMAL :
                dialog_message.setTypeface(Typeface.DEFAULT);
                break;
            case Text.BOLD :
                dialog_message.setTypeface(Typeface.DEFAULT_BOLD);
                break;
        }
        dialog_message.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        return this;
    }

    public NormalImageDialog setIcon(int resId) {
        try {
            dialog_icon.setImageDrawable(this.context.getResources().getDrawable(resId));
            dialog_icon_title_container.setVisibility(View.VISIBLE);
            dialog_icon.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public NormalImageDialog setImage(int resId) {
        return setImage(resId, 0, 0);
    }

    public NormalImageDialog setImage(int resId, int widthDp, int heightDp) {
        try {
            dialog_image.setImageDrawable(this.context.getResources().getDrawable(resId));
            dialog_image.setVisibility(View.VISIBLE);
            if (widthDp != 0 && heightDp != 0) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dpToPx(this.context, widthDp), dpToPx(this.context, heightDp));
                params.setMargins(dpToPx(this.context, 16), 0, dpToPx(this.context, 16), dpToPx(this.context, 16));
                dialog_image.setLayoutParams(params);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public NormalImageDialog setCancelButton(String btnName, final DialogButtonClickListener listener) {
        btn_container.setVisibility(View.VISIBLE);
        dialog_cancel.setText(btnName);
        dialog_cancel.setVisibility(View.VISIBLE);
        dialog_cancel.setOnClickListener(view -> {
            dialog.dismiss();
            listener.onClick(dialog);
        });
        return this;
    }

    public NormalImageDialog setOkButton(final DialogButtonClickListener listener) {
        return setOkButton(this.context.getResources().getString(R.string.custom_dialog_ok), listener);
    }

    public NormalImageDialog setOkButton(String btnName, final DialogButtonClickListener listener) {
        btn_container.setVisibility(View.VISIBLE);
        dialog_ok.setText(btnName);
        dialog_ok.setVisibility(View.VISIBLE);
        dialog_ok.setOnClickListener(view -> {
            dialog.dismiss();
            listener.onClick(dialog);

        });
        return this;
    }

    private void initializeOkCancel() {
        dialog_ok = dialog.findViewById(R.id.dialog_ok);
        dialog_cancel = dialog.findViewById(R.id.dialog_cancel);

        dialog_ok.setVisibility(View.GONE);
        dialog_cancel.setVisibility(View.GONE);
        dialog_ok.setOnClickListener(view -> dialog.dismiss());
        dialog_cancel.setOnClickListener(view -> dialog.dismiss());
    }

    public NormalImageDialog setCancelable(boolean bool) {
        dialog.setCancelable(bool);
        return this;
    }
}
