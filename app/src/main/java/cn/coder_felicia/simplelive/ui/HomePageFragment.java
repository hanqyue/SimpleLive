package cn.coder_felicia.simplelive.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import cn.coder_felicia.simplelive.R;
import cn.coder_felicia.simplelive.RssSourceEnum;
import cn.coder_felicia.simplelive.RssSourceManage;
import cn.coder_felicia.simplelive.adapter.RSSTitleAdapter;
import cn.coder_felicia.simplelive.basetool.baseadapter.RecyclerItemCallback;
import cn.coder_felicia.simplelive.basetool.baseadapter.SimpleRecAdapter;
import cn.coder_felicia.simplelive.present.PBasePager;
import cn.coder_felicia.simplelive.tool.FeedBySAX.RSSItem;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.ui
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/10
 * 描述：
 */

public class HomePageFragment extends BasePagerFragment {

    @BindView(R.id.description)
    TextView description;
    RSSTitleAdapter adapter;
    @Override
    public SimpleRecAdapter getAdapter(List<RSSItem> rssitem,int page) {
        if (adapter == null) {
            adapter = new RSSTitleAdapter(context);

            if (page > 1) {
            adapter.addData(rssitem);
            } else {
            adapter.setData(rssitem);
            }
            adapter.setRecItemClick(new RecyclerItemCallback<RSSItem, RSSTitleAdapter.ViewHolder>(){

                public void onItemClick(int position, RSSItem model, int tag, RSSTitleAdapter.ViewHolder holder) {
                    super.onItemClick(position, model, tag, holder);
                    Log.i(this.getClass().getSimpleName(),model.getTitle());
                    switch (tag) {
                        case RSSTitleAdapter.TAG_VIEW:
                            ArticleDetailActivity.launch(context,model);
                            break;
                    }
                }
            });

        }
        return adapter;
    }

    @Override
    protected void setOtherView(String info) {
        description.setText(info);
    }

    @Override
    protected Context getCurrentFragment() {
        return context;
    }

    public static HomePageFragment newInstance(RssSourceEnum s) {
        HomePageFragment frag = new HomePageFragment();
        Bundle bud = new Bundle();
        bud.putString(RssSourceManage.url, s.getUrl());
        frag.setArguments(bud);
        return frag;
    }

    @Override
    protected String getURL() {
        Bundle arguments = getArguments();
        String requestUrl = arguments.getString(RssSourceManage.url);
        return requestUrl;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_content;
    }

    @Override
    public PBasePager newP() {
        return new PBasePager();
    }
}
