package com.example.stas.oxforddictionary.presentation.view.synonym.adapter

interface SynonymsItem {

    val type: Int

    companion object {
        const val TYPE_CATEGORY = 0
        const val TYPE_EXAMPLE = 1
        const val TYPE_SYNONYM = 2
        const val TYPE_SUBSYNONYM = 3
    }
}
