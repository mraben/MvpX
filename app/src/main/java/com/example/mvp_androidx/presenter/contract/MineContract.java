package com.example.mvp_androidx.presenter.contract;

import com.example.mvp_androidx.app.base.BasePresenter;
import com.example.mvp_androidx.app.base.BaseView;

public interface MineContract {

    interface View extends BaseView {

        void showLoading();
    }

    interface Presenter extends BasePresenter<View> {

    }
}
