package com.example.stas.oxforddictionary.presentation.mapper.definition

import com.example.stas.oxforddictionary.domain.model.definition.*
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.*

fun DefinitionResult.toViewModel()=
        ResultModel(
                id = id,
                language = language,
                lexicalEntries = mapLexicalEntriesModel(lexicalEntries),
                type = type,
                word = word
        )

private fun mapLexicalEntriesModel(fromList: List<LexicalEntry>):List<LexicalEntryModel>{
    val intoList = mutableListOf<LexicalEntryModel>()
    fromList.forEach {
        intoList.add(
                LexicalEntryModel(
                        entries = mapEntriesModel(it.entries),
                        language = it.language,
                        lexicalCategory = it.lexicalCategory,
                        pronunciations = mapPronunciationsModel(it.pronunciations),
                        text = it.text
                )
        )
    }
    return intoList
}

private fun mapPronunciationsModel(fromList: List<Pronunciation>): List<PronunciationModel>{
    val intoList = mutableListOf<PronunciationModel>()
    fromList.forEach {
        intoList.add(
                PronunciationModel(
                        audioFile = it.audioFile,
                        dialects = it.dialects,
                        phoneticSpelling = it.phoneticSpelling,
                        phoneticNotation = it.phoneticNotation
                )
        )
    }
    return intoList
}

private fun mapEntriesModel(fromList: List<Entry>): List<EntryModel>{
    val intoList = mutableListOf<EntryModel>()
    fromList.forEach {
        intoList.add(
                EntryModel(
                        etymologies = it.etymologies,
                        homographNumber = it.homographNumber,
                        senses = mapSensesModel(it.senses)
                )
        )
    }
    return intoList
}

private fun mapSensesModel(fromList: List<Sense>): List<SenseModel>{
    val intoList = mutableListOf<SenseModel>()
    fromList.forEach {
        intoList.add(
                SenseModel(
                        definitions = it.definitions,
                        examples = mapExamplesModel(it.examples),
                        id = it.id,
                        shortDefinitions = it.shortDefinitions,
                        subsenses = mapSubsensesModel(it.subsenses)
                )
        )
    }
    return intoList
}

private fun mapExamplesModel(fromList: List<Example>): List<ExampleModel>{
    val intoList = mutableListOf<ExampleModel>()
    fromList.forEach {
        intoList.add(
                ExampleModel(
                        text = it.text
                )
        )
    }
    return intoList
}

private fun mapSubsensesModel(fromList: List<Subsense>): List<SubsenseModel>{
    val intoList = mutableListOf<SubsenseModel>()
    fromList.forEach {
        intoList.add(
                SubsenseModel(
                        definitions = it.definitions,
                        examples = mapSubexamplesModel(it.examples),
                        id = it.id,
                        shortDefinitions = it.shortDefinitions,
                        domains = it.domains
                )
        )
    }
    return intoList
}

private fun mapSubexamplesModel(fromList: List<Subexample>): List<SubexampleModel>{
    val intoList = mutableListOf<SubexampleModel>()
    fromList.forEach {
        intoList.add(
                SubexampleModel(
                        text = it.text
                )
        )
    }
    return intoList
}




