package com.example.stas.oxforddictionary.domain.interactor;

import com.example.stas.oxforddictionary.data.repository.DictionaryRepositoryImp;
import com.example.stas.oxforddictionary.domain.DictionaryRepository;
import com.example.stas.oxforddictionary.domain.model.definition.LexicalEntry;
import io.reactivex.Observable;



public class DictionaryInteractor {
    private DictionaryRepository repository = new DictionaryRepositoryImp();

    public Observable<LexicalEntry> loadDefinition(String word){
        return repository.loadDefinition(word);
    }
}
