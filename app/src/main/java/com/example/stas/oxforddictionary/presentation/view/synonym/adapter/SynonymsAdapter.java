package com.example.stas.oxforddictionary.presentation.view.synonym.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.stas.oxforddictionary.R;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.ExampleModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.LexicalEntryModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.SubSynonymModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.SynonymModel;
import java.util.List;

public class SynonymsAdapter extends RecyclerView.Adapter<SynonymsAdapter.ViewHolder> {

    private final List<SynonymsItem> synonyms;

    public SynonymsAdapter(List<SynonymsItem> synonyms) {
        this.synonyms = synonyms;
    }
    @Override
    public int getItemViewType(int position) {
        return synonyms.get(position).getType();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        switch (type){
            case SynonymsItem.TYPE_CATEGORY:
                View categoryView = layoutInflater.inflate(R.layout.recycler_category_item, viewGroup, false);
                return new CategoryViewHolder(categoryView);
            case SynonymsItem.TYPE_EXAMPLE:
                View exampleView = layoutInflater.inflate(R.layout.recycler_example_item, viewGroup, false);
                return new ExampleViewHolder(exampleView);
            case SynonymsItem.TYPE_SYNONYM:
                View synonymView = layoutInflater.inflate(R.layout.recycler_synonym_item, viewGroup, false);
                return new SynonymViewHolder(synonymView);
            case SynonymsItem.TYPE_SUBSYNONYM:
                View subsynonymView = layoutInflater.inflate(R.layout.recycler_synonym_item, viewGroup, false);
                return new SubsynonymViewHolder(subsynonymView);
            default:
                throw new RuntimeException("Unknown type");
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int pos) {
        SynonymsItem item = synonyms.get(pos);
        viewHolder.bindType(item);
    }

    @Override
    public int getItemCount() {
        return synonyms.size();
    }

    public abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void bindType(SynonymsItem item);
    }

    public class CategoryViewHolder extends ViewHolder{
        private final TextView category;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            category = (TextView) itemView.findViewById(R.id.lexicalHeader);
        }
        @Override
        public void bindType(SynonymsItem item) {
            category.setText(((LexicalEntryModel)item).getLexicalCategory());
        }
    }

    public class ExampleViewHolder extends ViewHolder{
        private final TextView example;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            example = itemView.findViewById(R.id.synonymExample);
        }
        @Override
        public void bindType(SynonymsItem item) {
            //todo replace the quotation mark
            example.setText("\""+((ExampleModel)item).getText()+"\"");
        }
    }

    public class SynonymViewHolder extends ViewHolder{
        private final TextView synonym;
        public SynonymViewHolder(@NonNull View itemView) {
            super(itemView);
            synonym = itemView.findViewById(R.id.synonym);
        }

        @Override
        public void bindType(SynonymsItem item) {
            synonym.setText(((SynonymModel)item).getText());
        }
    }

    public class SubsynonymViewHolder extends ViewHolder{
        private final TextView synonym;
        public SubsynonymViewHolder(View itemView) {
            super(itemView);
            synonym = itemView.findViewById(R.id.synonym);
        }

        @Override
        public void bindType(SynonymsItem item) {
            synonym.setText(((SubSynonymModel)item).getText());
        }
    }




}
