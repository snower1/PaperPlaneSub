package com.snower.paperplane.network;

import com.snower.paperplane.BuildConfig;
import com.snower.paperplane.utils.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rainfool on 2017/3/8.
 */
public class RetrofitManager {

//    private static final String BASE_URL = "https://api.github.com/";

    Retrofit retrofit;

    GithubService githubService;

    private static volatile RetrofitManager retrofitManager;

    public  static RetrofitManager getInstance(){
        if (null == retrofitManager) {
            synchronized (RetrofitManager.class) {
                if (null == retrofitManager) {
                    retrofitManager = new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }

    public RetrofitManager() {
        OkHttpClient httpClient = new OkHttpClient();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
        }
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.ZHIHU_HISTORY)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }

    public GithubService getGithubService() {
        return retrofit.create(GithubService.class);
    }

    public ZhihuService getZhihuService(){
        return retrofit.create(ZhihuService.class);
    }
}
