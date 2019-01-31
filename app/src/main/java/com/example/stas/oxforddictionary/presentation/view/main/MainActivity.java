package com.example.stas.oxforddictionary.presentation.view.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.stas.oxforddictionary.App;
import com.example.stas.oxforddictionary.R;
import com.example.stas.oxforddictionary.presentation.view.base.BaseActivity;
import com.example.stas.oxforddictionary.presentation.view.entry.EntryFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainContract.View, IMainActivity {
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.hamburgerBtn)
    ImageButton hamburgerBtn;
    private TextView allWordsCount;
    @Inject
    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((App)getApplication()).createMaincomponent().injectMainActivity(this);
      // ApplicationComponentKt.getMyApplication(this).createMaincomponent().injectMainActivity(this);
     /*   App.getInstance().getMainComponent().injectMainActivity(this);*/
        presenter.attachView(this);
        init();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                //implement swaping fragments here
                return true;
            }
        });
    }

    @Override
    public void inflateFragment(String fragmentTag, String word) {
        /*if (fragmentTag.equals(getString(R.string.fragment_synonym))){
            SynonymFragment synonymFragment = new SynonymFragment();
            doFragmentTransaction(synonymFragment, fragmentTag, true, word);
        }*/
    }

    private void init() {
        EntryFragment entryFragment = new EntryFragment();
        doFragmentTransaction(entryFragment, getString(R.string.fragment_entry), false, "");
        allWordsCount = navigationView.getHeaderView(0).findViewById(R.id.allWordsCount);
    }

    private void doFragmentTransaction(Fragment fragment, String tag, boolean addToBackStack, String message) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!message.equals("")) {
            Bundle bundle = new Bundle();
            bundle.putString(getString(R.string.intent_message), message);
            fragment.setArguments(bundle);
        }
        transaction.replace(R.id.content_frame, fragment, tag);
        if (addToBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.commit();
    }

    @Override
    public void navigateToSynonyms(Context context, String wordId) {
        this.navigator.navigateToSynonyms(context, wordId);
    }

    @Override
    public void navigateToExamples(Context context, String wordId) {
        this.navigator.navigateToExamples(context, wordId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettachView();
    }

    public void openDrawer(View view) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
}
