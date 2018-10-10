package com.example.stas.oxforddictionary.ui;

import android.support.annotation.NonNull;

import com.example.stas.oxforddictionary.models.EntryResponse;
import com.example.stas.oxforddictionary.models.Sense;
import com.example.stas.oxforddictionary.network.ApiClient;
import com.example.stas.oxforddictionary.network.OxfordApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class EntryPresenter implements EntryContract.Presenter {
    private EntryContract.View view;
    private OxfordApi apiClient = ApiClient.getRetrofit().create(OxfordApi.class);

    EntryPresenter(EntryContract.View view) {
        this.view = view;
    }

   @Override
   public void detachView(){
        view = null;
    }

    @Override
    public void getDefinition(String word) {
        apiClient.reposForEntry("en", word)
                .enqueue(new Callback<EntryResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<EntryResponse> call, @NonNull Response<EntryResponse> response) {
                        List<String> definitions = new ArrayList<>();
                        for (Sense s: response.body().getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getSenses()) {
                           definitions.addAll(s.getDefinitions());
                        }
                        view.showDefinition(definitions);


                    }

                    @Override
                    public void onFailure(Call<EntryResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
