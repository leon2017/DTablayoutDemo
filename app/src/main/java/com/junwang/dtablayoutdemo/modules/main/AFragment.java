package com.junwang.dtablayoutdemo.modules.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.junwang.dtablayoutdemo.R;
import com.junwang.dtablayoutdemo.adapter.TabPagerAdapter;
import com.junwang.dtablayoutdemo.base.BaseFragment;
import com.junwang.dtablayoutdemo.modules.main.a.AChildFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类注释:
 * <p>
 * Author : junwang <p>
 * Created: 2017/11/21.下午3:07 <P>
 * Description:
 * <p>
 * E-mail:lijiawangjun@gmail.com
 */

public class AFragment extends BaseFragment {

    private TabLayout mTabContainer;
    private ViewPager mVpContainer;
    private TabPagerAdapter mPagerAdapter;

    @Override
    protected int layoutResId() {
        return R.layout.frgment_a;
    }


    @Override
    protected void findViews(View view) {
        mTabContainer = (TabLayout) mContentView.findViewById(R.id.tab_container);
        mVpContainer = (ViewPager) mContentView.findViewById(R.id.vp_container);
    }

    @Override
    protected void initViews() {
        List<String> titles = new ArrayList<>();
        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            titles.add("伟哥"+i);
            fragmentList.add(AChildFragment.getInstance(i));
        }
        mPagerAdapter = new TabPagerAdapter(getChildFragmentManager(), titles, fragmentList);
        mVpContainer.setAdapter(mPagerAdapter);
        mTabContainer.setupWithViewPager(mVpContainer);
    }

    @Override
    protected void loadData() {

    }
}
