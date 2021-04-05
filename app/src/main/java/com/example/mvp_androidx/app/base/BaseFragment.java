package com.example.mvp_androidx.app.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @classname: BaseFragment
 * @Description: TODO(这里用一句话描述这个类的作用)
 */
public abstract class BaseFragment extends Fragment {

    protected BaseActivity mActivity;
    protected View mContentView;
    private Unbinder bind;

    protected abstract @LayoutRes
    int getLayoutResId();

    /**
     * 初始化View控件
     */
    protected abstract void init();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResId(), null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContentView = view;
        bind = ButterKnife.bind(this, mContentView);
        init();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mContentView = null;
        bind.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
