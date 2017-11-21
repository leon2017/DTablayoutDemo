package com.junwang.dtablayoutdemo.modules.main.a;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.junwang.dtablayoutdemo.R;
import com.junwang.dtablayoutdemo.base.BaseFragment;

/**
 * 当前类注释:
 * <p>
 * Author : junwang <p>
 * Created: 2017/11/21.下午3:10 <P>
 * Description:
 * <p>
 * E-mail:lijiawangjun@gmail.com
 */

public class AChildFragment extends BaseFragment {

    private int mApostion;

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("apostion", position);
        AChildFragment fragment = new AChildFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int layoutResId() {
        return R.layout.frgment_a_child;
    }

    @Override
    protected void initViews() {
        AppCompatTextView textView = mContentView.findViewById(R.id.tv_container);
        Bundle bundle = getArguments();
        if (null != bundle) {
            mApostion = bundle.getInt("apostion");
        }
        textView.setText("我是child" + mApostion);
    }

    @Override
    protected void findViews(View view) {

    }

    @Override
    protected void loadData() {

    }


}
