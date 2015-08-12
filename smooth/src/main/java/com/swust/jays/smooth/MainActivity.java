package com.swust.jays.smooth;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mList;
    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapingLayout;
    private SwipeRefreshLayout mSwipeRefresh;
    private FloatingActionButton mFab;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;


    private TestAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();


        initData();
        mAdapter = new TestAdapter(this, mList);

//          mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,
//                StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
//        mRecyclerView.setAdapter(new AdapterR(this, mList));
        mAdapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "you click" + mList.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondPage.class);
                startActivity(intent);

            }
        });
    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recycler_view);
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        mCollapingLayout = (CollapsingToolbarLayout) findViewById(R.id.id_collasp_layout);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.id_navigation_view);
        mFab = (FloatingActionButton) findViewById(R.id.id_fab);

        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.id_swipe_fresh);
        mSwipeRefresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_red_light);
    }

    private void initData() {
        setSupportActionBar(mToolbar);
        mCollapingLayout.setTitle("我的课程");
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.mipmap.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        mList = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            mList.add(String.valueOf((char) i));
        }
//        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//
//                mList.add(String.valueOf("65"));
//                mAdapter.notifyDataSetChanged();
//                mSwipeRefresh.setRefreshing(false);
//            }
//        });
//        setupDrawerContent(mNavigationView);
    }
//
//    private void setupDrawerContent(NavigationView navigationView) {
//        if (navigationView != null) {
//            navigationView.setNavigationItemSelectedListener(
//                    new NavigationView.OnNavigationItemSelectedListener() {
//                        @Override
//                        public boolean onNavigationItemSelected(MenuItem menuItem) {
//
//                            menuItem.setChecked(true);
//                            mDrawerLayout.closeDrawers();
//                            return true;
//                        }
//                    });
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
