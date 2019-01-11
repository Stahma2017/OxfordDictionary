package com.example.stas.oxforddictionary.di.synonym;

import com.example.stas.oxforddictionary.domain.interactor.DefinitonInteractor;
import com.example.stas.oxforddictionary.presentation.mapper.synonym.SynonymModelDataMapper;
import com.example.stas.oxforddictionary.presentation.presenter.synonym.SynonymPresenter;
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler;
import com.example.stas.oxforddictionary.presentation.view.synonym.SynonymConrtact;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class SynonymModule {
    @Provides
    SynonymConrtact.Presenter provideSynonymPresenter(DefinitonInteractor interactor,
                                                      CompositeDisposable compositeDisposable,
                                                      ErrorHandler errorHandler,
                                                      SynonymModelDataMapper synonymModelDataMapper){
        return new SynonymPresenter(interactor, compositeDisposable, errorHandler, synonymModelDataMapper);
    }
    @Provides
    SynonymModelDataMapper provideSynonyModelDataMapper(){
        return new SynonymModelDataMapper();
    }
}
