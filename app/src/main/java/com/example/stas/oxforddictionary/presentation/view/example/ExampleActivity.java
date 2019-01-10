package com.example.stas.oxforddictionary.presentation.view.example;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.stas.oxforddictionary.R;
import com.example.stas.oxforddictionary.presentation.presenter.example.ExamplePresenter;
import com.example.stas.oxforddictionary.presentation.view.example.adapter.ExampleAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExampleActivity extends AppCompatActivity implements ExampleContract.View {

    private static final String EXAMPLE_WORD_ID = "EXAMPLE_WORD_ID";
    private ExampleContract.Presenter presenter;
    @BindView(R.id.exampleWord) TextView word;
    @BindView(R.id.exampleList) RecyclerView exampleList;

    public static Intent getCallingIntent(Context context, String wordId){
        Intent callingIntent = new Intent(context, ExampleActivity.class);
        callingIntent.putExtra(EXAMPLE_WORD_ID, wordId);
        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        ButterKnife.bind(this);
        presenter = new ExamplePresenter(this);
        Intent intent = getIntent();
        String wordId = intent.getStringExtra(EXAMPLE_WORD_ID);
        word.setText(wordId);
        presenter.getExamples(wordId);
    }

    @Override
    public void showExamples(List<String> examples) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ExampleAdapter exampleAdapter = new ExampleAdapter(examples);
        exampleList.setLayoutManager(layoutManager);
        exampleList.setAdapter(exampleAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showError(String errorMessage) {

    }

    public void CloseExampleList(View view) {
        finish();
    }
}
