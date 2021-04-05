package com.example.mvp_androidx.app.base;

/**
 * @author yinhui
 * @classname: PresenterFragment
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2017/4/13 10:04
 */
public abstract class PresenterFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

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
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) mPresenter.detachView();
    }

    /**
     * Presenter注入
     */
    protected abstract void initInject();

    /**
     * 初始化View控件
     */
    protected abstract void initEventAndData();

    protected void initListener() {
    }
}
