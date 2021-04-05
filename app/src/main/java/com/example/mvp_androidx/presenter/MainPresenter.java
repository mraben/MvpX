package com.example.mvp_androidx.presenter;

import com.example.mvp_androidx.app.base.ViewPresenter;
import com.example.mvp_androidx.inter.IViewListener;
import com.example.mvp_androidx.model.bean.MainBean;
import com.example.mvp_androidx.model.modelmpl.MainModelmpl;
import com.example.mvp_androidx.presenter.contract.MainContract;


/**
 * @classname: MainPresenter
 * @Description: TODO(这里用一句话描述这个类的作用)
 */
public class MainPresenter extends ViewPresenter<MainContract.View> implements MainContract.Presenter {

    private MainModelmpl mainModelmpl = null;

    public MainPresenter() {
        this.mainModelmpl = new MainModelmpl();
    }

    @Override
    public void check(int current, boolean isFormClick) {
        if (null == mView || null == mainModelmpl) {
            return;
        }
        mainModelmpl.checkData(current, new IViewListener<MainBean>() {
            @Override
            public void onSuccess(MainBean mainBean) {
                if (mainBean.getAge() < 10) {
                    mView.showAnimation();
                }
                if (null != mainBean.getName() && !mainBean.getName().isEmpty()) {
                    mView.showText();
                }
            }

            @Override
            public void onError(int code, String error) {
                mView.showError(error);
            }
        });

    }


}