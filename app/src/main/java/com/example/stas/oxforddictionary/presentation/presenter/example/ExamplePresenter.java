package com.example.stas.oxforddictionary.presentation.presenter.example;

import com.example.stas.oxforddictionary.domain.interactor.DefinitonInteractor;
import com.example.stas.oxforddictionary.domain.model.example.ExampleResult;
import com.example.stas.oxforddictionary.presentation.mapper.example.ExampleModelDataMapper;
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler;
import com.example.stas.oxforddictionary.presentation.view.example.ExampleContract;
import com.example.stas.oxforddictionary.presentation.viewmodel.example.ExampleResultModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.example.LexicalEntryModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.example.SentenceModel;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ExamplePresenter implements ExampleContract.Presenter {

    private ExampleContract.View view;
    private final DefinitonInteractor interactor;
    private final CompositeDisposable compositeDisposable;
    private final ErrorHandler errorHandler;
    private final ExampleModelDataMapper exampleModelDataMapper;

    public ExamplePresenter(DefinitonInteractor interactor, CompositeDisposable compositeDisposable,
                            ErrorHandler errorHandler, ExampleModelDataMapper exampleModelDataMapper) {
        this.interactor = interactor;
        this.compositeDisposable = compositeDisposable;
        this.errorHandler = errorHandler;
        this.exampleModelDataMapper = exampleModelDataMapper;
    }

    @Override
    public void getExamples(String word){
        Disposable exampleDisp = interactor.loadExamples(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ExampleResult>() {
                    @Override
                    public void accept(ExampleResult exampleResult){
                        ExampleResultModel result = exampleModelDataMapper.transform(exampleResult);
                        view.showExamples(extractExamples(result));
                    }
                });
        compositeDisposable.add(exampleDisp);
    }

    @Override
    public void attachView(ExampleContract.View view) {
        this.view = view;
        errorHandler.attachView(this.view);
    }

    @Override
    public void detachView() {
        errorHandler.detachView();
        view = null;
        compositeDisposable.dispose();
    }

    private List<String> extractExamples(ExampleResultModel result){
        List<String> examples = new ArrayList<>();
        for (LexicalEntryModel lexicalEntry : result.getLexicalEntries()) {
            for (SentenceModel sentence:lexicalEntry.getSentences()) {
                examples.add(sentence.getText());
            }
        }
        return examples;
    }
}
