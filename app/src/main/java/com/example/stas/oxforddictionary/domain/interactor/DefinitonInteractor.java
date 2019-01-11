package com.example.stas.oxforddictionary.domain.interactor;

import com.example.stas.oxforddictionary.domain.DefinitionRepository;
import com.example.stas.oxforddictionary.domain.model.definition.DefinitionResult;
import com.example.stas.oxforddictionary.domain.model.example.ExampleResult;
import com.example.stas.oxforddictionary.domain.model.synonym.SynonymResult;

import io.reactivex.Observable;

public class DefinitonInteractor {
    private final DefinitionRepository repository;

    public DefinitonInteractor(DefinitionRepository repository) {
        this.repository = repository;
    }

    public Observable<DefinitionResult> loadDefinition(String word){
        return repository.loadDefinition(word);
    }

    public Observable<SynonymResult> loadSynonyms(String word){
        return repository.loadSynonyms(word);
    }

    public Observable<ExampleResult> loadExamples(String word){
        return repository.loadExamples(word);
    }

}
