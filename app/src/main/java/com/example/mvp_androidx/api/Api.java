package com.example.mvp_androidx.api;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Description: api接口
 */

public interface Api {

    /**
     * post请求（key,value形式）
     */
    @FormUrlEncoded
    @POST("/api/demo/getoist")
    Observable<ResponseBody> login(@Field("param1") String param);

    /**
     * post请求（map形式）
     */
    @FormUrlEncoded
    @POST("/api/demo/getPost")
    Observable<ResponseBody> getMap(@Body HashMap<String, String> h);

    /**
     * get无参请求
     */
    @GET("/api/demo/get")
    Observable<ResponseBody> getempty();

    /**
     * get接口参数拼接
     */
    @GET("/api/demo/getPost/" + "{siteId}/{lotteryId}")
    Observable<ResponseBody> getString(@Path("siteId") String siteId, @Path("lotteryId") String lotteryId);

}

