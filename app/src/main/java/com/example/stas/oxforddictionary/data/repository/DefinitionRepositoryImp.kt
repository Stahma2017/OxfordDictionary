package com.example.stas.oxforddictionary.data.repository

import com.example.stas.oxforddictionary.data.mapper.definition.toModel
import com.example.stas.oxforddictionary.data.mapper.example.toModel
import com.example.stas.oxforddictionary.data.mapper.synonym.toModel
import com.example.stas.oxforddictionary.data.network.OxfordApi
import com.example.stas.oxforddictionary.domain.DefinitionRepository
import com.example.stas.oxforddictionary.domain.model.definition.DefinitionResult
import com.example.stas.oxforddictionary.domain.model.example.ExampleResult
import com.example.stas.oxforddictionary.domain.model.synonym.SynonymResult
import io.reactivex.Observable

class DefinitionRepositoryImp(private val oxfordApi: OxfordApi) : DefinitionRepository {

    override fun loadDefinition(word: String): Observable<DefinitionResult> {
        return oxfordApi.searchForEntry(word)
                .map { entryResponseEntity ->
                    entryResponseEntity.toModel()
                }
    }

    override fun loadSynonyms(word: String): Observable<SynonymResult> {
        return oxfordApi.searchForSynonyms(word)
                .map { synonymResponseEntity ->
                    synonymResponseEntity.toModel()
                }
    }

    override fun loadExamples(word: String): Observable<ExampleResult> {
        return oxfordApi.searchForExamples(word)
                .map { exampleResponseEntity ->
                    exampleResponseEntity.toModel()
                }
    }
}
