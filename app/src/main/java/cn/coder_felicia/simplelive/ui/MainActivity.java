package cn.coder_felicia.simplelive.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.coder_felicia.simplelive.R;
import cn.coder_felicia.simplelive.RssSourceEnum;
import cn.coder_felicia.simplelive.RssSourceManage;
import cn.coder_felicia.simplelive.basetool.baseadapter.BaseFragmentAdapter;
import cn.coder_felicia.simplelive.basetool.basemvp.BaseActivity;

/**
 * 首页activity
 */
public class MainActivity extends BaseActivity{

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsing_toolbar;
    @BindView(R.id.image_view)
    ImageView imageview;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    BaseFragmentAdapter adapter;

    List<Fragment> fragmentList = new ArrayList<>();
    String[] titles = {"MrPeak杂货铺", "写代码的猴子", "GcsSloop"};

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        collapsing_toolbar.setTitle("天气");
        collapsing_toolbar.setCollapsedTitleTextColor(255);
        Glide.with(this).load(R.drawable.bing).into(imageview);

        for(RssSourceEnum s: RssSourceEnum.values()){
            fragmentList.add(HomePageFragment.newInstance(s));
        }

        if (adapter == null) {
            adapter = new BaseFragmentAdapter(getSupportFragmentManager(), fragmentList,titles);
        }
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //AddRssActivity.newInstance();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    /**
     * 刷新数据，主要是内容的改变
     */
//    private void flushTab(){
//        fragmentList.clear();
//
//        for(RssSourceEnum s: RssSourceEnum.values()){
//            fragmentList.add(HomePageFragment.newInstance(s));
//        }
//        viewPager.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//        tabLayout.setupWithViewPager(viewPager);
//        if (fragmentList.size() < 5) {
//            tabLayout.setTabMode(TabLayout.MODE_FIXED);
//        } else {
//            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        }
//
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RssSourceManage.RequestCode:
              //  flushTab();
                break;
        }
    }

    @Override
    public Object newP() {
        return null;
    }

}
