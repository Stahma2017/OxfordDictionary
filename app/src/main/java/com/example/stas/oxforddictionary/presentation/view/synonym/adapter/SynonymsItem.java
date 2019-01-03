package com.example.stas.oxforddictionary.presentation.view.synonym.adapter;

public interface SynonymsItem {
    static final int TYPE_CATEGORY = 0;
    static final int TYPE_EXAMPLE = 1;
    static final int TYPE_SYNONYM = 2;
    static final int TYPE_SUBSYNONYM = 3;

    int getType();
}
