package com.example.stas.oxforddictionary.presentation.view.synonym.adapter;

import android.content.Context;
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
import butterknife.BindView;
import butterknife.ButterKnife;

public class SynonymsAdapter extends RecyclerView.Adapter<SynonymsAdapter.ViewHolder> {
    private final List<SynonymsItem> synonyms;
    private final Context context;

    public SynonymsAdapter(List<SynonymsItem> synonyms, Context context) {
        this.synonyms = synonyms;
        this.context = context;
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
                View exampleView = layoutInflater.inflate(R.layout.recycler_synonyms_example_item, viewGroup, false);
                return new ExampleViewHolder(exampleView);
            case SynonymsItem.TYPE_SYNONYM:
                View synonymView = layoutInflater.inflate(R.layout.recycler_synonyms_synonym_item, viewGroup, false);
                return new SynonymViewHolder(synonymView);
            case SynonymsItem.TYPE_SUBSYNONYM:
                View subsynonymView = layoutInflater.inflate(R.layout.recycler_synonyms_synonym_item, viewGroup, false);
                return new SubsynonymViewHolder(subsynonymView);
            default:
                throw new RuntimeException("Unknown type");
        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {
        SynonymsItem item = synonyms.get(pos);
        viewHolder.bindType(item);
    }
    @Override
    public int getItemCount() {
        return synonyms.size();
    }

    public abstract class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void bindType(SynonymsItem item);
    }

    public class CategoryViewHolder extends ViewHolder{
        @BindView(R.id.lexicalHeader) TextView category;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        @Override
        public void bindType(SynonymsItem item) {
            category.setText(((LexicalEntryModel)item).getLexicalCategory());
        }
    }

    public class ExampleViewHolder extends ViewHolder{
        @BindView(R.id.synonymExample) TextView example;
        ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        @Override
        public void bindType(SynonymsItem item) {
            example.setText(context.getString(R.string.example_quotes,((ExampleModel)item).getText()));
        }
    }

    public class SynonymViewHolder extends ViewHolder{
        @BindView(R.id.synonym) TextView synonym;
        SynonymViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        @Override
        public void bindType(SynonymsItem item) {
            synonym.setText(((SynonymModel)item).getText());
        }
    }

    public class SubsynonymViewHolder extends ViewHolder{
        @BindView(R.id.synonym) TextView synonym;
        SubsynonymViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        @Override
        public void bindType(SynonymsItem item) {
            synonym.setText(((SubSynonymModel)item).getText());
        }
    }
}
