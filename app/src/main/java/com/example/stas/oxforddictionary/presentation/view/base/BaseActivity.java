package com.example.stas.oxforddictionary.presentation.view.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.stas.oxforddictionary.presentation.navigation.Navigator;

public abstract class BaseActivity extends AppCompatActivity {

    protected Navigator navigator = new Navigator();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
