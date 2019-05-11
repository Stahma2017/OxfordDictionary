package com.example.stas.oxforddictionary.presentation.presenter.example

import com.example.stas.oxforddictionary.domain.usecase.DefinitonInteractor
import com.example.stas.oxforddictionary.presentation.mapper.example.toViewModel
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler
import com.example.stas.oxforddictionary.presentation.view.example.ExampleContract
import com.example.stas.oxforddictionary.presentation.viewmodel.example.ExampleResultModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.ArrayList


class ExamplePresenter(private val interactor: DefinitonInteractor, private val compositeDisposable: CompositeDisposable,
                       private val errorHandler: ErrorHandler) : ExampleContract.Presenter {

    private var view: ExampleContract.View? = null

    override fun getExamples(word: String) {
        val exampleDisp = interactor.loadExamples(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { exampleResult ->
                    view!!.showExamples(extractExamples(exampleResult.toViewModel()))
                }
        compositeDisposable.add(exampleDisp)
    }

    override fun attachView(view: ExampleContract.View) {
        this.view = view
        errorHandler.attachView(view)
    }

    override fun detachView() {
        errorHandler.detachView()
        view = null
        compositeDisposable.dispose()
    }

    private fun extractExamples(result: ExampleResultModel): List<String?> {
        val examples = ArrayList<String?>()
        for ((_, _, sentences) in result.lexicalEntries) {
            for ((_, _, _, _, _, text) in sentences) {
                examples.add(text)
            }
        }
        return examples
    }
}
