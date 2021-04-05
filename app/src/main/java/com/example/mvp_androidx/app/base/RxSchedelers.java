package com.example.mvp_androidx.app.base;

import com.example.mvp_androidx.utils.LogUtil;

import rx.Subscriber;

/**
 * Description: 自定义Subscriber
 */

public class RxSchedelers<T> extends Subscriber<T> {

    private String TAG = "rxschedelers";

    @Override
    public void onCompleted() {
        LogUtil.e(TAG, "请求完成");
    }

    @Override
    public void onError(Throwable e) {
        LogUtil.e(TAG, "请求异常" + e.getMessage());
    }

    @Override
    public void onNext(T t) {

    }

}
