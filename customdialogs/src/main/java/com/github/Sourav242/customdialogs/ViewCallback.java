package com.github.Sourav242.customdialogs;

import android.view.View;

import androidx.fragment.app.DialogFragment;

public interface ViewCallback {
    View onComplete(View rootView, DialogFragment dialogFragment);
}
