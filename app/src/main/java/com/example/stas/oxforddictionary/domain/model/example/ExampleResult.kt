package com.example.stas.oxforddictionary.domain.model.example

data class ExampleResult(
        var id: String?,
        var language: String?,
        var lexicalEntries: List<LexicalEntry>,
        var type: String?,
        var word: String?
)

data class LexicalEntry(
        var language: String?,
        var lexicalCategory: String?,
        var sentences: List<Sentence>,
        var text: String?
)

data class Sentence(
        var definitions: List<String>?,
        var domains: List<String>?,
        var regions: List<String>?,
        var registers: List<String>?,
        var senseIds: List<String>?,
        var text: String?,
        var translations: List<Translation>
)

data class Translation(
        var domains: List<String>?,
        var language: String?,
        var regions: List<String>?,
        var registers: List<String>?,
        var text: String?
)


