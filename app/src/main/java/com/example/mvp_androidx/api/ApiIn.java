package com.example.mvp_androidx.api;


import com.example.mvp_androidx.app.base.BaseApi;

import retrofit2.Retrofit;

/**
 * Description:
 */

public class ApiIn extends BaseApi {

    @Override
    public Api getObservable(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }
}
