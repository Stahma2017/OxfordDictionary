package com.example.stas.oxforddictionary.ui;

import com.example.stas.oxforddictionary.domain.DictionaryInteractor;
import com.example.stas.oxforddictionary.data.model.LexicalEntry;

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
              .subscribe(new Consumer<LexicalEntry>() {
                             @Override
                             public void accept(LexicalEntry lexicalEntry) throws Exception {
                                 view.showDefinition(lexicalEntry.getEntries().get(0).getSenses());

                             }
                         });
                      compositeDisposable.add(definitionDisp);
    }



    /*List<String> definitions = new ArrayList<>();
                        for (Sense s: response.body().getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getSenses()) {
        definitions.addAll(s.getDefinitions());
    }
    String soundURL = response.body().getResults().get(0).getLexicalEntries().get(0).getPronunciationEntities().get(0).getAudioFile();
    String word = response.body().getResults().get(0).getWord();
                        view.showDefinition(definitions, word, soundURL);*/
}
