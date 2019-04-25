package com.example.stas.oxforddictionary.presentation.view.synonym.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stas.oxforddictionary.R
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.ExampleModel
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.LexicalEntryModel
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.SubsynonymModel
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.SynonymModel
import kotlinx.android.synthetic.main.recycler_category_item.view.*
import kotlinx.android.synthetic.main.recycler_synonyms_example_item.view.*
import kotlinx.android.synthetic.main.recycler_synonyms_synonym_item.view.*


class SynonymsAdapter(private val synonyms: List<SynonymsItem>, private val context: Context) : RecyclerView.Adapter<SynonymsAdapter.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        return synonyms[position].type
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        when (type) {
            SynonymsItem.TYPE_CATEGORY -> {
                val categoryView = layoutInflater.inflate(R.layout.recycler_category_item, viewGroup, false)
                return CategoryViewHolder(categoryView)
            }
            SynonymsItem.TYPE_EXAMPLE -> {
                val exampleView = layoutInflater.inflate(R.layout.recycler_synonyms_example_item, viewGroup, false)
                return ExampleViewHolder(exampleView)
            }
            SynonymsItem.TYPE_SYNONYM -> {
                val synonymView = layoutInflater.inflate(R.layout.recycler_synonyms_synonym_item, viewGroup, false)
                return SynonymViewHolder(synonymView)
            }
            SynonymsItem.TYPE_SUBSYNONYM -> {
                val subsynonymView = layoutInflater.inflate(R.layout.recycler_synonyms_synonym_item, viewGroup, false)
                return SubsynonymViewHolder(subsynonymView)
            }
            else -> throw RuntimeException("Unknown type")
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, pos: Int) {
        val item = synonyms[pos]
        viewHolder.bindType(item)
    }

    override fun getItemCount(): Int {
        return synonyms.size
    }

    abstract inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun bindType(item: SynonymsItem)
    }

    inner class CategoryViewHolder internal constructor(itemView: View) : ViewHolder(itemView) {

        override fun bindType(item: SynonymsItem) {
            itemView.let {
              it.category.text = (item as LexicalEntryModel).lexicalCategory
            }
        }
    }

    inner class ExampleViewHolder internal constructor(itemView: View) : ViewHolder(itemView) {

        override fun bindType(item: SynonymsItem) {
            itemView.let {
                it.example.text = context.getString(R.string.example_quotes, (item as ExampleModel).text)
            }
        }
    }

    inner class SynonymViewHolder internal constructor(itemView: View) : ViewHolder(itemView) {

        override fun bindType(item: SynonymsItem) {
            itemView.let {
                it.synonym.text = (item as SynonymModel).text
            }
        }
    }

    inner class SubsynonymViewHolder internal constructor(itemView: View) : ViewHolder(itemView) {

        override fun bindType(item: SynonymsItem) {
            itemView.let {
                it.synonym.text = (item as SubsynonymModel).text
            }
        }
    }
}
