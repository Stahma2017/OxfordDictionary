package com.example.stas.oxforddictionary.presentation.presenter;

import com.example.stas.oxforddictionary.domain.interactor.DefinitonInteractor;
import com.example.stas.oxforddictionary.presentation.view.base.BaseErrorHandler;
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler;
import com.example.stas.oxforddictionary.presentation.view.synonym.SynonymConrtact;

import io.reactivex.disposables.CompositeDisposable;

public class SynonymPresenter implements SynonymConrtact.Presenter {

    private SynonymConrtact.View view;
    private DefinitonInteractor interactor = new DefinitonInteractor();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ErrorHandler errorHandler = new BaseErrorHandler();

    public SynonymPresenter(SynonymConrtact.View view) {
        this.view = view;
        errorHandler.attachView(this.view);
    }

    @Override
    public void detachView() {
        errorHandler.detachView();
        view = null;
        compositeDisposable.dispose();
    }
}
