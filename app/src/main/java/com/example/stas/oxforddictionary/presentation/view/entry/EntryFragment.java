package com.example.stas.oxforddictionary.presentation.view.entry;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.stas.oxforddictionary.R;
import com.example.stas.oxforddictionary.presentation.adapter.DefinitionAdapter;
import com.example.stas.oxforddictionary.presentation.adapter.Item;
import com.example.stas.oxforddictionary.presentation.presenter.EntryPresenter;
import com.example.stas.oxforddictionary.presentation.view.main.IMainActivity;
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
    @BindView(R.id.entryProgressBar) ProgressBar progressBar;
    @BindView(R.id.synonymsBtn) Button synonymsBtn;
    @BindView(R.id.examplesBtn) Button examplesBtn;
    private Unbinder unbinder;
    private EntryContract.Presenter presenter;
    private RecyclerView.LayoutManager layoutManager;
    private DefinitionAdapter definitionAdapter;
    private Animation moveUp;
    private IMainActivity mainActivity;

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
                    infoContainer.setVisibility(View.INVISIBLE);
                    progressBar.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(getContext(), "word is missing", Toast.LENGTH_SHORT).show();
                }
            }
        });
        soundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                presenter.getSound(word.getText().toString());
            }
        });

        synonymsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String wordId = word.getText().toString();
            mainActivity.navigateToSynonyms(getContext(), wordId);
            }
        });

        examplesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        synonymsBtn.setVisibility(View.VISIBLE);
        examplesBtn.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
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
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String errorMessage) {
        Snackbar.make(infoContainer, errorMessage, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (IMainActivity) getActivity();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.detachView();
    }
}
