package com.example.stas.oxforddictionary.presentation.view.synonym;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.stas.oxforddictionary.App;
import com.example.stas.oxforddictionary.R;
import com.example.stas.oxforddictionary.presentation.view.base.BaseActivity;
import com.example.stas.oxforddictionary.presentation.view.synonym.adapter.SynonymsAdapter;
import com.example.stas.oxforddictionary.presentation.view.synonym.adapter.SynonymsItem;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SynonymActivity extends BaseActivity implements SynonymConrtact.View {

    private static final String SYNONYM_WORD_ID = "SYNONYM_WORD_ID";
    @Inject
    SynonymConrtact.Presenter presenter;
    @BindView(R.id.synonymsWord) TextView word;
    @BindView(R.id.synonymsList) RecyclerView synonymList;

    public static Intent getCallingIntent(Context context, String wordId){
        Intent callingIntent = new Intent(context, SynonymActivity.class);
        callingIntent.putExtra(SYNONYM_WORD_ID, wordId);
        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synonym);
        App.getInstance().getSynonymComponent().injectSynonymActivity(this);
        ButterKnife.bind(this);
        presenter.attachView(this);
        Intent intent = getIntent();
        String wordId = intent.getStringExtra(SYNONYM_WORD_ID);
        word.setText(wordId);
        presenter.getSynonyms(wordId);
    }

    @Override
    public void showSynonyms(List<SynonymsItem> synonyms) {
       RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        SynonymsAdapter synonymsAdapter = new SynonymsAdapter(synonyms);
        synonymList.setLayoutManager(layoutManager);
        synonymList.setAdapter(synonymsAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showError(String errorMessage) {

    }

    public void CloseSynonymList(View view) {
        finish();
    }
}
