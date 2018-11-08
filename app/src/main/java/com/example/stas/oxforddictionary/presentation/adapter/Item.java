package com.example.stas.oxforddictionary.presentation.adapter;

import java.util.List;

public interface Item {
    static final int TYPE_SENSE = 0;
    static final int TYPE_SUBSENSE = 1;

    int getType();
    public List<String> accept(Visitor visitor);
}
