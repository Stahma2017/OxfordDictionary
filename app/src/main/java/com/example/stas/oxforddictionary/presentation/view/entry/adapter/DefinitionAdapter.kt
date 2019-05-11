package com.example.stas.oxforddictionary.presentation.view.entry.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stas.oxforddictionary.R
import kotlinx.android.synthetic.main.recycler_category_item.view.*
import kotlinx.android.synthetic.main.recycler_definitions_sense_item.view.*
import kotlinx.android.synthetic.main.recycler_definitions_subsense_item.view.*
import java.util.ArrayList

class DefinitionAdapter(private val definitionExporter: DefinitionExportVisitor) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var definitions: List<Item> = ArrayList()
    var starClickListener: (String) -> Unit = {}

    fun setItems(definitions: List<Item>) {
        this.definitions = definitions
    }

    override fun getItemViewType(position: Int): Int {
        return definitions[position].type
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return when (viewType) {
            Item.TYPE_SENSE -> {
                val senseView = inflater.inflate(R.layout.recycler_definitions_sense_item, viewGroup, false)
                SenseViewHolder(senseView)
            }
            Item.TYPE_SUBSENSE -> {
                val subsenseView = inflater.inflate(R.layout.recycler_definitions_subsense_item, viewGroup, false)
                SubsenseViewHolder(subsenseView)
            }
            Item.TYPE_CATEGORY -> {
                val headerView = inflater.inflate(R.layout.recycler_category_item, viewGroup, false)
                HeaderViewHolder(headerView)
            }
            else -> throw RuntimeException("Unknown type")
        }
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {
        when (viewHolder.itemViewType) {
            Item.TYPE_SENSE -> {
                val senseHolder = viewHolder as SenseViewHolder
                senseHolder.bindSense(definitions[i])
            }
            Item.TYPE_SUBSENSE -> {
                val subsenseHolder = viewHolder as SubsenseViewHolder
                subsenseHolder.bindSubsense(definitions[i])
            }
            Item.TYPE_CATEGORY -> {
                val headerHolder = viewHolder as HeaderViewHolder
                headerHolder.bindLexicalCategory(definitions[i])
            }
        }
    }

    override fun getItemCount(): Int {
        return definitions.size
    }

    internal inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindLexicalCategory(item: Item) {
            itemView.let {
                val lexicalCategory = definitionExporter.export(item)
                if (!lexicalCategory.isEmpty()) {
                    it.category.text = lexicalCategory[0]
                }
            }
        }
    }

    internal inner class SenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindSense(item: Item) {
            itemView.let {
                val definition = definitionExporter.export(item)
                it.senseTW.text = definition[0]
                if (definition.size > 1) {
                    it.example.text = definition[1]
                }
                it.senseStar.setOnClickListener { starClickListener.invoke(definition[0].toString()) }
            }
        }
    }

    internal inner class SubsenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindSubsense(item: Item) {
                with(itemView){
                    val definition = definitionExporter.export(item)
                    this.subsense.text = definition[0]
                    if (definition.size > 1) {
                        this.subExample.text = definition[1]
                    }
                }
        }
    }
}
