package com.example.stas.oxforddictionary.data.entity.example

data class ExampleResponseEntity(val results: List<ExampleResultEntity>)

data class ExampleResultEntity(
        val id: String?,
        val language: String?,
        val lexicalEntries: List<LexicalEntryEntity>?,
        val type: String?,
        val word: String?
)

data class LexicalEntryEntity(
        val language: String?,
        val lexicalCategory: String?,
        val sentences: List<SentenceEntity>?,
        val text: String?
)

data class SentenceEntity(
        val definitions: List<String>?,
        val domains: List<String>?,
        val regions: List<String>?,
        val registers: List<String>?,
        val senseIds: List<String>?,
        val text: String?,
        val translations: List<TranslationEntity>?
)

data class TranslationEntity(
        val domains: List<String>?,
        val language: String?,
        val regions: List<String>?,
        val registers: List<String>?,
        val text: String?
)




