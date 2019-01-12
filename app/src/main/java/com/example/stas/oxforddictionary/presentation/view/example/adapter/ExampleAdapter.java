package com.example.stas.oxforddictionary.presentation.view.example.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.stas.oxforddictionary.R;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ExampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<String> examples;
    private final Context context;

    public ExampleAdapter(List<String> examples, Context context) {
        this.examples = examples;
        this.context = context;
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

    class ExampleViewHolder extends RecyclerView.ViewHolder{
            @BindView(R.id.exampleTW) TextView exampleTW;
        ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        void bind(String example){
            exampleTW.setText(context.getString(R.string.example_quotes, example));
        }
    }
}
