package com.example.stas.oxforddictionary.domain;

import com.example.stas.oxforddictionary.domain.model.definition.DefinitionResult;
import com.example.stas.oxforddictionary.domain.model.example.ExampleResult;
import com.example.stas.oxforddictionary.domain.model.synonym.SynonymResult;


import io.reactivex.Observable;

public interface DefinitionRepository {
    Observable<DefinitionResult> loadDefinition(String word);
    Observable<SynonymResult> loadSynonyms(String word);
    Observable<ExampleResult> loadExamples(String word);
}
