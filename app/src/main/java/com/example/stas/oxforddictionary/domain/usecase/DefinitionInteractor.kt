package com.example.stas.oxforddictionary.domain.usecase

import com.example.stas.oxforddictionary.domain.DefinitionRepository
import com.example.stas.oxforddictionary.domain.model.definition.DefinitionResult
import com.example.stas.oxforddictionary.domain.model.example.ExampleResult
import com.example.stas.oxforddictionary.domain.model.synonym.SynonymResult
import io.reactivex.Observable

class DefinitonInteractor(private val repository: DefinitionRepository) {

    fun loadDefinition(word: String): Observable<DefinitionResult> {
        return repository.loadDefinition(word)
    }

    fun loadSynonyms(word: String): Observable<SynonymResult> {
        return repository.loadSynonyms(word)
    }

    fun loadExamples(word: String): Observable<ExampleResult> {
        return repository.loadExamples(word)
    }

}
