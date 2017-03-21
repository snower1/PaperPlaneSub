package com.snower.paperplane.network;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rainfool on 2017/3/8.
 */
public interface GithubService {

    @GET("users/{user}/repos")
    Call<JSONObject> getVersion(@Path("user") String user);
}
