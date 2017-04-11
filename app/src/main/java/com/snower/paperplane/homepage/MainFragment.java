package com.snower.paperplane.homepage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.snower.paperplane.R;
import com.snower.paperplane.adapter.MainPagerAdapter;

import java.util.Random;

/**
 * Created by rainfool on 2017/3/22.
 */
public class MainFragment extends android.support.v4.app.Fragment {

    private static volatile MainFragment mainFragment;

    private ZhihuDailyFragment zhihuDailyFragment;
    private DoubanMomentFragment doubanMomentFragment;
    private GuokrFragment guokrFragment;

    private ZhihuDailyPresenter zhihuDailyPresenter;
    private DoubanMomentPresenter doubanMomentPresenter;
    private GuokrPresenter guokrPresenter;

    private MainPagerAdapter mainPagerAdapter;
    private TabLayout tabLayout;

    private Context context;

    public static MainFragment getInstance(){
        if (null == mainFragment){
            synchronized (MainFragment.class){
                if (null == mainFragment){
                    mainFragment = new MainFragment();
                }
            }
        }
        return mainFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        if (null != savedInstanceState){
            zhihuDailyFragment = (ZhihuDailyFragment) getChildFragmentManager().getFragment(savedInstanceState , "zhihuDailyFragment");
            doubanMomentFragment = (DoubanMomentFragment) getChildFragmentManager().getFragment(savedInstanceState , "doubanMomentFragment");
            guokrFragment = (GuokrFragment) getChildFragmentManager().getFragment(savedInstanceState , "guokrFragment");
        }else {
            zhihuDailyFragment = ZhihuDailyFragment.getNewInstance();
            doubanMomentFragment = DoubanMomentFragment.getInstance();
            guokrFragment = GuokrFragment.getInstance();
        }
        zhihuDailyPresenter = new ZhihuDailyPresenter(context , zhihuDailyFragment);
        doubanMomentPresenter = new DoubanMomentPresenter(context , doubanMomentFragment);
        guokrPresenter = new GuokrPresenter(context , guokrFragment);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main , container , false);
        initView(view);

        setHasOptionsMenu(true);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
                if (tab.getPosition() == 1){
                    fab.hide();
                }else {
                    fab.show();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;


    }

    private void initView(View view){
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(3);
        mainPagerAdapter = new MainPagerAdapter(getChildFragmentManager() , context , zhihuDailyFragment , doubanMomentFragment , guokrFragment);

        viewPager.setAdapter(mainPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main , menu);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentManager.putFragment(outState , "zhihuDailyFragment" , zhihuDailyFragment);
        fragmentManager.putFragment(outState , "doubanMomentFragment"  , doubanMomentFragment);
        fragmentManager.putFragment(outState , "guokrFragment" , guokrFragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_feel_lucky){
            feelLucky();
        }
        return true;
    }

    private void feelLucky(){
        Random random = new Random();
        int type = random.nextInt(3);
        switch (type){
            case 0:
                zhihuDailyPresenter.feelLucky();
                break;
            case 1:
                guokrPresenter.feelLucky();
                break;
            case 2:
                doubanMomentPresenter.feelLucky();
                break;
        }
    }

    public MainPagerAdapter getAdapter(){
        return mainPagerAdapter;
    }


}
