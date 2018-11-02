package com.example.stas.oxforddictionary.presentation.presenter;

import com.example.stas.oxforddictionary.adapter.Item;
import com.example.stas.oxforddictionary.domain.DictionaryInteractor;
import com.example.stas.oxforddictionary.domain.Entity.LexicalEntryEntity;
import com.example.stas.oxforddictionary.domain.Entity.PronunciationEntity;
import com.example.stas.oxforddictionary.domain.Entity.SenseEntity;
import com.example.stas.oxforddictionary.presentation.view.base.BaseErrorHandler;
import com.example.stas.oxforddictionary.presentation.view.base.ErrorHandler;
import com.example.stas.oxforddictionary.presentation.view.entry.EntryContract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class EntryPresenter implements EntryContract.Presenter {
    private EntryContract.View view;
    private DictionaryInteractor interactor = new DictionaryInteractor();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ErrorHandler errorHandler = new BaseErrorHandler();

    public EntryPresenter(EntryContract.View view) {
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
              .subscribe(new Consumer<LexicalEntryEntity>() {
                  @Override
                  public void accept(LexicalEntryEntity lexicalEntry) throws Exception {
                      view.showDefinition(extractDefinitions(lexicalEntry), extractTitle(lexicalEntry));
                  }
              }, new Consumer<Throwable>() {
                  @Override
                  public void accept(Throwable throwable) throws Exception {
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
                .subscribe(new Consumer<LexicalEntryEntity>() {
                    @Override
                    public void accept(LexicalEntryEntity lexicalEntryEntity) throws Exception {
                        view.playSound(lexicalEntryEntity.getPronunciationEntities().get(0).getAudioFile());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        errorHandler.proceed(throwable);
                    }
                });
        compositeDisposable.add(soundDisp);
    }

    private List<Item> extractDefinitions(LexicalEntryEntity lexicalEntry){
        List<Item> definitions = new ArrayList<>();
        for(SenseEntity sense : lexicalEntry.getEntries().get(0).getSense()){
            if(!sense.getDefinitions().isEmpty()){
                definitions.add(sense);
                definitions.addAll(sense.getSubsens());
            }
        }
        return definitions;
    }
    private List<String> extractTitle(LexicalEntryEntity lexicalEntry){
        List<String> titleSet = new ArrayList<>();
        titleSet.add(lexicalEntry.getText());
        for (PronunciationEntity pronunciation: lexicalEntry.getPronunciationEntities()){
            if (pronunciation.getAudioFile() != null){
                titleSet.add("[" + pronunciation.getPhoneticSpelling()+ "]");
            }
        }
        return titleSet;
    }
}
