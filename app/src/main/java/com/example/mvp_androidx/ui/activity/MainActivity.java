package com.example.mvp_androidx.ui.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.mvp_androidx.R;
import com.example.mvp_androidx.app.base.PresenterActivity;
import com.example.mvp_androidx.model.bean.TabEntity;
import com.example.mvp_androidx.presenter.MainPresenter;
import com.example.mvp_androidx.presenter.contract.MainContract;
import com.example.mvp_androidx.ui.fragment.HomeFragment;
import com.example.mvp_androidx.ui.fragment.LikeFragment;
import com.example.mvp_androidx.ui.fragment.MineFragment;
import com.example.mvp_androidx.utils.ToastUtil;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends PresenterActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.mp_text)
    TextView mpText;
    @BindView(R.id.fm_main)
    FrameLayout fmMain;
    @BindView(R.id.dl_main)
    DrawerLayout dlMain;
    @BindView(R.id.ctl_main)
    CommonTabLayout ctlMain;
    @BindView(R.id.DL_left)
    LinearLayout DLLeft;

    private String[] mTitles = {"首页", "收藏", "搜索"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private int[] img_u = {R.drawable.home, R.drawable.like, R.drawable.search_tab};
    private int[] img_p = {R.drawable.home_p, R.drawable.like_p, R.drawable.search_tab_p};


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }


    @Override
    protected void initInject() {
        mPresenter = new MainPresenter();
    }

    @Override
    protected void initEventAndData() {
        mPresenter.check(1, true);
        initTab();
    }

    @Override
    protected void initListener() {
        dlMain.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }
        });
    }

    private void initTab() {
        mFragments.add(new HomeFragment());
        mFragments.add(new LikeFragment());
        mFragments.add(new MineFragment());
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], img_p[i], img_u[i]));
        }
        ctlMain.setTabData(mTabEntities, this, R.id.fm_main, mFragments);
    }

    @OnClick({R.id.mp_menu, R.id.mp_search,R.id.left_home, R.id.left_like, R.id.left_search, R.id.left_suggest, R.id.left_setting, R.id.left_shape})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mp_menu:
                dlMain.openDrawer(DLLeft);
                break;
            case R.id.mp_search:
                ToastUtil.showShort(this, "搜索栏");
                break;
            case R.id.left_home:
            case R.id.left_like:
            case R.id.left_search:
                dlMain.closeDrawer(DLLeft);
                break;
            case R.id.left_suggest:
                ToastUtil.showShort(this,"问题与建议");
                break;
            case R.id.left_setting:
                ToastUtil.showShort(this,"设置");
                break;
            case R.id.left_shape:
                ToastUtil.showShort(this,"分享");
                break;
        }
    }


    @Override
    public void showText() {

    }

    @Override
    public void showAnimation() {

    }

    @Override
    public void showError(String msg) {
        ToastUtil.showShort(this, msg);
    }


}