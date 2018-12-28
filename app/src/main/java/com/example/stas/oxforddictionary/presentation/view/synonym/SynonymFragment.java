package com.example.stas.oxforddictionary.presentation.view.synonym;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stas.oxforddictionary.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SynonymFragment extends Fragment {


    private Unbinder unbinder;
    private String incomingWord = "";

    @BindView(R.id.request)
    TextView request;


    public SynonymFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null){
            incomingWord = bundle.getString(getString(R.string.intent_message));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_synonym, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void setWord(){
        if(!incomingWord.equals("")){
            request.setText(incomingWord);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
