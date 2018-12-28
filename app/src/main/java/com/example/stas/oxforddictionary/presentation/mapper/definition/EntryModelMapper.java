package com.example.stas.oxforddictionary.presentation.mapper.definition;

import com.example.stas.oxforddictionary.domain.model.definition.Entry;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.EntryModel;

import java.util.ArrayList;
import java.util.List;

class EntryModelMapper {
    private SenseModelMapper senseModelMapper = new SenseModelMapper();

    private EntryModel mapEntry(Entry from){
        EntryModel entry = new EntryModel();
        entry.setEtymologies(from.getEtymologies());
        entry.setHomographNumber(from.getHomographNumber());
        entry.setSens(senseModelMapper.mapSenses(from.getSense()));
        return entry;
    }
    List<EntryModel> mapEntries(List<Entry> fromList){
        List<EntryModel> entries = new ArrayList<>();
        for (Entry entry:fromList) {
            entries.add(mapEntry(entry));
        }
        return entries;
    }
}
