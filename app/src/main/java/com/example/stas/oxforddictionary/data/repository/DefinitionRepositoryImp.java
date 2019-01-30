package com.example.stas.oxforddictionary.data.repository;

import com.example.stas.oxforddictionary.data.entity.definition.EntryResponseEntity;
import com.example.stas.oxforddictionary.data.entity.example.ExampleResponseEntity;
import com.example.stas.oxforddictionary.data.entity.synonym.SynonymResponseEntity;
import com.example.stas.oxforddictionary.data.mapper.definition.DefinitionEntityDataMapper;
import com.example.stas.oxforddictionary.data.mapper.definition.DefinitionEntityMapperKt;
import com.example.stas.oxforddictionary.data.mapper.example.ExampleEntityDataMapper;
import com.example.stas.oxforddictionary.data.mapper.example.ExampleEntityMapperKt;
import com.example.stas.oxforddictionary.data.mapper.synonym.SynonymEntityDataMapper;
import com.example.stas.oxforddictionary.data.mapper.synonym.SynonymEntityMapperKt;
import com.example.stas.oxforddictionary.data.network.OxfordApi;
import com.example.stas.oxforddictionary.domain.DefinitionRepository;
import com.example.stas.oxforddictionary.domain.model.definition.DefinitionResult;
import com.example.stas.oxforddictionary.domain.model.example.ExampleResult;
import com.example.stas.oxforddictionary.domain.model.synonym.SynonymResult;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class DefinitionRepositoryImp implements DefinitionRepository {
    private final OxfordApi oxfordApi;
    private final DefinitionEntityDataMapper definitionEntityDataMapper;
    private final SynonymEntityDataMapper synonymEntityDataMapper;
    private final ExampleEntityDataMapper exampleEntityDataMapper;

    public DefinitionRepositoryImp(OxfordApi oxfordApi,
                                   DefinitionEntityDataMapper definitionEntityDataMapper,
                                   SynonymEntityDataMapper synonymEntityDataMapper,
                                   ExampleEntityDataMapper exampleEntityDataMapper) {
        this.oxfordApi = oxfordApi;
        this.definitionEntityDataMapper = definitionEntityDataMapper;
        this.synonymEntityDataMapper = synonymEntityDataMapper;
        this.exampleEntityDataMapper = exampleEntityDataMapper;
    }

    @Override
    public Observable<DefinitionResult> loadDefinition(String word) {
        return oxfordApi.searchForEntry(word)
                .map(new Function<EntryResponseEntity, DefinitionResult>() {
                    @Override
                    public DefinitionResult apply(EntryResponseEntity entryResponseEntity) throws Exception {
                        return DefinitionEntityMapperKt.toModel(entryResponseEntity);
                      //  return  definitionEntityDataMapper.transform(entryResponseEntity);
                    }
                });
    }

    @Override
    public Observable<SynonymResult> loadSynonyms(String word){
        return oxfordApi.searchForSynonyms(word)
                .map(new Function<SynonymResponseEntity, SynonymResult>() {
                    @Override
                    public SynonymResult apply(SynonymResponseEntity synonymResponseEntity) throws Exception {
                       return SynonymEntityMapperKt.toModel(synonymResponseEntity);
                        // return synonymEntityDataMapper.transform(synonymResponseEntity);
                    }
                });
    }

    @Override
    public Observable<ExampleResult> loadExamples(String word){
        return oxfordApi.searchForExamples(word)
                .map(new Function<ExampleResponseEntity, ExampleResult>() {
                    @Override
                    public ExampleResult apply(ExampleResponseEntity exampleResponseEntity) throws Exception {
                        return ExampleEntityMapperKt.toModel(exampleResponseEntity);
                     //   return exampleEntityDataMapper.transform(exampleResponseEntity);
                    }
                });
    }
}
