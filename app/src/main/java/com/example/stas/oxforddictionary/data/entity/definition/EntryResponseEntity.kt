package com.example.stas.oxforddictionary.data.entity.definition

data class EntryResponseEntity(val results: List<ResultEntity>)

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
        val pronunciations: List<PronunciationEntity>?,
        val text: String?
)

data class EntryEntity(
        val etymologies: List<String>?,
        val homographNumber: String?,
        val senses: List<SenseEntity>?
)

data class PronunciationEntity(
        val audioFile: String?,
        val dialects: List<String>?,
        val phoneticNotation: String?,
        val phoneticSpelling: String?
)

data class SenseEntity(
        val definitions: List<String>?,
        val examples: List<ExampleEntity>?,
        val id: String?,
        val short_definitions: List<String>?,
        val subsenses: List<SubsenseEntity>?
)

data class ExampleEntity(
        val text: String?
)

data class SubsenseEntity(
        val definitions: List<String>?,
        val examples: List<SubExampleEntity>?,
        val id: String?,
        val short_definitions: List<String>?,
        val domains: List<String>?
)

data class SubExampleEntity(
        val text: String?
)





