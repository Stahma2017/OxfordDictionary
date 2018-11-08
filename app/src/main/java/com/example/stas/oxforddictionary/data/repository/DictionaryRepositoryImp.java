package com.example.stas.oxforddictionary.data.repository;

import com.example.stas.oxforddictionary.data.entity.definition.EntryResponseEntity;
import com.example.stas.oxforddictionary.data.mapper.LexicalEntryEntityMapper;
import com.example.stas.oxforddictionary.data.network.ApiClient;
import com.example.stas.oxforddictionary.data.network.OxfordApi;
import com.example.stas.oxforddictionary.domain.DictionaryRepository;
import com.example.stas.oxforddictionary.domain.model.definition.LexicalEntry;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class DictionaryRepositoryImp implements DictionaryRepository {
    private final OxfordApi oxfordApi = ApiClient.getRetrofit().create(OxfordApi.class);
    private LexicalEntryEntityMapper entityDataMapper = new LexicalEntryEntityMapper();

    @Override
    public Observable<LexicalEntry> loadDefinition(String word) {
        //todo get rid of en parameter
        return oxfordApi.searchForEntry("en", word)
                .map(new Function<EntryResponseEntity, LexicalEntry>() {
                    @Override
                    public LexicalEntry apply(EntryResponseEntity entryResponseEntity) throws Exception {
                        return  entityDataMapper.mapLexicalEntry(entryResponseEntity);
                    }
                });
    }
}
