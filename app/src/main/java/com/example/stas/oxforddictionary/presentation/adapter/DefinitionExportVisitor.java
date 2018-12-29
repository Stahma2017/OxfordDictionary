package com.example.stas.oxforddictionary.presentation.adapter;

import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SenseModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SubsenseModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.LexicalEntryModel;

import java.util.ArrayList;
import java.util.List;

public class DefinitionExportVisitor implements Visitor {

    public List<String> export(Item item){
        return item.accept(this);
    }

    @Override
    public List<String> visitSense(SenseModel sense) {
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
    public List<String> visitSubsense(SubsenseModel subsense) {
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
    public List<String> visitLexicalEntry(LexicalEntryModel lexicalEntry){
        List<String> categories = new ArrayList<>();
        categories.add(lexicalEntry.getLexicalCategory());
        return categories;
    }
}
