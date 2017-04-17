package com.snower.paperplane.homepage;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.snower.paperplane.bean.ZhihuDailyNews;
import com.snower.paperplane.network.RetrofitManager;
import com.snower.paperplane.utils.DateFormatter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rainfool on 2017/3/8.
 */
public class ZhihuDailyPresenter implements ZhihuDailyContract.Prensenter {

    private Context context;
    private Gson gson = new Gson();
    private ArrayList<ZhihuDailyNews.Question> list = new ArrayList<ZhihuDailyNews.Question>();
    private ZhihuDailyContract.View view;

    public ZhihuDailyPresenter(Context context , ZhihuDailyContract.View view){
        this.context = context;
        this.view = view;
    }

    @Override
    public void feelLucky() {

    }

    @Override
    public void loadPosts(long date, final boolean clearing) {
        Call<ZhihuDailyNews> call = RetrofitManager.getInstance().getZhihuService().getZhihuHistory(DateFormatter.ZhihuDailyDateFormat(date));
        call.enqueue(new Callback<ZhihuDailyNews>() {
            @Override
            public void onResponse(Call<ZhihuDailyNews> call, Response<ZhihuDailyNews> response) {
                try {
                    ZhihuDailyNews post = gson.fromJson(response.body().toString() , ZhihuDailyNews.class);
                    if (clearing){
                        list.clear();
                    }

                    for (ZhihuDailyNews.Question item : post.getStories()){
                        list.add(item);
                    }
                    view.showResults(list);
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                }
                view.stopLoading();
            }

            @Override
            public void onFailure(Call<ZhihuDailyNews> call, Throwable t) {
                view.stopLoading();
                view.showError();
            }
        });
    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void startReading(int position) {

    }

    @Override
    public void start() {

    }
}
