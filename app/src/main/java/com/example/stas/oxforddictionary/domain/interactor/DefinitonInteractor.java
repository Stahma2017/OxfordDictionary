package com.example.stas.oxforddictionary.domain.interactor;

import com.example.stas.oxforddictionary.data.repository.DefinitionRepositoryImp;
import com.example.stas.oxforddictionary.domain.DefinitionRepository;
import com.example.stas.oxforddictionary.domain.model.definition.LexicalEntry;
import io.reactivex.Observable;



public class DefinitonInteractor {
    private DefinitionRepository repository = new DefinitionRepositoryImp();

    public Observable<LexicalEntry> loadDefinition(String word){
        return repository.loadDefinition(word);
    }
}
