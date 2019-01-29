package com.example.stas.oxforddictionary.data.mapper.synonym;

import com.example.stas.oxforddictionary.data.entity.synonym.EntryEntity;
import com.example.stas.oxforddictionary.domain.model.synonym.Entry;

import java.util.ArrayList;
import java.util.List;

class EntryEntityMapper {
    SenseEntityMapper senseEntityMapper = new SenseEntityMapper();

   private Entry mapEntry(EntryEntity from){
       return new Entry(
               from.getHomographNumber(),
               senseEntityMapper.mapSenses(from.getSenses())
       );
   }

    List<Entry> mapEntries(List<EntryEntity> fromList){
       List<Entry> entries = new ArrayList<>();
       if (fromList != null){
           for (EntryEntity entry: fromList) {
               entries.add(mapEntry(entry));
           }
       }

        return entries;
    }
}
