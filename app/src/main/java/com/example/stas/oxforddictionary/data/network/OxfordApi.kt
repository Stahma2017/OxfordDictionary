package com.example.stas.oxforddictionary.data.network

import com.example.stas.oxforddictionary.data.entity.definition.EntryResponseEntity
import com.example.stas.oxforddictionary.data.entity.example.ExampleResponseEntity
import com.example.stas.oxforddictionary.data.entity.synonym.SynonymResponseEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface OxfordApi{
    @GET("api/v1/entries/en/{word_id}")
    fun searchForEntry(@Path("word_id") word: String): Observable<EntryResponseEntity>

    @GET("api/v1/entries/en/{word_id}/synonyms")
    fun searchForSynonyms(@Path("word_id") word: String): Observable<SynonymResponseEntity>

    @GET("api/v1/entries/en/{word_id}/sentences")
    fun searchForExamples(@Path("word_id") word: String): Observable<ExampleResponseEntity>
}