package com.example.stas.oxforddictionary.di.save

import com.example.stas.oxforddictionary.domain.DefinitionRepository
import com.example.stas.oxforddictionary.domain.usecase.DefinitonInteractor
import com.example.stas.oxforddictionary.domain.usecase.definition.FetchSavedWordsUseCase
import com.example.stas.oxforddictionary.presentation.presenter.save.SavePresenter
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.save.SaveContract
import com.example.stas.oxforddictionary.presentation.view.save.SaveFragment
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import io.reactivex.disposables.CompositeDisposable

@Subcomponent(modules = [SaveModule::class])
interface SaveComponent{
    fun injectSaveFragment(saveFragment: SaveFragment)
}

@Module
class SaveModule{
    @Provides
    fun provideSavePresenter(interactor: DefinitonInteractor, compositeDisposable: CompositeDisposable,
                             errorHandler: ErrorHandler, fetchSavedWordsUseCase: FetchSavedWordsUseCase): SaveContract.Presenter{
        return SavePresenter(errorHandler, compositeDisposable, fetchSavedWordsUseCase)
    }

    @Provides
    fun provideFetchSavedWordsUseCase(definitionRepository: DefinitionRepository): FetchSavedWordsUseCase{
        return FetchSavedWordsUseCase(definitionRepository)
    }
}