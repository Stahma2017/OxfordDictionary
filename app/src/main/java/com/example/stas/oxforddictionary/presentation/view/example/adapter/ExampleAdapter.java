package com.example.stas.oxforddictionary.presentation.view.example.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stas.oxforddictionary.R;

import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<String> examples;

    public ExampleAdapter(List<String> examples) {
        this.examples = examples;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_examples_example_item, viewGroup, false);
        return new ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ExampleViewHolder)viewHolder).bind(examples.get(i));
    }

    @Override
    public int getItemCount() {
        return examples.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{
            private final TextView exampleTW;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            exampleTW = (TextView) itemView.findViewById(R.id.exampleTW);
        }
        void bind(String example){
            exampleTW.setText(example);
        }
    }
}
