package com.junwang.dtablayoutdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResId());
        preInit(savedInstanceState);
        mContext = this;
        findViews();
        initViews();
        initComplete();
    }

    protected void preInit(Bundle savedInstanceState){}

    protected abstract int layoutResId();

    /**
     * findViewById
     */
    protected abstract void findViews();

    /**
     * view初始化
     */
    protected abstract void initViews();

    /**
     * 初始化完成
     */
    protected abstract void initComplete();
}
