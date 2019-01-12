package com.example.stas.oxforddictionary.presentation.view.entry.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.stas.oxforddictionary.R;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DefinitionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Item> definitions = new ArrayList<>();
    private final DefinitionExportVisitor definitionExporter;

    public DefinitionAdapter(DefinitionExportVisitor definitionExporter) {
        this.definitionExporter = definitionExporter;
    }

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
                View senseView = inflater.inflate(R.layout.recycler_definitions_sense_item, viewGroup, false);
                return new SenseViewHolder(senseView);
            case Item.TYPE_SUBSENSE:
                View subsenseView = inflater.inflate(R.layout.recycler_definitions_subsense_item, viewGroup, false);
                return new SubsenseViewHolder(subsenseView);
            case Item.TYPE_CATEGORY:
                View headerView = inflater.inflate(R.layout.recycler_category_item, viewGroup, false);
                return new HeaderViewHolder(headerView);
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
            case Item.TYPE_CATEGORY:
                HeaderViewHolder headerHolder = (HeaderViewHolder) viewHolder;
                headerHolder.bindLexicalCategory(definitions.get(i));
                break;
        }
    }
    @Override
    public int getItemCount() {
        return definitions.size();
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.lexicalHeader) TextView lexicalHeader;

        HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        void bindLexicalCategory(Item item){
            List<String> lexicalCategory = definitionExporter.export(item);
            if (!lexicalCategory.isEmpty()){
                lexicalHeader.setText(lexicalCategory.get(0));
            }
        }
    }
    class SenseViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.senseTW)TextView sense;
        @BindView(R.id.senseExampleTW) TextView example;

        SenseViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        void bindSense(Item item){
            List<String> definition = definitionExporter.export(item);
            sense.setText(definition.get(0));
            if (definition.size()>1){
                this.example.setText(definition.get(1));
            }
        }
    }
    class SubsenseViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.subsenseTW) TextView subsense;
        @BindView(R.id.subsenseExampleTW) TextView subExample;

        SubsenseViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        void bindSubsense(Item item){
            List<String> definition = definitionExporter.export(item);
            this.subsense.setText(definition.get(0));
            if (definition.size()>1){
                subExample.setText(definition.get(1));
            }
        }
    }
}
