package com.example.stas.oxforddictionary.di.entry;


import com.example.stas.oxforddictionary.domain.interactor.DefinitonInteractor;
import com.example.stas.oxforddictionary.presentation.mapper.definition.DefinitionModelDataMapper;
import com.example.stas.oxforddictionary.presentation.presenter.entry.EntryPresenter;
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler;
import com.example.stas.oxforddictionary.presentation.view.entry.EntryContract;
import com.example.stas.oxforddictionary.presentation.view.entry.adapter.DefinitionAdapter;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class EntryModule {
    @Provides
    DefinitionAdapter provideDefinitionAdapter(){
        return new DefinitionAdapter();
    }
    @Provides
    EntryContract.Presenter provideEntryPresenter(DefinitonInteractor interactor, CompositeDisposable compositeDisposable,
                                                  ErrorHandler errorHandler, DefinitionModelDataMapper definitionModelDataMapper){
        return new EntryPresenter(interactor, compositeDisposable, errorHandler, definitionModelDataMapper);
    }

    @Provides
    DefinitionModelDataMapper provideDefinitionMapper(){
        return new DefinitionModelDataMapper();
    }

}
