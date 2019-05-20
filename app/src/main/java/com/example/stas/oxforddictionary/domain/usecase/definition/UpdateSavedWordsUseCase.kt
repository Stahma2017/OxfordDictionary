package com.example.stas.oxforddictionary.domain.usecase.definition

import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import com.example.stas.oxforddictionary.domain.DefinitionRepository
import io.reactivex.Completable

class UpdateSavedWordsUseCase(private val definitionRepository: DefinitionRepository){
    fun updateWords(list: List<SavedWordModel>): Completable =
        definitionRepository.updateWords(list)

}