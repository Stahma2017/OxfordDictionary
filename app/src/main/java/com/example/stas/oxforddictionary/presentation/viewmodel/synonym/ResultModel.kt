package com.example.stas.oxforddictionary.presentation.viewmodel.synonym

import com.example.stas.oxforddictionary.presentation.view.synonym.adapter.SynonymsItem

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
        val text: String?
) : SynonymsItem {
    override val type: Int
        get() = SynonymsItem.TYPE_CATEGORY
}

data class EntryModel(
        val homographNumber: String?,
        val senses: List<SenseModel>
)

data class SenseModel(
        val examples: List<ExampleModel>,
        val id: String?,
        val subsenses: List<SubsenseModel>,
        val synonyms: List<SynonymModel>
)

data class ExampleModel(
        val text: String?
) : SynonymsItem {
    override val type: Int
        get() = SynonymsItem.TYPE_EXAMPLE
}

data class SynonymModel(
        val id: String?,
        val language: String?,
        val text: String?
) : SynonymsItem {
    override val type: Int
        get() = SynonymsItem.TYPE_SYNONYM
}


data class SubsenseModel(
        val id: String?,
        val synonyms: List<SubsynonymModel>,
        val registers: List<String>?,
        val regions: List<String>?
)

data class SubsynonymModel(
        val id: String?,
        val language: String?,
        val text: String?
) : SynonymsItem {
    override val type: Int
        get() = SynonymsItem.TYPE_SUBSYNONYM
}
