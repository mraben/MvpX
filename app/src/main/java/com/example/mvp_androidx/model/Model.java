package com.example.mvp_androidx.model;



import com.example.mvp_androidx.api.Api;
import com.example.mvp_androidx.api.ApiIn;
import com.example.mvp_androidx.app.base.BaseRetrofit;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Description: 处理请求
 */
public class Model {

    private static Model model;

    private Api api = BaseRetrofit.getInstance().getObservable(new ApiIn());

    /**
     * @return 返回Model实例
     */
    public static Model getInstance() {
        if (model == null) {
            synchronized (Model.class) {
                if (model == null) {
                    model = new Model();
                }
            }
        }
        return model;
    }

    public Api getApi() {
        return api;
    }

    /**
     * 测试请求
     */
    public Observable<ResponseBody> apiBase(Observable<ResponseBody> obser) {
        return obser.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}