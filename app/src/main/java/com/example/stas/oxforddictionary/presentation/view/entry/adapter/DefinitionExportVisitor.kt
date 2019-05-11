package com.example.stas.oxforddictionary.presentation.view.entry.adapter

import com.example.stas.oxforddictionary.presentation.viewmodel.definition.LexicalEntryModel
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SenseModel
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SubsenseModel
import java.util.ArrayList

class DefinitionExportVisitor : Visitor {

    fun export(item: Item): List<String?> {
        return item.accept(this)
    }

    override fun visitSense(sense: SenseModel): List<String> {
        val totalDefinition = StringBuilder()
        val totalExample = StringBuilder()
        val definitions = ArrayList<String>()

        for (i in 0 until sense.definitions!!.size) {
            totalDefinition.append(sense.definitions[i]).append("\n")
            definitions.add(totalDefinition.toString())
            if (!sense.examples.isEmpty()) {
                totalExample.append(sense.examples[i].text).append("\n")
                definitions.add(totalExample.toString())
            }
        }
        return definitions
    }

    override fun visitSubsense(subsense: SubsenseModel): List<String> {
        val totalDefinition = StringBuilder()
        val totalExample = StringBuilder()
        val definitions = ArrayList<String>()

        for (i in 0 until subsense.definitions!!.size) {
            totalDefinition.append(subsense.definitions[i]).append("\n")
            definitions.add(totalDefinition.toString())
            if (!subsense.examples.isEmpty()) {
                totalExample.append(subsense.examples[i].text) .append("\n")
                definitions.add(totalExample.toString())
            }
        }
        return definitions
    }

    override fun visitLexicalEntry(lexicalEntry: LexicalEntryModel): List<String?> {
        val categories = ArrayList<String?>()
        categories.add(lexicalEntry.lexicalCategory)
        return categories
    }
}
