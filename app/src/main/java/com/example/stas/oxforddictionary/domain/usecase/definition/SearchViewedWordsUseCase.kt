package com.example.stas.oxforddictionary.domain.usecase.definition

import com.example.stas.oxforddictionary.data.database.model.ViewedWordModel
import com.example.stas.oxforddictionary.domain.DefinitionRepository
import io.reactivex.Observable

class SearchViewedWordsUseCase (private val definitionRepository: DefinitionRepository){

    fun searchViewedWords(text: String): Observable<List<ViewedWordModel>> =
            definitionRepository.searchViewedWords(text)
}