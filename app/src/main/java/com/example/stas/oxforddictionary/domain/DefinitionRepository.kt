package com.example.stas.oxforddictionary.domain

import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import com.example.stas.oxforddictionary.domain.model.definition.DefinitionResult
import com.example.stas.oxforddictionary.domain.model.example.ExampleResult
import com.example.stas.oxforddictionary.domain.model.synonym.SynonymResult
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable

interface DefinitionRepository {
    fun loadDefinition(word: String): Observable<DefinitionResult>
    fun loadSynonyms(word: String): Observable<SynonymResult>
    fun loadExamples(word: String): Observable<ExampleResult>
    fun saveDefinition(model: SavedWordModel): Completable
    fun fetchSavedWords(): Flowable<List<SavedWordModel>>
}
