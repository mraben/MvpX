package com.example.mvp_androidx.app.base;

import com.example.mvp_androidx.api.Api;

import retrofit2.Retrofit;

/**
 * Description: base接口
 */

public abstract  class BaseApi {
    public static final int  CONNECTTIMEOUT = 45;
    public static final int  WRITETIMEOUT = 45;
    public static final int  READTIMEOUT = 45;

    public String getBUrl() {
        return bUrl;
    }

    /*基础url*/
    private String bUrl ="http://server.jeasonlzy.com/";

    /**
     * 设置参数
     *
     * @param retrofit
     * @return
     */
    public abstract Api getObservable(Retrofit retrofit);
}
