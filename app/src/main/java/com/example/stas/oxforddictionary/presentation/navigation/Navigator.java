package com.example.stas.oxforddictionary.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import com.example.stas.oxforddictionary.presentation.view.example.ExampleActivity;
import com.example.stas.oxforddictionary.presentation.view.synonym.SynonymActivity;

public class Navigator {

    public void navigateToSynonyms(Context context, String wordId){
        if (context != null){
            Intent intentToLaunh = SynonymActivity.getCallingIntent(context, wordId);
            context.startActivity(intentToLaunh);
        }
    }

    public void navigateToExamples(Context context, String wordId){
        if (context != null){
            Intent intentToLaunh = ExampleActivity.getCallingIntent(context, wordId);
            context.startActivity(intentToLaunh);
        }
    }
}
