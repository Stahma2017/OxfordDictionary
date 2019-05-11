package com.example.stas.oxforddictionary.di.synonym

import com.example.stas.oxforddictionary.domain.usecase.DefinitonInteractor
import com.example.stas.oxforddictionary.presentation.presenter.synonym.SynonymPresenter
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.synonym.SynonymActivity
import com.example.stas.oxforddictionary.presentation.view.synonym.SynonymConrtact
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import io.reactivex.disposables.CompositeDisposable

@Subcomponent(modules = [SysnonymModule::class])
interface SynonymComponent{
    fun injectSynonymActivity(synonymActivity: SynonymActivity)
}

@Module
class SysnonymModule{
    @Provides
    fun provideSynonymPresenter(interactor: DefinitonInteractor,
                                compositeDisposable: CompositeDisposable,
                                errorHandler: ErrorHandler): SynonymConrtact.Presenter{
      return SynonymPresenter(interactor, compositeDisposable, errorHandler)
    }

}