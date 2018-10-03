package com.example.stas.oxforddictionary.ui;

import com.example.stas.oxforddictionary.models.EntryResponse;
import com.example.stas.oxforddictionary.network.ApiClient;
import com.example.stas.oxforddictionary.network.OxfordApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;
    private OxfordApi apiClient = ApiClient.getRetrofit().create(OxfordApi.class);;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getWord(String word) {

        apiClient.reposForEntry("en", word, "53974e4d", "5b849e1ae6cc825986f969ce9ec8c198")
                .enqueue(new Callback<EntryResponse>() {
                    @Override
                    public void onResponse(Call<EntryResponse> call, Response<EntryResponse> response) {
                        view.showWord(response.body().getResults().get(0).getWord());
                    }

                    @Override
                    public void onFailure(Call<EntryResponse> call, Throwable t) {
                       view.showWord("Error");
                    }
                });

    }
}
