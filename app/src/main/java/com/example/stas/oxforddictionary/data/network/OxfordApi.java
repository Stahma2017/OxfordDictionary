package com.example.stas.oxforddictionary.data.network;

import com.example.stas.oxforddictionary.data.entity.definition.EntryResponseEntity;
import com.example.stas.oxforddictionary.data.entity.example.ExampleResponseEntity;
import com.example.stas.oxforddictionary.data.entity.synonym.SynonymResponseEntity;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OxfordApi {

    @GET("api/v1/entries/en/{word_id}")
    Observable<EntryResponseEntity> searchForEntry(@Path("word_id") String word);

    @GET("api/v1/entries/en/{word_id}/synonyms")
    Observable<SynonymResponseEntity> searchForSynonyms(@Path("word_id") String word);

    @GET("api/v1/entries/en/{word_id}/sentences")
    Observable<ExampleResponseEntity> searchForExamples(@Path("word_id") String word);

}

