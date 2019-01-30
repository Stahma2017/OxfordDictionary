package com.example.stas.oxforddictionary.presentation.presenter.entry;

import com.example.stas.oxforddictionary.domain.model.definition.DefinitionResult;
import com.example.stas.oxforddictionary.presentation.mapper.definition.DefinitionModelMapperKt;
import com.example.stas.oxforddictionary.presentation.view.entry.adapter.Item;
import com.example.stas.oxforddictionary.domain.interactor.DefinitonInteractor;
import com.example.stas.oxforddictionary.presentation.mapper.definition.DefinitionModelDataMapper;
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler;
import com.example.stas.oxforddictionary.presentation.view.entry.EntryContract;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.LexicalEntryModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.PronunciationModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.ResultModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SenseModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SubsenseModel;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class EntryPresenter implements EntryContract.Presenter {
    private EntryContract.View view;
    private final DefinitonInteractor interactor;
    private final CompositeDisposable compositeDisposable;
    private final ErrorHandler errorHandler;
    private final DefinitionModelDataMapper definitionModelDataMapper;

    public EntryPresenter(DefinitonInteractor interactor, CompositeDisposable compositeDisposable,
                          ErrorHandler errorHandler, DefinitionModelDataMapper definitionModelDataMapper) {
        this.interactor = interactor;
        this.compositeDisposable = compositeDisposable;
        this.errorHandler = errorHandler;
        this.definitionModelDataMapper = definitionModelDataMapper;
    }

    @Override
    public void attachView(EntryContract.View view) {
        this.view = view;
        errorHandler.attachView(this.view);
    }

    @Override
    public void detachView(){
        errorHandler.detachView();
        view = null;
        compositeDisposable.dispose();
    }

    @Override
    public void getDefinition(String word) {
        Disposable definitionDisp = interactor.loadDefinition(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DefinitionResult>() {
                    @Override
                    public void accept(DefinitionResult result){
                        ResultModel resultModel = DefinitionModelMapperKt.toViewModel(result);
                        view.showDefinition(extractDefinitions(resultModel), extractTitle(resultModel));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        view.hideProgressBar();
                        errorHandler.proceed(throwable);
                    }
                });
        compositeDisposable.add(definitionDisp);
    }

    @Override
    public void getSound(String word) {
        Disposable soundDisp = interactor.loadDefinition(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DefinitionResult>() {
                    @Override
                    public void accept(DefinitionResult result){
                        view.playSound(result.getLexicalEntries().get(0).getPronunciations().get(0).getAudioFile());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        errorHandler.proceed(throwable);
                    }
                });
        compositeDisposable.add(soundDisp);
    }

    private List<Item> extractDefinitions(ResultModel result){
        List<Item> definitions = new ArrayList<>();
        for (LexicalEntryModel lexicalEntry : result.getLexicalEntries()) {
            definitions.add(lexicalEntry);
            for(SenseModel sense : lexicalEntry.getEntries().get(0).getSenses()){
                if(!sense.getDefinitions().isEmpty()){
                    definitions.add(sense);
                    for (SubsenseModel subsense :sense.getSubsenses()) {
                        if(!subsense.getDefinitions().isEmpty()){
                            definitions.add(subsense);
                        }
                    }
                }
            }
        }
        return definitions;
    }
    private List<String> extractTitle(ResultModel result){
        LexicalEntryModel lexicalEntry = result.getLexicalEntries().get(0);
        List<String> titleSet = new ArrayList<>();
        titleSet.add(lexicalEntry.getText());
        for (PronunciationModel pronunciation: lexicalEntry.getPronunciations()){
            if (pronunciation.getAudioFile() != null){
                titleSet.add("[" + pronunciation.getPhoneticSpelling()+ "]");
            }
        }
        return titleSet;
    }
}
