package com.example.stas.oxforddictionary.data.mapper.example

import com.example.stas.oxforddictionary.data.entity.example.ExampleResponseEntity
import com.example.stas.oxforddictionary.data.entity.example.LexicalEntryEntity
import com.example.stas.oxforddictionary.data.entity.example.SentenceEntity
import com.example.stas.oxforddictionary.data.entity.example.TranslationEntity
import com.example.stas.oxforddictionary.domain.model.example.ExampleResult
import com.example.stas.oxforddictionary.domain.model.example.LexicalEntry
import com.example.stas.oxforddictionary.domain.model.example.Sentence
import com.example.stas.oxforddictionary.domain.model.example.Translation

fun ExampleResponseEntity.toModel(): ExampleResult {
    val from = results[0]
   return ExampleResult(
            id = from.id,
            language = from.language,
            lexicalEntries = mapLexicalEntriesEntitiy(from.lexicalEntries),
            type = from.type,
            word = from.word)
}

fun mapLexicalEntriesEntitiy(fromList: List<LexicalEntryEntity>?): List<LexicalEntry>{
    val intoList = mutableListOf<LexicalEntry>()
    fromList?.forEach {
        intoList.add(
                LexicalEntry(
                        it.language,
                        it.lexicalCategory,
                        mapSentencesEntity(it.sentences),
                        it.text)
        )
    }
    return intoList
}

fun mapSentencesEntity(fromList: List<SentenceEntity>?): List<Sentence>{
    val intoList = mutableListOf<Sentence>()
    fromList?.forEach {
        intoList.add(
                Sentence(
                        it.definitions,
                        it.domains,
                        it.regions,
                        it.registers,
                        it.senseIds,
                        it.text,
                        mapTranslationEntity(it.translations)
                )
        )
    }
    return intoList
}

fun mapTranslationEntity(fromList: List<TranslationEntity>?): List<Translation>{
    val intoList = mutableListOf<Translation>()
    fromList?.forEach {
        intoList.add(
                Translation(
                        it.domains,
                        it.language,
                        it.regions,
                        it.registers,
                        it.text
                ))
    }
    return intoList
}

