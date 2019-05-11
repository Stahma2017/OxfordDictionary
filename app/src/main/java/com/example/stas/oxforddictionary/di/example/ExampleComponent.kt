package com.example.stas.oxforddictionary.di.example

import com.example.stas.oxforddictionary.domain.usecase.DefinitonInteractor
import com.example.stas.oxforddictionary.presentation.presenter.example.ExamplePresenter
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.example.ExampleActivity
import com.example.stas.oxforddictionary.presentation.view.example.ExampleContract
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import io.reactivex.disposables.CompositeDisposable

@Subcomponent(modules =[ExampleModule::class])
interface ExampleComponent {
    fun injectExampleActivity(exampleActivity: ExampleActivity)
}

@Module
class ExampleModule {
    @Provides
    fun provideExamplePresenter(interactor: DefinitonInteractor,
                                compositeDisposable: CompositeDisposable,
                                errorHandler: ErrorHandler
    ): ExampleContract.Presenter  =
        ExamplePresenter(interactor, compositeDisposable,
                errorHandler)
}

