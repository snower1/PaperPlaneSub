package com.snower.paperplane.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snower.paperplane.bean.DoubanMomentNews;

import java.util.ArrayList;

/**
 * Created by rainfool on 2017/3/21.
 */
public class DoubanMomentFragment extends android.support.v4.app.Fragment implements DoubanMomentContract.view {

    private static volatile DoubanMomentFragment doubanMomentFragment;

    public static DoubanMomentFragment getInstance(){
        if (null == doubanMomentFragment) {
            synchronized (DoubanMomentFragment.class) {
                if (null == doubanMomentFragment) {
                    doubanMomentFragment = new DoubanMomentFragment();
                }
            }
        }
        return doubanMomentFragment;
    }

    @Override
    public void showResult(ArrayList<DoubanMomentNews.posts> list) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void showLoadingError() {

    }

    @Override
    public void startLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void setPresenter(DoubanMomentContract.Presenter presenter) {

    }

    @Override
    public void initViews(View view) {

    }
}
