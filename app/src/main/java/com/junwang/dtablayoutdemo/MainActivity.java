package com.junwang.dtablayoutdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.junwang.dtablayoutdemo.base.BaseActivity;
import com.junwang.dtablayoutdemo.modules.main.AFragment;
import com.junwang.dtablayoutdemo.modules.main.BFragment;
import com.junwang.dtablayoutdemo.modules.main.CFragment;
import com.junwang.dtablayoutdemo.modules.main.DFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout mActivityMain;
    private FrameLayout mFlFragments;
    private LinearLayout mLlTabs;
    private ImageView mTabHome;
    private ImageView mTabExplore;
    private ImageView mTabNotification;
    private ImageView mTabProfile;

    private FragmentManager mFragmentManager;

    private int lastPosition = -1;
    private DFragment mProfileFragment;
    private AFragment mHomeFragment;
    private BFragment mExploreFragment;
    private CFragment mNotificationFragment;

    @Override
    protected int layoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViews() {
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);
        mFlFragments = (FrameLayout) findViewById(R.id.fl_fragments);
        mLlTabs = (LinearLayout) findViewById(R.id.ll_tabs);
        mTabHome = (ImageView) findViewById(R.id.tab_home);
        mTabExplore = (ImageView) findViewById(R.id.tab_explore);
        mTabNotification = (ImageView) findViewById(R.id.tab_notification);
        mTabProfile = (ImageView) findViewById(R.id.tab_profile);
    }

    @Override
    protected void initViews() {
        mTabHome.setOnClickListener(this);
        mTabExplore.setOnClickListener(this);
        mTabNotification.setOnClickListener(this);
        mTabProfile.setOnClickListener(this);
    }

    @Override
    protected void initComplete() {
        mFragmentManager = getSupportFragmentManager();
        mHomeFragment = (AFragment) mFragmentManager.findFragmentById(
                R.id.home_fragment);
        mExploreFragment = (BFragment) mFragmentManager.findFragmentById(
                R.id.exolore_fragment);
        mNotificationFragment =
                (CFragment) mFragmentManager.findFragmentById(
                        R.id.notification_fragment);
        mProfileFragment = (DFragment) mFragmentManager.findFragmentById(
                R.id.profile_fragment);
        selectTab(0);
    }

    private void selectTab(int position) {
        FragmentTransaction fragmentTransaction =
                mFragmentManager.beginTransaction();
        switch (lastPosition) {
            case 0:
                mTabHome.setEnabled(true);
                fragmentTransaction.hide(mHomeFragment);
                break;
            case 1:
                mTabExplore.setEnabled(true);
                fragmentTransaction.hide(mExploreFragment);
                break;
            case 2:
                mTabNotification.setEnabled(true);
                fragmentTransaction.hide(mNotificationFragment);
                break;
            case 3:
                mTabProfile.setEnabled(true);
                fragmentTransaction.hide(mProfileFragment);
                break;
            default:
                mTabExplore.setEnabled(true);
                mTabNotification.setEnabled(true);
                mTabProfile.setEnabled(true);
                fragmentTransaction.hide(mExploreFragment);
                fragmentTransaction.hide(mNotificationFragment);
                fragmentTransaction.hide(mProfileFragment);
                break;
        }
        lastPosition = position;
        switch (lastPosition) {
            case 0:
                mTabHome.setEnabled(false);
                fragmentTransaction.show(mHomeFragment);
                break;
            case 1:
                mTabExplore.setEnabled(false);
                fragmentTransaction.show(mExploreFragment);
                break;
            case 2:
                mTabNotification.setEnabled(false);
                fragmentTransaction.show(mNotificationFragment);
                break;
            case 3:
                mTabProfile.setEnabled(false);
                fragmentTransaction.show(mProfileFragment);
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tab_home:
                selectTab(0);
                break;
            case R.id.tab_explore:
                selectTab(1);
                break;
            case R.id.tab_notification:
                selectTab(2);
                break;
            case R.id.tab_profile:
                selectTab(3);
                break;
        }
    }
}
