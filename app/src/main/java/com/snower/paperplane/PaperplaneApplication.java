package com.snower.paperplane;

import android.app.Application;
import android.util.Log;

/**
 * Created by rainfool on 2017/3/8.
 */
public class PaperplaneApplication extends Application {

    @Override
    public void onCreate() {
        Log.d("hexie" , "application onCreate()");
        super.onCreate();

//        RetrofitManager retrofitManager = new RetrofitManager();
//
//        Call<JSONObject> call = retrofitManager.getGithubService().getVersion("snower1");
//        call.enqueue(new Callback<JSONObject>() {
//            @Override
//            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
//               String json =  response.body().toString();
//                Log.d("rainfool",json);
//            }
//
//            @Override
//            public void onFailure(Call<JSONObject> call, Throwable t) {
//
//            }
//        });

    }
}
