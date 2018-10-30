package com.example.stas.oxforddictionary.ui;

import com.example.stas.oxforddictionary.adapter.Item;
import com.example.stas.oxforddictionary.domain.DictionaryInteractor;
import com.example.stas.oxforddictionary.domain.Entity.LexicalEntryEntity;
import com.example.stas.oxforddictionary.domain.Entity.PronunciationEntity;
import com.example.stas.oxforddictionary.domain.Entity.SenseEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

class EntryPresenter implements EntryContract.Presenter {
    private EntryContract.View view;
    private DictionaryInteractor interactor = new DictionaryInteractor();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    EntryPresenter(EntryContract.View view) {
        this.view = view;
    }

   @Override
   public void detachView(){
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
                         });
                      compositeDisposable.add(definitionDisp);
    }

    private List<Item> extractDefinitions(LexicalEntryEntity lexicalEntry){
        List<Item> definitions = new ArrayList<>();
        for(SenseEntity sense : lexicalEntry.getEntries().get(0).getSense()){
            definitions.add(sense);
            definitions.addAll(sense.getSubsens());
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
