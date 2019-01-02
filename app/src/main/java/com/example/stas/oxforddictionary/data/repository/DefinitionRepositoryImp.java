package com.example.stas.oxforddictionary.data.repository;

import com.example.stas.oxforddictionary.data.entity.definition.EntryResponseEntity;
import com.example.stas.oxforddictionary.data.entity.synonym.SynonymResponseEntity;
import com.example.stas.oxforddictionary.data.mapper.definition.DefinitionEntityDataMapper;
import com.example.stas.oxforddictionary.data.mapper.synonym.SynonymEntityDataMapper;
import com.example.stas.oxforddictionary.data.network.ApiClient;
import com.example.stas.oxforddictionary.data.network.OxfordApi;
import com.example.stas.oxforddictionary.domain.DefinitionRepository;
import com.example.stas.oxforddictionary.domain.model.definition.DefinitionResult;
import com.example.stas.oxforddictionary.domain.model.synonym.SynonymResult;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class DefinitionRepositoryImp implements DefinitionRepository {
    private final OxfordApi oxfordApi = ApiClient.getRetrofit().create(OxfordApi.class);
    private DefinitionEntityDataMapper definitionEntityDataMapper = new DefinitionEntityDataMapper();
    private SynonymEntityDataMapper synonymEntityDataMapper = new SynonymEntityDataMapper();

    @Override
    public Observable<DefinitionResult> loadDefinition(String word) {
        return oxfordApi.searchForEntry(word)
                .map(new Function<EntryResponseEntity, DefinitionResult>() {
                    @Override
                    public DefinitionResult apply(EntryResponseEntity entryResponseEntity) throws Exception {
                        return  definitionEntityDataMapper.transform(entryResponseEntity);
                    }
                });
    }

    @Override
    public Observable<SynonymResult> loadSynonyms(String word){
        return oxfordApi.searchForSynonyms(word)
                .map(new Function<SynonymResponseEntity, SynonymResult>() {
                    @Override
                    public SynonymResult apply(SynonymResponseEntity synonymResponseEntity) throws Exception {
                        return synonymEntityDataMapper.transform(synonymResponseEntity);
                    }
                });
    }
}
