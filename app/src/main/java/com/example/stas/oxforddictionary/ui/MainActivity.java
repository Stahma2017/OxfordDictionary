package com.example.stas.oxforddictionary.ui;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import com.example.stas.oxforddictionary.R;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements MainContract.View{


    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.hamburgerBtn)ImageButton hamburgerBtn;

    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        EntryFragment entryFragment = new EntryFragment();
        fragmentTransaction.add(R.id.content_frame, entryFragment);
        fragmentTransaction.commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                //todo implement swaping fragments
                return true;
            }
        });
    }

    @Override
    public void showWord(String word) {

    }

    public void openDrawer(View view) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
}
