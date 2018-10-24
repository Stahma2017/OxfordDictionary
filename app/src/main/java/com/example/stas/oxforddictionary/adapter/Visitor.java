package com.example.stas.oxforddictionary.adapter;

import com.example.stas.oxforddictionary.domain.Entity.LexicalEntryEntity;
import com.example.stas.oxforddictionary.domain.Entity.SenseEntity;
import com.example.stas.oxforddictionary.domain.Entity.SubsenseEntity;

import java.util.List;

public interface Visitor {
    public List<String> visitSense(SenseEntity sense);
    public List<String> visitSubsense(SubsenseEntity subsense);
    public List<String> visitLexicalEntry(LexicalEntryEntity lexicalEntryEntity);
}
