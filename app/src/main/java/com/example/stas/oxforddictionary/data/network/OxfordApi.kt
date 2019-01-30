package com.example.stas.oxforddictionary.data.network

import retrofit2.http.GET

interface OxfordApi{
    @GET("api/v1/entries/en/{word_id}")
}