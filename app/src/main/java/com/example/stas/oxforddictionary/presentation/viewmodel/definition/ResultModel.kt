package com.example.stas.oxforddictionary.presentation.viewmodel.definition

import com.example.stas.oxforddictionary.presentation.view.entry.adapter.Item
import com.example.stas.oxforddictionary.presentation.view.entry.adapter.Visitor

data class ResultModel(
        val id: String?,
        val language: String?,
        val lexicalEntries: List<LexicalEntryModel>,
        val type: String?,
        val word: String?
)

data class LexicalEntryModel(
        val entries: List<EntryModel>,
        val language: String?,
        val lexicalCategory: String?,
        val pronunciations: List<PronunciationModel>,
        val text: String?
): Item{
    override val type: Int
        get() = Item.TYPE_CATEGORY

    override fun accept(visitor: Visitor): List<String?> =
        visitor.visitLexicalEntry(this)
}

data class PronunciationModel(
        val audioFile: String?,
        val dialects: List<String>?,
        val phoneticNotation: String?,
        val phoneticSpelling: String?
)

data class EntryModel(
        val etymologies : List<String>?,
        val homographNumber: String?,
        val senses: List<SenseModel>
)

data class SenseModel(
        val definitions: List<String>?,
        val examples: List<ExampleModel>,
        val id: String?,
        val shortDefinitions: List<String>?,
        val subsenses: List<SubsenseModel>
):Item{
    override val type: Int
        get() = Item.TYPE_SENSE

    override fun accept(visitor: Visitor): List<String> =
        visitor.visitSense(this)
}

data  class ExampleModel(
        val text: String?
)

data class SubsenseModel(
        val definitions: List<String>?,
        val examples: List<SubexampleModel>,
        val id: String?,
        val shortDefinitions: List<String>?,
        val domains: List<String>?
):Item{
    override val type: Int
        get() = Item.TYPE_SUBSENSE

    override fun accept(visitor: Visitor): List<String> =
            visitor.visitSubsense(this)
}

data class SubexampleModel(
        val text: String?
)





