package com.example.stas.oxforddictionary.domain;

import com.example.stas.oxforddictionary.domain.model.definition.LexicalEntry;

import io.reactivex.Observable;

public interface DefinitionRepository {
    Observable<LexicalEntry> loadDefinition(String word);
}
