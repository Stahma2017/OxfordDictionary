package com.example.stas.oxforddictionary.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stas.oxforddictionary.R;
import com.example.stas.oxforddictionary.models.Sense;
import com.example.stas.oxforddictionary.models.Subsense;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionAdapter.DefinitionViewHolder> {

    private List<String> senses = new ArrayList<>();

    public void setList(List<Sense> senses){
       this.senses = extractSubsenses(senses);
    }
    private List<String> extractSubsenses(List<Sense> senses){
        List<String> allSenses = new ArrayList<>();
        for (Sense sense: senses) {
           allSenses.add( sense.getDefinitions().get(0));
            for (Subsense subsense: sense.getSubsenses()) {
                allSenses.add("   " + subsense.getDefinitions().get(0));
            }
        }
        return allSenses;
    }


    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new DefinitionViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.definition_recylcer_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder definitionViewHolder, int position) {
        definitionViewHolder.bind(senses.get(position));
    }

    @Override
    public int getItemCount() {
        return senses.size();
    }

    class DefinitionViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.definitionOutput)TextView definitionTW;

        public DefinitionViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(String sense)
        {
            definitionTW.setText(sense);
        }
    }
}
