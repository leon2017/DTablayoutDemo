package com.junwang.dtablayoutdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 当前类注释:
 * <p>
 * Author : junwang <p>
 * Created: 2017/11/21.下午3:29 <P>
 * Description:
 * <p>
 * E-mail:lijiawangjun@gmail.com
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    private List<String> mTabTitles;
    private List<Fragment> mFragments;

    public TabPagerAdapter(FragmentManager fm,
                           List<String> tabTitles,
                           List<Fragment> fragments) {
        super(fm);
        this.mTabTitles = tabTitles;
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTabTitles == null ? 0 : mTabTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles.get(position);
    }
}
