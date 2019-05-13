package com.example.stas.oxforddictionary.domain.usecase.definition

import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import com.example.stas.oxforddictionary.domain.DefinitionRepository
import io.reactivex.Completable

class SaveWordUseCase(private val definitionRepository: DefinitionRepository) {

    fun saveWord(model: SavedWordModel):Completable =
        definitionRepository.saveDefinition(model)
}