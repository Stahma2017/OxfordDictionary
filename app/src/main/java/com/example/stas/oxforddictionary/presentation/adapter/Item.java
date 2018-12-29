package com.example.stas.oxforddictionary.presentation.adapter;

import java.util.List;

public interface Item {
    //todo find out static final field in interface
    static final int TYPE_SENSE = 0;
    static final int TYPE_SUBSENSE = 1;
    static final int TYPE_HEADER = 2;

    int getType();
    public List<String> accept(Visitor visitor);
}
