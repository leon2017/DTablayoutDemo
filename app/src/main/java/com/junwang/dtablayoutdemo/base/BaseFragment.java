package com.junwang.dtablayoutdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {

    protected View mContentView;

    protected boolean mVisible = true;
    private boolean mPrepared;
    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (mContentView == null) {
            mContentView = inflater.inflate(layoutResId(), container, false);
            preInit(savedInstanceState);
            findViews(mContentView);
            initViews();
            mPrepared = true;
            lazyLoad();
        }
        return mContentView;

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            mVisible = true;
            onVisible();
        } else {
            mVisible = false;
            onInvisible();
        }
    }

    /**
     * 布局id
     */
    @LayoutRes
    protected abstract int layoutResId();


    /**
     * view初始化
     */
    protected abstract void initViews();

    /**
     * 在{@link #findViews(View)}💰执行
     *
     * @param savedInstanceState {@link Bundle}
     */
    protected void preInit(Bundle savedInstanceState) {

    }

    /**
     * 放置findView方法
     */
    protected abstract void findViews(View view);


    /**
     * {@link android.support.v4.app.Fragment}可见
     */
    protected void onVisible() {
        lazyLoad();
    }

    /**
     * {@link android.support.v4.app.Fragment}不可见
     */
    protected void onInvisible() {

    }

    private void lazyLoad() {
        if (!mPrepared || !mVisible) {
            return;
        }
        loadData();
    }

    /**
     * 初始化完毕且页面可见
     */
    protected abstract void loadData();


    @Override
    public void onDestroy() {
        super.onDestroy();
        mContentView = null;
    }
}
