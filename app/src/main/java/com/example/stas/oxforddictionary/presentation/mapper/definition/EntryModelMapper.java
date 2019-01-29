package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.Entry;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.EntryModel;

import java.util.ArrayList;
import java.util.List;

class EntryModelMapper {
    private SenseModelMapper senseModelMapper = new SenseModelMapper();

    private EntryModel mapEntry(Entry from){
        return new EntryModel(
                from.getEtymologies(),
                from.getHomographNumber(),
                senseModelMapper.mapSenses(from.getSenses())
        );
    }
    List<EntryModel> mapEntries(List<Entry> fromList){
        List<EntryModel> entries = new ArrayList<>();
        if (fromList != null){
            for (Entry entry:fromList) {
                entries.add(mapEntry(entry));
            }
        }
        return entries;
    }
}
