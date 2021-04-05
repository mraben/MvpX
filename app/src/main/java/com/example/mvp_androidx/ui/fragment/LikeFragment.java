package com.example.mvp_androidx.ui.fragment;

import com.example.mvp_androidx.R;
import com.example.mvp_androidx.app.base.PresenterFragment;
import com.example.mvp_androidx.presenter.LikePresenter;
import com.example.mvp_androidx.presenter.contract.LikeContract;

/**
 * Description:
 */

public class LikeFragment extends PresenterFragment<LikePresenter> implements LikeContract.View {


    @Override
    protected void initInject() {

    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.likefragment;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String msg) {

    }
}
