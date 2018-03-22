package com.gapcoder.api.FG;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

/**
 * Created by suxiaohui on 2018/3/20.
 */


public class PagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> list;
    List<String> title;
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public PagerAdapter(FragmentManager fm,List<Fragment> list,List<String> title) {
        super(fm);
        this.list=list;
        this.title=title;

    }
    @Override
    public Fragment getItem(int arg0){
        return list.get(arg0);
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public CharSequence getPageTitle(int pos){
        return title.get(pos);
    }
}
