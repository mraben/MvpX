package com.example.mvp_androidx.ui.fragment;

import com.example.mvp_androidx.R;
import com.example.mvp_androidx.app.base.PresenterFragment;
import com.example.mvp_androidx.presenter.HomePresenter;
import com.example.mvp_androidx.presenter.contract.HomeContract;

/**
 * Description:
 */

public class HomeFragment extends PresenterFragment<HomePresenter> implements HomeContract.View {


    @Override
    protected void initInject() {

    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.homefragment;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String msg) {

    }
}
