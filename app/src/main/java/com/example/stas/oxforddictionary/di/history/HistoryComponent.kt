package com.example.stas.oxforddictionary.di.history

import com.example.stas.oxforddictionary.presentation.presenter.history.HistoryPresenter
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.history.HistoryContract
import com.example.stas.oxforddictionary.presentation.view.history.HistoryFragment
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import io.reactivex.disposables.CompositeDisposable

@Subcomponent(modules = [HistoryModule::class])
interface HistoryComponent{
    fun injectHistoryFragment(historyFragment: HistoryFragment)
}

@Module
class HistoryModule{
    @Provides
    fun provideHistoryPresenter(compositeDisposable: CompositeDisposable,
                                errorHandler: ErrorHandler) : HistoryContract.Presenter {
        return HistoryPresenter(compositeDisposable, errorHandler)
    }


}