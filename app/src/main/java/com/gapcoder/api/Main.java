package com.gapcoder.api;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gapcoder.api.FG.PagerAdapter;
import com.gapcoder.api.Fragment.F1;
import com.gapcoder.api.Fragment.F2;
import com.gapcoder.api.Fragment.F3;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    FragmentManager fm;


   // @BindView(R.id.toolbar)
    Toolbar toolbar;
   // @BindView(R.id.tab)
    TabLayout tab;
    //@BindView(R.id.pv)
    ViewPager pv;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar t=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(t);
        ActionBar ab=getSupportActionBar();
        tab=(TabLayout)findViewById(R.id.tab);
        pv=(ViewPager)findViewById(R.id.pv);
        init();
    }

    private void init() {
        fm = getSupportFragmentManager();
        final List<Fragment> list = new ArrayList<>(3);
        Fragment fg = new F1();
        list.add(fg);
        fg = new F2();
        list.add(fg);
        fg = new F3();
        list.add(fg);
        List<String> title = new ArrayList<>(3);
        title.add("热映");
        title.add("即将上映");
        title.add("TOP250");
        PagerAdapter adapter = new PagerAdapter(fm, list, title);
        pv.setAdapter(adapter);
        tab.setupWithViewPager(pv);
    }
}
