package cn.coder_felicia.simplelive.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import cn.coder_felicia.simplelive.R;
import cn.coder_felicia.simplelive.RssSourceManage;
import cn.coder_felicia.simplelive.basetool.baseadapter.SimpleRecAdapter;
import cn.coder_felicia.simplelive.present.PBasePager;
import cn.coder_felicia.simplelive.basetool.basemvp.BaseFragment;
import cn.coder_felicia.simplelive.tool.FeedBySAX.RSSItem;
import cn.coder_felicia.simplelive.tool.FeedBySAX.RSSSite;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.ui
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/10
 * 描述：
 */

public abstract class BasePagerFragment extends BaseFragment<PBasePager> {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    protected static int page = 1;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRefreshLayout();
        getP().loadData(getURL(), page++);
    }

    private void initRefreshLayout(){
        swipeRefresh.setColorSchemeResources(
                android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        swipeRefresh.setRefreshing(true);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                Log.d("统计请求URL次数", getURL());
                getP().loadData(getURL(), page++);
            }
        });

    }

    protected abstract String getURL();
    protected abstract SimpleRecAdapter getAdapter(List<RSSItem> rssitem,int page);
    protected abstract void setOtherView(String info);
    protected abstract Context getCurrentFragment();

    public void showError(String error) {
        if (error != null) {
           Toast.makeText(getContext(),error,Toast.LENGTH_SHORT);
        }

    }

    public void showData(int page, RSSSite model) {
        setOtherView(model.getDescription());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getCurrentFragment());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(getAdapter(model.getmRSSItems(),page));
    }

    public void stopRefresh(){
        swipeRefresh.setRefreshing(false);
    }

}
