package com.example.stas.oxforddictionary.presentation.view.entry.adapter


interface Item {

    val type: Int
    fun accept(visitor: Visitor): List<String?>

    companion object {

        const val TYPE_SENSE = 0
        const val TYPE_SUBSENSE = 1
        const val TYPE_CATEGORY = 2
    }
}
