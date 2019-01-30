package com.example.stas.oxforddictionary.presentation.mapper.synonym

import com.example.stas.oxforddictionary.domain.model.synonym.*
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.*

fun SynonymResult.toViewModel() =
        ResultModel(
                id = id,
                language = language,
                lexicalEntries = mapLexicalEntriesModel(lexicalEntries),
                type = type,
                word = word
        )

private fun mapLexicalEntriesModel(fromList: List<LexicalEntry>): List<LexicalEntryModel>{
    val intoList = mutableListOf<LexicalEntryModel>()
    fromList.forEach {
        intoList.add(
                LexicalEntryModel(
                        entries = mapEntreisModel(it.entries),
                        language = it.language,
                        lexicalCategory = it.lexicalCategory,
                        text = it.text
                )
        )
    }
    return intoList
}

private fun mapEntreisModel(fromList: List<Entry>): List<EntryModel>{
    val intoList = mutableListOf<EntryModel>()
    fromList.forEach {
        intoList.add(
                EntryModel(
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
                        examples = mapExamplesModel(it.examples),
                        id = it.id,
                        subsenses = mapSubsensesModel(it.subsenses),
                        synonyms = mapSynonymsModel(it.synonyms)
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

private fun mapSynonymsModel(fromList: List<Synonym>): List<SynonymModel>{
    val intoList = mutableListOf<SynonymModel>()
    fromList.forEach {
        intoList.add(
                SynonymModel(
                        id = it.id,
                        language = it.language,
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
                        id = it.id,
                        synonyms = mapSubsynonymsModel(it.synonyms),
                        registers = it.registers,
                        regions = it.regions
                )
        )
    }
    return intoList
}

private fun mapSubsynonymsModel(fromList: List<Subsynonym>): List<SubsynonymModel>{
    val intoList = mutableListOf<SubsynonymModel>()
    fromList.forEach {
        intoList.add(
                SubsynonymModel(
                        id = it.id,
                        language = it.language,
                        text = it.text
                )
        )
    }
    return intoList
}




