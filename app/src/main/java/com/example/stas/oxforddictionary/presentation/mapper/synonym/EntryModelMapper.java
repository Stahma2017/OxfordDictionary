package com.example.stas.oxforddictionary.presentation.mapper.synonym;

import com.example.stas.oxforddictionary.domain.model.synonym.Entry;
import com.example.stas.oxforddictionary.presentation.viewmodel.synonym.EntryModel;

import java.util.ArrayList;
import java.util.List;

class EntryModelMapper {

    SenseModelMapper senseModelMapper = new SenseModelMapper();
    private EntryModel mapEntry(Entry from){
        return new EntryModel(
                from.getHomographNumber(),
                senseModelMapper.mapSenses(from.getSenses())
        );
    }

    List<EntryModel> mapEntries(List<Entry> fromList){
        List<EntryModel> entries = new ArrayList<>();
        for (Entry entry: fromList) {
            entries.add(mapEntry(entry));
        }
        return entries;
    }
}
