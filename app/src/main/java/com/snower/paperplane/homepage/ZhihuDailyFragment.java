package com.snower.paperplane.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snower.paperplane.adapter.ZhihuDailyNewsAdaper;
import com.snower.paperplane.bean.ZhihuDailyNews;
import com.snower.paperplane.interfaze.OnRecyclerViewOnClickListener;

import java.util.ArrayList;

/**
 * Created by rainfool on 2017/3/8.
 */
public class ZhihuDailyFragment extends android.support.v4.app.Fragment implements ZhihuDailyContract.View{

    private ZhihuDailyNewsAdaper adaper;

    private ZhihuDailyPresenter presenter;

    private RecyclerView recyclerView;
    public static ZhihuDailyFragment getNewInstance(){
        return new ZhihuDailyFragment();
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
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showResults(ArrayList<ZhihuDailyNews.Question> list) {
        if (null == adaper){
            adaper = new ZhihuDailyNewsAdaper(getContext() , list);
            adaper.setItemClickListener(new OnRecyclerViewOnClickListener() {
                @Override
                public void OnItemClick(View v, int position) {
                    presenter.startReading(position);
                }
            });
            recyclerView.setAdapter(adaper);
        }else {
            adaper.notifyDataSetChanged();
        }
    }

    @Override
    public void showPickDialog() {

    }

    @Override
    public void setPresenter(ZhihuDailyContract.Prensenter presenter) {

    }

    @Override
    public void initViews(View view) {

    }
}