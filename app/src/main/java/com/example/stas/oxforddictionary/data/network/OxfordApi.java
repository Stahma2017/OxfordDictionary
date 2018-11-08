package com.example.stas.oxforddictionary.data.network;

import com.example.stas.oxforddictionary.data.entity.definition.EntryResponseEntity;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OxfordApi {

    @GET("api/v1/entries/{source_lang}/{word_id}")
    Observable<EntryResponseEntity> searchForEntry(@Path("source_lang") String lang, @Path("word_id") String word);

}
