package com.example.stas.oxforddictionary.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.stas.oxforddictionary.R;
import java.util.ArrayList;
import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> definitions = new ArrayList<>();
    private DefinitionExportVisitor definitionExporter = new DefinitionExportVisitor();

    public void setItems(List<Item> definitions) {
        this.definitions = definitions;
    }

    @Override
    public int getItemViewType(int position) {
        return definitions.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        switch(viewType){
            case Item.TYPE_SENSE:
                View senseView = inflater.inflate(R.layout.recycler_sense_item, viewGroup, false);
                return new SenseViewHolder(senseView);
            case Item.TYPE_SUBSENSE:
                View subsenseView = inflater.inflate(R.layout.recycler_subsense_item, viewGroup, false);
                return new SubsenseViewHolder(subsenseView);
            default:
                throw new RuntimeException("Unknown type");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()){
            case Item.TYPE_SENSE:
                SenseViewHolder senseHolder = (SenseViewHolder) viewHolder;
                senseHolder.bindSense(definitions.get(i));
                break;
            case Item.TYPE_SUBSENSE:
                SubsenseViewHolder subsenseHolder = (SubsenseViewHolder) viewHolder;
                subsenseHolder.bindSubsense(definitions.get(i));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return definitions.size();
    }

    public class SenseViewHolder extends RecyclerView.ViewHolder{
        private TextView sense, example;

        public SenseViewHolder(@NonNull View itemView) {
            super(itemView);
            sense = (TextView)itemView.findViewById(R.id.senseTW);
            example = (TextView)itemView.findViewById(R.id.senseExampleTW);
        }

        void bindSense(Item item){
            List<String> definition = definitionExporter.export(item);
            this.sense.setText(definition.get(0));
            if (definition.size()>1){
                this.example.setText(definition.get(1));
            }
        }
    }

    public class SubsenseViewHolder extends RecyclerView.ViewHolder{
        private TextView subsense, example;

        public SubsenseViewHolder(@NonNull View itemView) {
            super(itemView);
            subsense = (TextView)itemView.findViewById(R.id.subsenseTW);
            example = (TextView)itemView.findViewById(R.id.subsenseExampleTW);
        }

        void bindSubsense(Item item){
            List<String> definition = definitionExporter.export(item);
            this.subsense.setText(definition.get(0));
            if (definition.size()>1){
                this.example.setText(definition.get(1));
            }
        }

    }
}
