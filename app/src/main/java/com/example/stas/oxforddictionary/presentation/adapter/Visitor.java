package com.example.stas.oxforddictionary.presentation.adapter;

import com.example.stas.oxforddictionary.domain.model.definition.Sense;
import com.example.stas.oxforddictionary.domain.model.definition.Subsense;

import java.util.List;

public interface Visitor {
    public List<String> visitSense(Sense sense);
    public List<String> visitSubsense(Subsense subsense);
}
