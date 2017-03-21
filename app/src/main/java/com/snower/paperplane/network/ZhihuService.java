package com.snower.paperplane.network;

import com.snower.paperplane.bean.ZhihuDailyNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rainfool on 2017/3/9.
 */
public interface ZhihuService {

    @GET("{date}")
    Call<ZhihuDailyNews> getZhihuHistory(@Path("date") String date);
}
