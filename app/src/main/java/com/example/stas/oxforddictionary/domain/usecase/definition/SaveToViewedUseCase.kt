package com.example.stas.oxforddictionary.domain.usecase.definition

import com.example.stas.oxforddictionary.data.database.model.ViewedWordModel
import com.example.stas.oxforddictionary.domain.DefinitionRepository
import io.reactivex.Completable

class SaveToViewedUseCase(private val definitionRepository: DefinitionRepository) {

    fun saveWord(model: ViewedWordModel): Completable =
            definitionRepository.saveViewed(model)

}