package com.example.stas.oxforddictionary.domain

import com.example.stas.oxforddictionary.domain.model.definition.DefinitionResult
import com.example.stas.oxforddictionary.domain.model.example.ExampleResult
import com.example.stas.oxforddictionary.domain.model.synonym.SynonymResult
import io.reactivex.Observable

interface DefinitionRepository {
    fun loadDefinition(word: String): Observable<DefinitionResult>
    fun loadSynonyms(word: String): Observable<SynonymResult>
    fun loadExamples(word: String): Observable<ExampleResult>
}
