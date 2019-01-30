package com.example.stas.oxforddictionary.domain.model.synonym

data class SynonymResult(
        val id: String?,
        val language: String?,
        val lexicalEntries: List<LexicalEntry>,
        val type: String?,
        val word: String?
)

data class LexicalEntry(
        val entries: List<Entry>,
        val language: String?,
        val lexicalCategory: String?,
        val text: String?
)

data class Entry(
        val homographNumber: String?,
        val senses: List<Sense>
)

data class Sense(
        val examples: List<Example>,
        val id: String?,
        val subsenses: List<Subsense>,
        val synonyms: List<Synonym>
)

data class Synonym(
        val id: String?,
        val language: String?,
        val text: String?
)

data class Example(
        val text: String?
)

data class Subsynonym(
        val id: String?,
        val language: String?,
        val text: String?
)

data class Subsense(
        val id: String?,
        val synonyms: List<Subsynonym>,
        val registers: List<String>?,
        val regions: List<String>?
)









