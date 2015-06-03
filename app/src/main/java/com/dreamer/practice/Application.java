package com.dreamer.practice;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * Created by dreamer on 2015/5/13.
 */
public class Application extends android.app.Application {
    private OkHttpClient okHttpClient;
    @Override
    public void onCreate() {
        super.onCreate();
        okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(30, TimeUnit.SECONDS);
    }

    public OkHttpClient getOkHttpClient(){
        return okHttpClient;
    }
}
