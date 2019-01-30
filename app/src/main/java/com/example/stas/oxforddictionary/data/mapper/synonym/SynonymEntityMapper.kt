package com.example.stas.oxforddictionary.data.mapper.synonym

import com.example.stas.oxforddictionary.data.entity.synonym.*
import com.example.stas.oxforddictionary.domain.model.synonym.*

fun SynonymResponseEntity.toModel(): SynonymResult{
    val from = results[0]
    return SynonymResult(
            id = from.id,
            language = from.language,
            lexicalEntries = mapLexicalEntriesEntity(from.lexicalEntries),
            type = from.type,
            word = from.word
    )
}

private fun mapLexicalEntriesEntity(fromList: List<LexicalEntryEntity>?): List<LexicalEntry>{
    val intoList = mutableListOf<LexicalEntry>()
    fromList?.forEach {
        intoList.add(
                LexicalEntry(
                        entries = mapEntriesEntity(it.entries),
                        language = it.language,
                        lexicalCategory = it.lexicalCategory,
                        text = it.text
                )
        )
    }
    return intoList
}

private fun mapEntriesEntity(fromList: List<EntryEntity>?): List<Entry>{
    val intoList = mutableListOf<Entry>()
    fromList?.forEach {
        intoList.add(
                Entry(
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
                        examples = mapExamplesEntity(it.examples),
                        id = it.id,
                        subsenses = mapSubsensesEntity(it.subsenses),
                        synonyms = mapSynonymsEntity(it.synonyms)
                )
        )
    }
    return intoList
}

private fun mapSynonymsEntity(fromList: List<SynonymEntity>?): List<Synonym>{
    val intoList = mutableListOf<Synonym>()
    fromList?.forEach {
        intoList.add(
                Synonym(
                        id = it.id,
                        language = it.language,
                        text = it.text
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
                        synonyms = mapSubsynonymsEntity(it.synonyms),
                        registers = it.registers,
                        regions = it.regions
                )
        )
    }
    return intoList
}

private fun mapSubsynonymsEntity(fromList: List<SubSynonymEntity>?): List<Subsynonym>{
    val intoList = mutableListOf<Subsynonym>()
    fromList?.forEach {
        intoList.add(
                Subsynonym(
                        id = it.id,
                        language = it.language,
                        text = it.text
                )
        )
    }
    return intoList
}






