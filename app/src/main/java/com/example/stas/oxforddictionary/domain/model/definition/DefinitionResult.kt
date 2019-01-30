package com.example.stas.oxforddictionary.domain.model.definition

data class DefinitionResult(
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
        val pronunciations: List<Pronunciation>,
        val text: String?
)

data class Entry(
        val etymologies: List<String>?,
        val homographNumber: String?,
        val senses: List<Sense>
)

data class Pronunciation(
        val audioFile: String?,
        val dialects: List<String>?,
        val phoneticNotation: String?,
        val phoneticSpelling: String?
)

data class Sense(
        val definitions: List<String>?,
        val examples: List<Example>,
        val id: String?,
        val shortDefinitions: List<String>?,
        val subsenses: List<Subsense>
)

data class Example(
        val text: String?
)

data class Subsense(
        val id: String?,
        val domains: List<String>?,
        val definitions: List<String>?,
        val shortDefinitions: List<String>?,
        val examples: List<Subexample>
)

data class Subexample(
        val text: String?
)






