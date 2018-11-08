package com.example.stas.oxforddictionary.presentation.adapter;

import java.util.List;

public interface Item {
    static final int TYPE_HEADER = 0;
    static final int TYPE_SENSE = 1;
    static final int TYPE_SUBSENSE = 2;

    int getType();
    public List<String> accept(Visitor visitor);
}
