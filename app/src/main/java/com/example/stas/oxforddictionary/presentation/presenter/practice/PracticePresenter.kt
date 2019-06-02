package com.example.stas.oxforddictionary.presentation.presenter.practice

import com.example.stas.oxforddictionary.data.database.model.SavedWordModel
import com.example.stas.oxforddictionary.data.database.model.WeekStatisticModel
import com.example.stas.oxforddictionary.domain.usecase.definition.FetchSavedWordsUseCase
import com.example.stas.oxforddictionary.domain.usecase.definition.UpdateSavedWordsUseCase
import com.example.stas.oxforddictionary.domain.usecase.statistic.UpdateWeekStatisticUseCase
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.practice.PracticeContract
import com.example.stas.oxforddictionary.presentation.view.practice.PracticeFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PracticePresenter(private val errorHandler: ErrorHandler,
                        private val compositeDisposable: CompositeDisposable,
                        private val fetchSavedWordsUseCase: FetchSavedWordsUseCase,
                        private val updateSavedWordsUseCase: UpdateSavedWordsUseCase,
                        private val updateWeekStatisticUseCase: UpdateWeekStatisticUseCase) : PracticeContract.Presenter {

    private var view: PracticeContract.View? = null

    override fun attachView(view: PracticeContract.View) {
        this.view = view
        errorHandler.attachView(view)
    }

    override fun detachView() {
        errorHandler.detachView()
        view = null
        compositeDisposable.dispose()
    }

    override fun getQuiz() {
        val quizDisp = fetchSavedWordsUseCase.fetchSavedWord()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    startQuiz(it)
                }, { error -> errorHandler.proceed(error) })
        compositeDisposable.add(quizDisp)
    }

    override fun updateWords(words: List<SavedWordModel>) {
        val updateWordsDisp = updateSavedWordsUseCase.updateWords(words)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.showError("Done")
                }, { throwable ->
                    errorHandler.proceed(throwable)
                })
        compositeDisposable.add(updateWordsDisp)
    }

    override fun updateStatistic(result: Int, day: Int) {
       val updateStatistic = updateWeekStatisticUseCase.updateStatistic(listOf(WeekStatisticModel(day, result)))
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe({

               }, { throwable ->
                   errorHandler.proceed(throwable)
               })
        compositeDisposable.add(updateStatistic)
    }

    private fun isCountEnough(words: List<SavedWordModel>) =
            words.size >= PracticeFragment.SAVED_WORDS_AMOUNT_ALLOWED


    private fun startQuiz(words: List<SavedWordModel>) {
        if (isCountEnough(words)) {
            view?.showQuiz(words)
        }
    }


}