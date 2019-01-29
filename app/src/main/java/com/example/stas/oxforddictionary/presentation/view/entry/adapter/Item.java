package com.example.stas.oxforddictionary.presentation.view.entry.adapter;

import java.util.List;

import io.reactivex.annotations.Nullable;

public interface Item {
  
    int TYPE_SENSE = 0;
    int TYPE_SUBSENSE = 1;
    int TYPE_CATEGORY = 2;

    int getType();
    List<String> accept(Visitor visitor);
}
