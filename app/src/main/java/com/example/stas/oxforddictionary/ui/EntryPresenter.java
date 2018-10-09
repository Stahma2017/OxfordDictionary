package com.example.stas.oxforddictionary.ui;

import com.example.stas.oxforddictionary.models.EntryResponse;
import com.example.stas.oxforddictionary.network.ApiClient;
import com.example.stas.oxforddictionary.network.OxfordApi;

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
        apiClient.reposForEntry("en", word, "53974e4d", "5b849e1ae6cc825986f969ce9ec8c198")
                .enqueue(new Callback<EntryResponse>() {
                    @Override
                    public void onResponse(Call<EntryResponse> call, Response<EntryResponse> response) {
                        view.showDefinition(response.body().getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getSenses().get(0).getDefinitions().get(0));
                    }

                    @Override
                    public void onFailure(Call<EntryResponse> call, Throwable t) {
                        view.showDefinition("Error");
                    }
                });
    }
}
