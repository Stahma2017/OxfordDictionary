package com.example.stas.oxforddictionary.data.mapper.synonym;

import com.example.stas.oxforddictionary.data.entity.synonym.EntryEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryEntityMapper {
    SenseEntityMapper senseEntityMapper = new SenseEntityMapper();

   private Entry mapEntry(EntryEntity from){
       Entry entry = new Entry();
       entry.setHomographNumber(from.getHomographNumber());
       entry.setSenses(senseEntityMapper.mapSenses(from.getSenses()));
       return entry;
   }

    List<Entry> mapEntries(List<EntryEntity> fromList){
       List<Entry> entries = new ArrayList<>();
        for (EntryEntity entry: fromList) {
            entries.add(mapEntry(entry));
        }
        return entries;
    }
}
