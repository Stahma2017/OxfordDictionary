package com.example.stas.oxforddictionary.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stas.oxforddictionary.R;
import com.example.stas.oxforddictionary.data.model.Sense;
import com.example.stas.oxforddictionary.data.model.Subsense;

import java.util.ArrayList;
import java.util.List;

public class MultipleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int TYPE_SENSE = 0;
    private static final int TYPE_SUBSENSE = 1;
    private List<Object> senses = new ArrayList<>();


    public void setList(List<Object> senses) {
        this.senses.addAll(senses);

    }
    public void addToList(List<Object> subsenses){
        senses.addAll(subsenses);
    }

    @Override
    public int getItemViewType(int position) {
        if (senses.get(position) instanceof Sense){
            return TYPE_SENSE;
        }else if (senses.get(position) instanceof Subsense) {
            return TYPE_SUBSENSE;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        int layout = 0;
        RecyclerView.ViewHolder viewholder;
        switch(viewType){
            case TYPE_SENSE:
                layout = R.layout.recycler_sense_item;
                View senseView = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(layout, viewGroup, false);
                viewholder = new SenseViewHolder(senseView);
                break;
            case TYPE_SUBSENSE:
                layout = R.layout.recycler_subsense_item;
                View subsenseView = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(layout, viewGroup, false);
                viewholder = new SubsenseViewHolder(subsenseView);
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()){
            case TYPE_SENSE:
                Sense sense = (Sense) senses.get(i);
                ((SenseViewHolder)viewHolder).bindSense(sense);
                break;
            case TYPE_SUBSENSE:
                Subsense subsense = (Subsense) senses.get(i);
                ((SubsenseViewHolder)viewHolder).bindSubsense(subsense);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return senses.size();
    }

    public class SenseViewHolder extends RecyclerView.ViewHolder{
        private TextView sense, example;
        public SenseViewHolder(@NonNull View itemView) {
            super(itemView);
            sense = (TextView)itemView.findViewById(R.id.senseTW);
            example = (TextView)itemView.findViewById(R.id.senseExampleTW);
        }
        void bindSense(Sense sense){
            this.sense.setText(sense.getDefinitions().get(0));
            this.example.setText("not initialized yet");
        }
    }
    public class SubsenseViewHolder extends RecyclerView.ViewHolder{
      private TextView subsense, example;
        public SubsenseViewHolder(@NonNull View itemView) {
            super(itemView);
            subsense = (TextView)itemView.findViewById(R.id.subsenseTW);
            example = (TextView)itemView.findViewById(R.id.subsenseExampleTW);
        }

        void bindSubsense(Subsense subsense){
            this.subsense.setText(subsense.getDefinitions().get(0));
            this.example.setText(subsense.getExamples().get(0).getText());
        }
    }
}
