package com.example.stas.oxforddictionary.presentation.mapper.example

import com.example.stas.oxforddictionary.domain.model.example.ExampleResult
import com.example.stas.oxforddictionary.domain.model.example.LexicalEntry
import com.example.stas.oxforddictionary.domain.model.example.Sentence
import com.example.stas.oxforddictionary.domain.model.example.Translation
import com.example.stas.oxforddictionary.presentation.viewmodel.example.ExampleResultModel
import com.example.stas.oxforddictionary.presentation.viewmodel.example.LexicalEntryModel
import com.example.stas.oxforddictionary.presentation.viewmodel.example.SentenceModel
import com.example.stas.oxforddictionary.presentation.viewmodel.example.TranslationModel


fun ExampleResult.toViewModel() =
        ExampleResultModel(
                id = id,
                language = language,
                lexicalEntries = mapLexicalEntriesModel(lexicalEntries),
                type = type,
                word = word
        )

private fun mapLexicalEntriesModel(fromList: List<LexicalEntry>): List<LexicalEntryModel> {
    val intoList = mutableListOf<LexicalEntryModel>()
    fromList.forEach {
        intoList.add(
                LexicalEntryModel(
                        language = it.language,
                        lexicalCategory = it.lexicalCategory,
                        sentences = mapSentencesModel(it.sentences),
                        text = it.text
                )
        )
    }
    return intoList
}

private fun mapSentencesModel(fromList: List<Sentence>): List<SentenceModel> {
    val intoList = mutableListOf<SentenceModel>()
    fromList.forEach {
        intoList.add(
                SentenceModel(
                        definitions = it.definitions,
                        domains = it.domains,
                        regions = it.regions,
                        registers = it.registers,
                        senseIds = it.senseIds,
                        text = it.text,
                        translations = mapTranslationModel(it.translations)
                )
        )
    }
    return intoList
}

private fun mapTranslationModel(fromList: List<Translation>): List<TranslationModel> {
    val intoList = mutableListOf<TranslationModel>()
    fromList.forEach {
        intoList.add(
                TranslationModel(
                        domains = it.domains,
                        language = it.language,
                        regions = it.regions,
                        registers = it.registers,
                        text = it.text
                )
        )
    }
    return intoList
}