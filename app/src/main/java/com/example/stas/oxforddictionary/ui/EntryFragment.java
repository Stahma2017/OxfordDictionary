package com.example.stas.oxforddictionary.ui;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stas.oxforddictionary.R;
import com.example.stas.oxforddictionary.adapter.DefinitionAdapter;
import com.example.stas.oxforddictionary.adapter.Item;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class EntryFragment extends Fragment implements EntryContract.View {

    @BindView(R.id.wordEntryET) EditText wordEntry;
    @BindView(R.id.searchSubmitBtn) Button searchBtn;
    @BindView(R.id.definition_recycler_view) RecyclerView definitionRecyclerView;
    @BindView(R.id.wordInfoContainer) LinearLayout infoContainer;
    @BindView(R.id.titleText) TextView word;
    @BindView(R.id.titleTranscription) TextView transcription;
    @BindView(R.id.titleSound) ImageButton soundBtn;
    private Unbinder unbinder;
    private EntryContract.Presenter presenter;
    private RecyclerView.LayoutManager layoutManager;
    private DefinitionAdapter definitionAdapter;

    Animation moveUp;


    public EntryFragment() {

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entry, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter = new EntryPresenter(this);

        moveUp = AnimationUtils.loadAnimation(getActivity(),
                R.anim.move_up);

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

        soundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getSound(word.getText().toString());
            }
        });

        layoutManager = new LinearLayoutManager(getContext());
        definitionAdapter = new DefinitionAdapter();
        definitionRecyclerView.setLayoutManager(layoutManager);
        definitionRecyclerView.setAdapter(definitionAdapter);

        return view;
    }

    @Override
    public void showDefinition(List<Item> definitions, List<String> titleSet) {
        word.setText(titleSet.get(0));
        transcription.setText(titleSet.get(1));
        infoContainer.setVisibility(View.VISIBLE);
        infoContainer.startAnimation(moveUp);
        definitionAdapter.setItems(definitions);
        definitionAdapter.notifyDataSetChanged();
    }

    @Override
    public void playSound(String soundURL) {
         MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(soundURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            //todo handle error
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

    @Override
    public void showToast(String word){
        Toast.makeText(getContext(), word, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.detachView();
    }
}
