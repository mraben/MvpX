package com.example.mvp_androidx.app.base;

/**
 * @classname: PresenterActivity
 * @Description: TODO(这里用一句话描述这个类的作用)
 */
public abstract class PresenterActivity<T extends BasePresenter> extends BaseActivity implements BaseView {

    protected T mPresenter;

    @Override
    protected void init() {
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
        initEventAndData();
        initListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }

    protected abstract void initInject();

    protected abstract void initEventAndData();

    protected void initListener() {
    }
}