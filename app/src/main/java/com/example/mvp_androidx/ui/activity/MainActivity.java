package com.example.mvp_androidx.ui.activity;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.mvp_androidx.R;
import com.example.mvp_androidx.app.base.PresenterActivity;
import com.example.mvp_androidx.presenter.MainPresenter;
import com.example.mvp_androidx.presenter.contract.MainContract;
import com.example.mvp_androidx.ui.fragment.HomeFragment;
import com.example.mvp_androidx.ui.fragment.LikeFragment;
import com.example.mvp_androidx.ui.fragment.MineFragment;
import com.zdm.tablayout.TabEntity;
import com.zdm.tablayout.TabInterface;
import com.zdm.tablayout.TabLayout;
import com.zdm.tablayout.TabRecylerAdapter;

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
    @BindView(R.id.tabLayout)
    TabLayout ctlMain;
    @BindView(R.id.DL_left)
    LinearLayout DLLeft;

    private String[] mTitles = {"首页", "收藏", "搜索"};
    private ArrayList<TabEntity> mTabEntities = new ArrayList<>();
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


        ctlMain.addItemBindViewDataListener((holder, tabEntity, selectPosition, position) ->
                Toast.makeText(MainActivity.this, mTitles[position], Toast.LENGTH_SHORT).show());

    }

    private void initTab() {
        mFragments.add(new HomeFragment());
        mFragments.add(new LikeFragment());
        mFragments.add(new MineFragment());

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], img_p[i], img_u[i]));
        }
        ctlMain.bindViewData(mTabEntities, mFragments, R.id.fm_main);
        ctlMain.defaultSelected(0);
    }

    @OnClick({R.id.mp_menu, R.id.mp_search, R.id.left_home, R.id.left_like, R.id.left_search, R.id.left_suggest, R.id.left_setting, R.id.left_shape})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mp_menu:
                dlMain.openDrawer(DLLeft);
                break;
            case R.id.mp_search:
                Toast.makeText(this, "搜索栏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.left_home:
            case R.id.left_like:
            case R.id.left_search:
                dlMain.closeDrawer(DLLeft);
                break;
            case R.id.left_suggest:
                Toast.makeText(this, "问题与建议", Toast.LENGTH_SHORT).show();
                break;
            case R.id.left_setting:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.left_shape:
                Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
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
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}