package com.example.stas.oxforddictionary.presentation.view.save.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stas.oxforddictionary.R
import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import kotlinx.android.synthetic.main.recycler_saved_word_item.view.*
import java.util.ArrayList

class SavedAdapter() : RecyclerView.Adapter<SavedAdapter.SavedViewHolder>() {

    private var words: List<SavedWordModel> = ArrayList()

    fun setWords(words: List<SavedWordModel>){
        this.words = words
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SavedViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.recycler_saved_word_item, viewGroup, false)
        return SavedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return words.size
    }

    override fun onBindViewHolder(viewHolder: SavedViewHolder, i: Int) {
         viewHolder.bind(words[i])
    }

    inner class SavedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(word: SavedWordModel){
            itemView.let {
                it.savedWord.text = word.value
            }
        }

    }
}