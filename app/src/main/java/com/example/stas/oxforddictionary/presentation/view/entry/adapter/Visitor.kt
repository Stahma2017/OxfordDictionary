package com.example.stas.oxforddictionary.presentation.view.entry.adapter

import com.example.stas.oxforddictionary.presentation.viewmodel.definition.LexicalEntryModel
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SenseModel
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SubsenseModel

interface Visitor {
    fun visitSense(sense: SenseModel): List<String>
    fun visitSubsense(subsense: SubsenseModel): List<String>
    fun visitLexicalEntry(lexicalEntry: LexicalEntryModel): List<String?>
}
