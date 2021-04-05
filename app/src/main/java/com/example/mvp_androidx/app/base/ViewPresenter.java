package com.example.mvp_androidx.app.base;


/**
 * @classname: ViewPresenter
 */
public class ViewPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}
