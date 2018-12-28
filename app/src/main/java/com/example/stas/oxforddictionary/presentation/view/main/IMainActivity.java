package com.example.stas.oxforddictionary.presentation.view.main;

import android.content.Context;

public interface IMainActivity {
    void inflateFragment(String fragmentTag, String word);
    void navigateToSynonyms(Context context, String wordId);
}
