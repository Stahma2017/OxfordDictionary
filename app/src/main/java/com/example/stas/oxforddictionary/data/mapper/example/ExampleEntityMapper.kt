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

private fun mapLexicalEntriesEntitiy(fromList: List<LexicalEntryEntity>?): List<LexicalEntry> {
    val intoList = mutableListOf<LexicalEntry>()
    fromList?.forEach {
        intoList.add(
                LexicalEntry(
                        language = it.language,
                        lexicalCategory = it.lexicalCategory,
                        sentences = mapSentencesEntity(it.sentences),
                        text = it.text)
        )
    }
    return intoList
}

private fun mapSentencesEntity(fromList: List<SentenceEntity>?): List<Sentence> {
    val intoList = mutableListOf<Sentence>()
    fromList?.forEach {
        intoList.add(
                Sentence(
                        definitions = it.definitions,
                        domains = it.domains,
                        regions = it.regions,
                        registers = it.registers,
                        senseIds = it.senseIds,
                        text = it.text,
                        translations = mapTranslationEntity(it.translations)
                )
        )
    }
    return intoList
}

private fun mapTranslationEntity(fromList: List<TranslationEntity>?): List<Translation> {
    val intoList = mutableListOf<Translation>()
    fromList?.forEach {
        intoList.add(
                Translation(
                        domains = it.domains,
                        language = it.language,
                        regions = it.regions,
                        registers = it.registers,
                        text = it.text
                ))
    }
    return intoList
}

