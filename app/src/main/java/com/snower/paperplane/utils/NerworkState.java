package com.snower.paperplane.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by rainfool on 2017/3/9.
 */
public class NerworkState {

    public static boolean networkConnected(Context context){
        NetworkInfo info = getActiveNetworkInfo(context);
        if (info != null){
            return info.isAvailable();
        }
        return false;
    }

    public static boolean wifiConnect(Context context){
        NetworkInfo info = getActiveNetworkInfo(context);
        if (info != null){
            if (info.getType() == ConnectivityManager.TYPE_WIFI){
                return info.isAvailable();
            }
        }
        return false;
    }

    public static boolean mobileDataConnect(Context context){
        NetworkInfo info = getActiveNetworkInfo(context);
        if (info != null){
            if (info.getType() == ConnectivityManager.TYPE_MOBILE){
                return info.isAvailable();
            }
        }
        return false;
    }

    public static NetworkInfo getActiveNetworkInfo(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info;
    }
}
