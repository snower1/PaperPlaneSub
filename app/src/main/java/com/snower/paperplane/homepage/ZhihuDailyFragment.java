package com.snower.paperplane.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snower.paperplane.R;
import com.snower.paperplane.adapter.ZhihuDailyNewsAdaper;
import com.snower.paperplane.bean.ZhihuDailyNews;
import com.snower.paperplane.interfaze.OnRecyclerViewOnClickListener;
import com.snower.paperplane.utils.Tools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by rainfool on 2017/3/8.
 */
public class ZhihuDailyFragment extends android.support.v4.app.Fragment implements ZhihuDailyContract.View{

    private ZhihuDailyNewsAdaper adaper;

    private ZhihuDailyContract.Prensenter presenter;

    private RecyclerView recyclerView;

    private SwipeRefreshLayout swipeRefreshLayout;

    private int mYear = Calendar.getInstance().get(Calendar.YEAR);
    private int mMonth = Calendar.getInstance().get(Calendar.MONTH);
    private int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    public static ZhihuDailyFragment getNewInstance(){
        Tools.printMsg("ZhihuDailyFragment getNewInstance");
        return new ZhihuDailyFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Tools.printMsg("ZhihuDailyFragment onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Tools.printMsg("");
        View view = inflater.inflate(R.layout.fragment_list , container , false);
        initViews(view);
        Calendar temp = Calendar.getInstance();
        temp.clear();
        temp.set(2017, 3, 18);
        presenter.loadPosts(temp.getTimeInMillis(), true);

        return view;
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
        Tools.printMsg("");
        if (null == adaper){
            Tools.printMsg("null == adaper");
            adaper = new ZhihuDailyNewsAdaper(getContext() , list);
            adaper.setItemClickListener(new OnRecyclerViewOnClickListener() {
                @Override
                public void OnItemClick(View v, int position) {
                    presenter.startReading(position);
                }
            });
            recyclerView.setAdapter(adaper);
        }else {
            Tools.printMsg("adaper.notifyDataSetChanged()");
            adaper.notifyDataSetChanged();
        }
    }

    @Override
    public void showPickDialog() {

    }

    @Override
    public void setPresenter(ZhihuDailyContract.Prensenter presenter) {
        Tools.printMsg("");
        if (null != presenter){
            this.presenter = presenter;
        }

    }

    @Override
    public void initViews(View view) {
        Tools.printMsg("");
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refreshLayout);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}