package com.example.stas.oxforddictionary.data.mapper.definition

import com.example.stas.oxforddictionary.data.entity.definition.*
import com.example.stas.oxforddictionary.domain.model.definition.*

fun EntryResponseEntity.toModel(): DefinitionResult{
    val from = results[0]
    return DefinitionResult(
            id = from.id,
            language = from.language,
            lexicalEntries = mapLexicalEntry(from.lexicalEntries),
            type = from.type,
            word = from.word
    )
}

private fun mapLexicalEntry(fromList: List<LexicalEntryEntity>? ): List<LexicalEntry>{
    val intoList = mutableListOf<LexicalEntry>()
    fromList?.forEach {
        intoList.add(
                LexicalEntry(
                        entries = mapEntrieEntity(it.entries),
                        language = it.language,
                        lexicalCategory = it.lexicalCategory,
                        pronunciations = mapPronunciationEntity(it.pronunciations),
                        text = it.text
                )
        )
    }
    return intoList
}

private fun mapPronunciationEntity(fromList: List<PronunciationEntity>?): List<Pronunciation>{
    val intoList = mutableListOf<Pronunciation>()
    fromList?.forEach {
        intoList.add(
                Pronunciation(
                        audioFile = it.audioFile,
                        dialects = it.dialects,
                        phoneticNotation = it.phoneticNotation,
                        phoneticSpelling = it.phoneticSpelling
                )
        )
    }
    return intoList
}

private fun mapEntrieEntity(fromList: List<EntryEntity>?):List<Entry>{
    val intoList = mutableListOf<Entry>()
    fromList?.forEach {
        intoList.add(
                Entry(
                     etymologies = it.etymologies,
                        homographNumber = it.homographNumber,
                        senses = mapSensesEntity(it.senses)
                )
        )
    }
    return intoList
}

private fun mapSensesEntity(fromList: List<SenseEntity>?): List<Sense>{
    val intoList = mutableListOf<Sense>()
    fromList?.forEach {
        intoList.add(
                Sense(
                        definitions = it.definitions,
                        examples = mapExamplesEntity(it.examples),
                        id = it.id,
                        shortDefinitions = it.short_definitions,
                        subsenses = mapSubsensesEntity(it.subsenses)
                )
        )
    }
    return intoList
}

private fun mapExamplesEntity(fromList: List<ExampleEntity>?): List<Example>{
    val intoList = mutableListOf<Example>()
    fromList?.forEach {
        intoList.add(
                Example(
                        text = it.text
                )
        )
    }
    return intoList
}

private fun mapSubsensesEntity(fromList: List<SubsenseEntity>?): List<Subsense>{
    val intoList = mutableListOf<Subsense>()
    fromList?.forEach {
        intoList.add(
                Subsense(
                        id = it.id,
                        domains = it.domains,
                        definitions = it.definitions,
                        shortDefinitions = it.short_definitions,
                        examples = mapSubexamplesEntity(it.examples)
                )
        )
    }
    return intoList
}

private fun mapSubexamplesEntity(fromList: List<SubExampleEntity>?): List<Subexample>{
    val intoList = mutableListOf<Subexample>()
    fromList?.forEach {
        intoList.add(
                Subexample(
                        text = it.text
                )
        )
    }
    return intoList
}
