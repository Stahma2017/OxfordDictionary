package com.example.stas.oxforddictionary.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stas.oxforddictionary.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class EntryFragment extends Fragment implements EntryContract.View {

    @BindView(R.id.wordEntryET) EditText wordEntry;
    @BindView(R.id.definitionOutputTW) TextView output;
    @BindView(R.id.searchSubmitBtn) Button searchBtn;
    private Unbinder unbinder;
    EntryContract.Presenter presenter;


    public EntryFragment() {

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entry, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter = new EntryPresenter(this);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wordEntry.length() > 0){
                    presenter.getDefinition(wordEntry.getText().toString());
                }else {
                    Toast.makeText(getContext(), "word is missing", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }

    @Override
    public void showDefinition(String definitioni) {
        output.setText(definitioni);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.detachView();
    }
}
