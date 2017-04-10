package com.snower.paperplane.homepage;

/**
 * Created by rainfool on 2017/3/22.
 */
public class MainFragment extends android.support.v4.app.Fragment {

    private static volatile MainFragment mainFragment;

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
}
