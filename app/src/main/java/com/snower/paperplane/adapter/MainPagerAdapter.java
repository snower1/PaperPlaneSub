package com.snower.paperplane.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.snower.paperplane.R;
import com.snower.paperplane.homepage.DoubanMomentFragment;
import com.snower.paperplane.homepage.GuokrFragment;
import com.snower.paperplane.homepage.ZhihuDailyFragment;
import com.snower.paperplane.utils.Tools;

/**
 * Created by hx on 2017-4-11.
 */

public class MainPagerAdapter extends FragmentPagerAdapter{

    private String[] titles;
    private Context context;

    private ZhihuDailyFragment zhihuDailyFragment;
    private DoubanMomentFragment doubanMomentFragment;
    private GuokrFragment guokrFragment;

    public ZhihuDailyFragment getZhihuDailyFragment() {
        return zhihuDailyFragment;
    }


    public DoubanMomentFragment getDoubanMomentFragment() {
        return doubanMomentFragment;
    }

    public GuokrFragment getGuokrFragment() {
        return guokrFragment;
    }


    public MainPagerAdapter(FragmentManager fm , Context context , ZhihuDailyFragment zhihuDailyFragment , DoubanMomentFragment doubanMomentFragment , GuokrFragment guokrFragment) {
        super(fm);
        this.context = context;

        this.zhihuDailyFragment = zhihuDailyFragment;
        this.doubanMomentFragment = doubanMomentFragment;
        this.guokrFragment = guokrFragment;

        this.titles = new String[]{context.getResources().getString(R.string.zhihu_daily),
                context.getResources().getString(R.string.guokr_handpick),
                context.getResources().getString(R.string.douban_moment)};
    }

    @Override
    public Fragment getItem(int position) {
        Tools.printMsg("MainPagerAdapter getItem");
        Tools.printMsg("position= " + position);
        switch (position){
            case 0:
                return zhihuDailyFragment;
            case 1:
                return guokrFragment;
            case 2:
                return doubanMomentFragment;
        }
        return zhihuDailyFragment;
    }



    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
