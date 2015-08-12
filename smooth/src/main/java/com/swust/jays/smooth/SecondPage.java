package com.swust.jays.smooth;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jays on 15-8-10.
 */
public class SecondPage extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_laayout);
        initViews();
        initDatas();
    }

    private void initDatas() {
        List<String> titles = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();
        titles.add("PAGE1");
        titles.add("PAGE2");
        titles.add("PAGE3");
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(2)));
        fragments.add(new ListFragment());
        fragments.add(new ListFragment());
        fragments.add(new ListFragment());
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(),
                fragments, titles);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(adapter);
        mToolbar.setTitle("我的课程");

    }

    private void initViews() {
        mTabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

    }
}
