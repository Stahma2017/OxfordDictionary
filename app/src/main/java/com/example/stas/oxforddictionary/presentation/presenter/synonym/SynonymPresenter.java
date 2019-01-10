package com.example.stas.oxforddictionary.presentation.presenter.synonym;

import com.example.stas.oxforddictionary.domain.interactor.DefinitonInteractor;
import com.example.stas.oxforddictionary.domain.model.synonym.SynonymResult;
import com.example.stas.oxforddictionary.presentation.mapper.synonym.SynonymModelDataMapper;
import com.example.stas.oxforddictionary.presentation.view.base.BaseErrorHandler;
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler;
import com.example.stas.oxforddictionary.presentation.view.synonym.SynonymConrtact;
import com.example.stas.oxforddictionary.presentation.view.synonym.adapter.SynonymsItem;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.LexicalEntryModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.ResultModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.SenseModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.SubsenseModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SynonymPresenter implements SynonymConrtact.Presenter {

    private SynonymConrtact.View view;
    private DefinitonInteractor interactor = new DefinitonInteractor();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ErrorHandler errorHandler = new BaseErrorHandler();
    private SynonymModelDataMapper synonymModelDataMapper = new SynonymModelDataMapper();

    public SynonymPresenter(SynonymConrtact.View view) {
        this.view = view;
        errorHandler.attachView(this.view);
    }
    @Override
    public void getSynonyms(String word){
     Disposable synonymsDisp = interactor.loadSynonyms(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SynonymResult>() {
                    @Override
                    public void accept(SynonymResult synonymResult) throws Exception {
                        ResultModel resultModel = synonymModelDataMapper.transform(synonymResult);
                        view.showSynonyms(extractSynonyms(resultModel));
                    }
                });
     compositeDisposable.add(synonymsDisp);
    }

    @Override
    public void detachView() {
        errorHandler.detachView();
        view = null;
        compositeDisposable.dispose();
    }

    private List<SynonymsItem> extractSynonyms(ResultModel result){
        List<SynonymsItem> synonyms = new ArrayList<>();
        for (LexicalEntryModel lexicalEntry: result.getLexicalEntries()) {
            synonyms.add(lexicalEntry);
            for (SenseModel sense : lexicalEntry.getEntries().get(0).getSenses()){
                synonyms.addAll(sense.getExamples());
                synonyms.addAll(sense.getSynonyms());
                for(SubsenseModel subsense: sense.getSubsenses()){
                    synonyms.addAll(subsense.getSynonyms());
                }

            }
        }
        return synonyms;
    }
}
