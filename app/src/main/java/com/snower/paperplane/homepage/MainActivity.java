package com.snower.paperplane.homepage;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.snower.paperplane.R;
import com.snower.paperplane.bookmarks.BookmarksFragment;
import com.snower.paperplane.bookmarks.BookmarksPresenter;

/**
 * Created by rainfool on 2017/3/9.
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private MainFragment mainFragment;
    private BookmarksFragment bookmarksFragment;

    private NavigationView navigationView;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    public static final String ACTION_BOOKMARKS = "com.marktony.zhihudaily.bookmarks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        if (savedInstanceState != null){
            mainFragment = (MainFragment) getSupportFragmentManager().getFragment(savedInstanceState , "MainFragment");
            bookmarksFragment = (BookmarksFragment) getSupportFragmentManager().getFragment(savedInstanceState , "BookmarksFragment");
        }else {
            mainFragment = MainFragment.getInstance();
            bookmarksFragment = BookmarksFragment.getInstance();
        }

        if (!mainFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(R.id.layout_fragment, mainFragment, "MainFragment").commit();
        }

        if (!bookmarksFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(R.id.layout_fragment , bookmarksFragment , "BookmarksFragment").commit();
        }

        new BookmarksPresenter(this , bookmarksFragment);

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

    private void showMainFragment(){


    }

    private void showBookmarksFragment(){

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        if (mainFragment.isAdded()){
            getSupportFragmentManager().putFragment(outState , "MainFragment" , mainFragment);
        }

        if (bookmarksFragment.isAdded()){
            getSupportFragmentManager().putFragment(outState , "BookmarksFragment" , bookmarksFragment);
        }

    }
}
