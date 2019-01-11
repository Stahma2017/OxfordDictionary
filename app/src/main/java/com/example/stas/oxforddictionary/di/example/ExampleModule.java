package com.example.stas.oxforddictionary.di.example;

import com.example.stas.oxforddictionary.domain.interactor.DefinitonInteractor;
import com.example.stas.oxforddictionary.presentation.mapper.example.ExampleModelDataMapper;
import com.example.stas.oxforddictionary.presentation.presenter.example.ExamplePresenter;
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler;
import com.example.stas.oxforddictionary.presentation.view.example.ExampleContract;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ExampleModule {

    @Provides
    ExampleContract.Presenter provideExamplePresenter(DefinitonInteractor interactor,
                                                      CompositeDisposable compositeDisposable,
                                                      ErrorHandler errorHandler,
                                                      ExampleModelDataMapper exampleModelDataMapper){
        return new ExamplePresenter(interactor, compositeDisposable,
                errorHandler, exampleModelDataMapper);
    }

    @Provides
    ExampleModelDataMapper provideExampleModelDataMapper(){
        return new ExampleModelDataMapper();
    }

}
