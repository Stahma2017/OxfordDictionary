package com.example.stas.oxforddictionary.domain.usecase.definition

import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import com.example.stas.oxforddictionary.domain.DefinitionRepository
import io.reactivex.Flowable

class FetchSavedWordsUseCase(private val definitionRepository: DefinitionRepository){

    fun fetchSavedWord():Flowable<List<SavedWordModel>> =
        definitionRepository.fetchSavedWords()

}