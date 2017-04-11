package com.snower.paperplane.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snower.paperplane.bean.GuokrHandpickNews;

import java.util.ArrayList;

/**
 * Created by rainfool on 2017/3/22.
 */
public class GuokrFragment extends android.support.v4.app.Fragment implements GuokrContract.View {

    private static volatile GuokrFragment guokrFragment;

    public static GuokrFragment getInstance() {
        if (null == guokrFragment) {
            synchronized (GuokrFragment.class) {
                if (null == guokrFragment) {
                    guokrFragment = new GuokrFragment();
                }
            }
        }
        return guokrFragment;
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
    public void showError() {

    }

    @Override
    public void showResults(ArrayList<GuokrHandpickNews.result> list) {

    }

    @Override
    public void showLoading() {

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
