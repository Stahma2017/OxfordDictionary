package com.example.stas.oxforddictionary.presentation.view.entry.adapter;

import com.example.stas.oxforddictionary.presentation.viewmodel.definition.LexicalEntryModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SenseModel;
import com.example.stas.oxforddictionary.presentation.viewmodel.definition.SubsenseModel;

import java.util.List;

public interface Visitor {
    public List<String> visitSense(SenseModel sense);
    public List<String> visitSubsense(SubsenseModel subsense);
    public List<String> visitLexicalEntry(LexicalEntryModel lexicalEntry);
}
