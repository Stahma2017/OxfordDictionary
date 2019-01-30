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
                id,
                language,
                mapLexicalEntriesModel(lexicalEntries),
                type,
                word
        )

fun mapLexicalEntriesModel(fromList: List<LexicalEntry>): List<LexicalEntryModel> {
    val intoList = mutableListOf<LexicalEntryModel>()
    fromList.forEach {
        intoList.add(
                LexicalEntryModel(
                        it.language,
                        it.lexicalCategory,
                        mapSentencesModel(it.sentences),
                        it.text
                )
        )
    }
    return intoList
}

fun mapSentencesModel(fromList: List<Sentence>): List<SentenceModel> {
    val intoList = mutableListOf<SentenceModel>()
    fromList.forEach {
        intoList.add(
                SentenceModel(
                        it.definitions,
                        it.domains,
                        it.regions,
                        it.registers,
                        it.senseIds,
                        it.text,
                        mapTranslationModel(it.translations)
                )
        )
    }
    return intoList
}

fun mapTranslationModel(fromList: List<Translation>): List<TranslationModel> {
    val intoList = mutableListOf<TranslationModel>()
    fromList.forEach {
        intoList.add(
                TranslationModel(
                        it.domains,
                        it.language,
                        it.regions,
                        it.registers,
                        it.text
                )
        )
    }
    return intoList
}