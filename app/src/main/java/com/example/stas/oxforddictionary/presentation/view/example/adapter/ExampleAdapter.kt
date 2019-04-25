package com.example.stas.oxforddictionary.presentation.view.example.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stas.oxforddictionary.R
import kotlinx.android.synthetic.main.recycler_examples_example_item.view.*

class ExampleAdapter(private val examples: List<String?>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.recycler_examples_example_item, viewGroup, false)
        return ExampleViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {
        (viewHolder as ExampleViewHolder).bind(examples[i])
    }

    override fun getItemCount(): Int {
        return examples.size
    }

    internal inner class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(example: String?) {
            itemView.let {
               it.exampleTW.text = context.getString(R.string.example_quotes, example)
            }
        }
    }
}
