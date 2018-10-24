package com.example.stas.oxforddictionary.adapter;

import com.example.stas.oxforddictionary.domain.Entity.LexicalEntryEntity;
import com.example.stas.oxforddictionary.domain.Entity.PronunciationEntity;
import com.example.stas.oxforddictionary.domain.Entity.SenseEntity;
import com.example.stas.oxforddictionary.domain.Entity.SubsenseEntity;

import java.util.ArrayList;
import java.util.List;

public class DefinitionExportVisitor implements Visitor {

    public List<String> export(Item item){
        return item.accept(this);
    }

    @Override
    public List<String> visitSense(SenseEntity sense) {
        StringBuilder totalDefinition = new StringBuilder();
        StringBuilder totalExample = new StringBuilder();
        List<String> definitions = new ArrayList<>();

        for (int i = 0; i<sense.getDefinitions().size(); i++) {
            totalDefinition.append(sense.getDefinitions().get(i)).append("\n");
            definitions.add(totalDefinition.toString());
            if (!sense.getExamples().isEmpty()){
                totalExample.append(sense.getExamples().get(i).getText()).append("\n");
                definitions.add(totalExample.toString());
            }
        }
        return definitions;
    }

    @Override
    public List<String> visitSubsense(SubsenseEntity subsense) {
        StringBuilder totalDefinition = new StringBuilder();
        StringBuilder totalExample = new StringBuilder();
        List<String> definitions = new ArrayList<>();

        for(int i = 0; i<subsense.getDefinitions().size(); i++){
            totalDefinition.append(subsense.getDefinitions().get(i)).append("\n");
            definitions.add(totalDefinition.toString());
            if (!subsense.getExamples().isEmpty()){
                totalExample.append(subsense.getExamples().get(i).getText()).append("\n");
                definitions.add(totalExample.toString());
            }
        }
        return definitions;
    }

    @Override
    public List<String> visitLexicalEntry(LexicalEntryEntity lexicalEntryEntity) {
        List<String> headerDetils = new ArrayList<>();
        headerDetils.add(lexicalEntryEntity.getText());
        for (PronunciationEntity pronunciation: lexicalEntryEntity.getPronunciationEntities()){
            if (pronunciation.getAudioFile() != null){
                headerDetils.add(pronunciation.getPhoneticSpelling());
                headerDetils.add(pronunciation.getAudioFile());
            }
        }
        return headerDetils;
    }
}
