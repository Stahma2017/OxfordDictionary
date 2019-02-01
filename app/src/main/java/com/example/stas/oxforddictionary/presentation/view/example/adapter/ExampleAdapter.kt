package com.example.stas.oxforddictionary.presentation.view.example.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.stas.oxforddictionary.R

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
        @BindView(R.id.exampleTW)
        lateinit var exampleTW: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bind(example: String?) {
            exampleTW.text = context.getString(R.string.example_quotes, example)
        }
    }
}
