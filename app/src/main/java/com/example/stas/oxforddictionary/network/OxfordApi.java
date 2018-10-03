package com.example.stas.oxforddictionary.network;

import com.example.stas.oxforddictionary.models.EntryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface OxfordApi {

    @GET("api/v1/entries/{source_lang}/{word_id}")
    Call<EntryResponse> reposForEntry(@Path("source_lang") String lang, @Path("word_id") String word, @Header("app_id") String app_id, @Header("app_key") String api_key);
}
