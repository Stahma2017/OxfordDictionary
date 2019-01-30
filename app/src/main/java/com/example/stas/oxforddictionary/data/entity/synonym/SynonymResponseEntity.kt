package com.example.stas.oxforddictionary.data.entity.synonym

data class SynonymResponseEntity(val results: List<ResultEntity>)

data class ResultEntity(
        val id: String?,
        val language: String?,
        val lexicalEntries: List<LexicalEntryEntity>?,
        val type: String?,
        val word: String?
)

data class LexicalEntryEntity(
        val entries: List<EntryEntity>?,
        val language: String?,
        val lexicalCategory: String?,
        val text: String?
)

data class EntryEntity(
        val homographNumber: String?,
        val senses: List<SenseEntity>?
)

data class SenseEntity(
        val examples: List<ExampleEntity>?,
        val id: String?,
        val subsenses: List<SubsenseEntity>?,
        val synonyms: List<SynonymEntity>?
)

data class ExampleEntity(
        val text: String?
)

data class SubsenseEntity(
        val id: String?,
        val synonyms: List<SubSynonymEntity>?,
        val registers: List<String>?,
        val regions: List<String>?
)

data class SubSynonymEntity(
        val id: String?,
        val language: String?,
        val text: String?
)

data class SynonymEntity(
        val id: String?,
        val language: String?,
        val text: String?
)






