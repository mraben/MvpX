package com.example.mvp_androidx.presenter.contract;


import com.example.mvp_androidx.app.base.BasePresenter;
import com.example.mvp_androidx.app.base.BaseView;

public interface MainContract {

    interface View extends BaseView {
        void showText();
        void showAnimation();
    }

    interface  Presenter extends BasePresenter<View> {
        void check(int current,boolean isFormClick);
    }
}
