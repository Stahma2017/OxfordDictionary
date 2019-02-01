package com.example.stas.oxforddictionary.presentation.view.entry.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.stas.oxforddictionary.R
import java.util.ArrayList

class DefinitionAdapter(private val definitionExporter: DefinitionExportVisitor) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var definitions: List<Item> = ArrayList()

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
        @BindView(R.id.lexicalHeader)
        lateinit var lexicalHeader: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bindLexicalCategory(item: Item) {
            val lexicalCategory = definitionExporter.export(item)
            if (!lexicalCategory.isEmpty()) {
                lexicalHeader.text = lexicalCategory[0]
            }
        }
    }

    internal inner class SenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.senseTW)
        lateinit var sense: TextView
        @BindView(R.id.senseExampleTW)
        lateinit var example: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bindSense(item: Item) {
            val definition = definitionExporter.export(item)
            sense.text = definition[0]
            if (definition.size > 1) {
                this.example.text = definition[1]
            }
        }
    }

    internal inner class SubsenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.subsenseTW)
        lateinit var subsense: TextView
        @BindView(R.id.subsenseExampleTW)
        lateinit var subExample: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bindSubsense(item: Item) {
            val definition = definitionExporter.export(item)
            this.subsense.text = definition[0]
            if (definition.size > 1) {
                subExample.text = definition[1]
            }
        }
    }
}
