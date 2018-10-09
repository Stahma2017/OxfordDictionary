package com.example.stas.oxforddictionary.ui;

import com.example.stas.oxforddictionary.models.EntryResponse;
import com.example.stas.oxforddictionary.network.ApiClient;
import com.example.stas.oxforddictionary.network.OxfordApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;


    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getWord(String word) {



    }
}
