package com.example.stas.oxforddictionary.presentation.viewmodel.example

data class ExampleResultModel(
        val id: String?,
        val language: String?,
        val lexicalEntries: List<LexicalEntryModel>,
        val type: String?,
        val word: String?
)

data class LexicalEntryModel(
        val language: String?,
        val lexicalCategory: String?,
        val sentences: List<SentenceModel>,
        val text: String?
)

data class SentenceModel(
        val definitions: List<String>?,
        val domains: List<String>?,
        val regions: List<String>?,
        val registers: List<String>?,
        val senseIds: List<String>?,
        val text: String?,
        val translations: List<TranslationModel>
)

data class TranslationModel(
        val domains: List<String>?,
        val language: String?,
        val regions: List<String>?,
        val registers: List<String>?,
        val text: String?
)



