package com.example.stas.oxforddictionary.domain.usecase.definition

import com.example.stas.oxforddictionary.domain.DefinitionRepository
import io.reactivex.Completable

class SaveWordUseCase(private val definitionRepository: DefinitionRepository) {

    fun saveWord(word: String, definition: String):Completable = Completable.fromAction {
        definitionRepository.saveDefinition(word, definition)
    }
}