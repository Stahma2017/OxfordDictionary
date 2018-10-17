package com.example.stas.oxforddictionary.domain;

import com.example.stas.oxforddictionary.data.model.EntryResponse;
import com.example.stas.oxforddictionary.data.model.LexicalEntry;
import com.example.stas.oxforddictionary.network.ApiClient;
import com.example.stas.oxforddictionary.network.OxfordApi;

import io.reactivex.Observable;
import io.reactivex.functions.Function;


public class DictionaryInteractor {
    private final OxfordApi oxfordApi = ApiClient.getRetrofit().create(OxfordApi.class);

    public Observable<LexicalEntry> loadDefinition(String word){
        //todo get rid of en parameter
        return oxfordApi.searchForEntry("en", word)
                .map(new Function<EntryResponse, LexicalEntry>() {
                    @Override
                    public LexicalEntry apply(EntryResponse entryResponse) throws Exception {
                        return entryResponse.getResults().get(0).getLexicalEntries().get(0);
                    }
                });

    }
}
