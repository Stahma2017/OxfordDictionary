package com.example.stas.oxforddictionary.data.repository;

import com.example.stas.oxforddictionary.data.entity.definition.EntryResponseEntity;
import com.example.stas.oxforddictionary.data.mapper.definition.DefinitionEntityDataMapper;
import com.example.stas.oxforddictionary.data.network.ApiClient;
import com.example.stas.oxforddictionary.data.network.OxfordApi;
import com.example.stas.oxforddictionary.domain.DefinitionRepository;
import com.example.stas.oxforddictionary.domain.model.definition.LexicalEntry;
import com.example.stas.oxforddictionary.domain.model.definition.Result;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class DefinitionRepositoryImp implements DefinitionRepository {
    private final OxfordApi oxfordApi = ApiClient.getRetrofit().create(OxfordApi.class);
    private DefinitionEntityDataMapper definitionEntityDataMapper = new DefinitionEntityDataMapper();

    @Override
    public Observable<Result> loadDefinition(String word) {
        //todo get rid of en parameter
        return oxfordApi.searchForEntry("en", word)
                .map(new Function<EntryResponseEntity, Result>() {
                    @Override
                    public Result apply(EntryResponseEntity entryResponseEntity) throws Exception {
                        return  definitionEntityDataMapper.transform(entryResponseEntity);
                    }
                });
    }
}
