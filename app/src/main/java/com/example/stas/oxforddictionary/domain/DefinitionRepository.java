package com.example.stas.oxforddictionary.domain;

import com.example.stas.oxforddictionary.domain.model.definition.Result;

import io.reactivex.Observable;

public interface DefinitionRepository {
    Observable<Result> loadDefinition(String word);
}
