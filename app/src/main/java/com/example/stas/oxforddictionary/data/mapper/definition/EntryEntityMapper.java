package com.example.stas.oxforddictionary.data.mapper.definition;

import com.example.stas.oxforddictionary.data.entity.definition.EntryEntity;
import com.example.stas.oxforddictionary.domain.model.definition.Entry;

import java.util.ArrayList;
import java.util.List;

class EntryEntityMapper {

    private SenseEntityMapper senseEntityMapper = new SenseEntityMapper();

    private Entry mapEntry(EntryEntity from){
        Entry entry = new Entry();
        entry.setEtymologies(from.getEtymologies());
        entry.setHomographNumber(from.getHomographNumber());
        entry.setSens(senseEntityMapper.mapSenses(from.getSenses()));
        return entry;
    }
    List<Entry> mapEntries(List<EntryEntity> fromList){
        List<Entry> entries = new ArrayList<>();
        for (EntryEntity entry:fromList) {
            entries.add(mapEntry(entry));
        }
        return entries;
    }
}
