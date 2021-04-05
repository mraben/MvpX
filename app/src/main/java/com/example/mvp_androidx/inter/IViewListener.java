package com.example.mvp_androidx.inter;

/**
 * Description:
 */
public interface IViewListener<T> {
    void onSuccess(T t);
    void onError(int code,String error);
}
