package com.example.stas.oxforddictionary.presentation.view.example;

import com.example.stas.oxforddictionary.presentation.view.base.CanShowError;

import java.util.List;

public interface ExampleContract {
    interface View extends CanShowError{
        void showExamples(List<String> examples);
    }

    interface Presenter{
        void attachView(ExampleContract.View view);
        void getExamples(String word);
        void detachView();
    }


}
