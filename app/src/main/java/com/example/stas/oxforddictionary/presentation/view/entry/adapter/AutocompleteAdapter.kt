package com.example.stas.oxforddictionary.presentation.view.entry.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stas.oxforddictionary.R
import kotlinx.android.synthetic.main.recycler_autocompletes.view.*

class AutocompleteAdapter: RecyclerView.Adapter<AutocompleteAdapter.AutocompleteViewHolder>(){

    private var autocompletes: List<String> = ArrayList()

    fun setList(autocompletes: List<String>){
        this.autocompletes = autocompletes
    }

    fun clear(){
        autocompletes = ArrayList()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AutocompleteViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.recycler_autocompletes, p0, false)
        return AutocompleteViewHolder(view)
    }

    override fun getItemCount(): Int {
       return autocompletes.size
    }

    override fun onBindViewHolder(p0: AutocompleteViewHolder, p1: Int) {
        p0.bind(autocompletes[p1])
    }

    class AutocompleteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(autocomplete: String){
            itemView.let {
                it.autocomplete.text = autocomplete
            }
        }
    }
}