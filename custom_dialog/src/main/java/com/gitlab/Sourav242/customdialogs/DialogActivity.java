package com.gitlab.Sourav242.customdialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        new NormalDialog(this).setTitle("Hello").setMessage("Hello message").show();
    }
}
