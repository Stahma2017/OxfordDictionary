package com.example.stas.oxforddictionary.presentation.view.synonym;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.stas.oxforddictionary.R;
import com.example.stas.oxforddictionary.presentation.presenter.SynonymPresenter;
import com.example.stas.oxforddictionary.presentation.view.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SynonymActivity extends BaseActivity implements SynonymConrtact.View {

    private static final String PARAM_WORD_ID = "PARAM_WORD_ID";
    private SynonymConrtact.Presenter presenter;

    @BindView(R.id.synonymsWord) TextView word;
    @BindView(R.id.synonymsList) RecyclerView synonymList;

    public static Intent getCallingIntent(Context context, String wordId){
        Intent callingIntent = new Intent(context, SynonymActivity.class);
        callingIntent.putExtra(PARAM_WORD_ID, wordId);
        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synonym);
        ButterKnife.bind(this);
        presenter = new SynonymPresenter(this);
        Intent intent = getIntent();
        String wordId = intent.getStringExtra(PARAM_WORD_ID);
        word.setText(wordId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showError(String errorMessage) {

    }
}
