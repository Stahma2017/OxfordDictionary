package com.example.stas.oxforddictionary.data.mapper;

import com.example.stas.oxforddictionary.data.model.Entry;
import com.example.stas.oxforddictionary.domain.Entity.EntryEntity;

import java.util.ArrayList;
import java.util.List;

public class EntryMapper {

    private SenseMapper senseMapper;

    public EntryEntity mapEntry(Entry from){
        EntryEntity entryEntity = new EntryEntity();
        entryEntity.setEtymologies(from.getEtymologies());
        entryEntity.setHomographNumber(from.getHomographNumber());
        entryEntity.setSens(senseMapper.mapSenses(from.getSenses()));
        return entryEntity;
    }
    public List<EntryEntity> mapEntries(List<Entry> fromList){
        List<EntryEntity> entries = new ArrayList<>();
        for (Entry entry:fromList) {
            entries.add(mapEntry(entry));
        }
        return entries;
    }
}
