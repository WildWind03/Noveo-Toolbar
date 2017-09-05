package com.noveogroup.toolbar.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());
        ButterKnife.bind(this);

        onPostCreated(savedInstanceState);
    }

    protected abstract void onPostCreated(Bundle savedInstanceState);

    protected abstract int getLayout();
}
