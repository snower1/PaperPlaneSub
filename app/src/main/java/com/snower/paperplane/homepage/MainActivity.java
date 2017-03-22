package com.snower.paperplane.homepage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.snower.paperplane.R;
import com.snower.paperplane.bookmarks.BookmarksFragment;

/**
 * Created by rainfool on 2017/3/9.
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private MainFragment mainFragment;
    private BookmarksFragment bookmarksFragment;

    private NavigationView navigationView;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    private void initView(){
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this , drawerLayout ,toolbar
            ,R.string.navigation_drawer_open , R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
