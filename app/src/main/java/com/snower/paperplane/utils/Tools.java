package com.snower.paperplane.utils;

import android.util.Log;

/**
 * Created by hexie on 2017/5/22.
 */

public class Tools {
    private static String TAG = "MyPaperPlane";

    public static void printMsg(String msg){
        if ( null != msg){
            String clazzName = Thread.currentThread().getStackTrace()[3].getClassName();
            String functionName = Thread.currentThread().getStackTrace()[3].getMethodName();
            System.out.println(clazzName);
            Log.d(TAG , clazzName + " " + functionName + " : " + msg);
        }
    }
}
