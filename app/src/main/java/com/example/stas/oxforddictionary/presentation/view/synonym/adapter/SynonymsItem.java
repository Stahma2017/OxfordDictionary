package com.example.stas.oxforddictionary.presentation.view.synonym.adapter;

public interface SynonymsItem {
    int TYPE_CATEGORY = 0;
    int TYPE_EXAMPLE = 1;
    int TYPE_SYNONYM = 2;
    int TYPE_SUBSYNONYM = 3;

    int getType();
}
