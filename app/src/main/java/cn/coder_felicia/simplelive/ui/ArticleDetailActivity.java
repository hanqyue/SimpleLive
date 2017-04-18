package cn.coder_felicia.simplelive.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import cn.coder_felicia.simplelive.R;
import cn.coder_felicia.simplelive.RssSourceEnum;
import cn.coder_felicia.simplelive.RssSourceManage;
import cn.coder_felicia.simplelive.basetool.basemvp.BaseActivity;
import cn.coder_felicia.simplelive.tool.AppKit;
import cn.coder_felicia.simplelive.tool.FeedBySAX.RSSItem;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.ui
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/4/5
 * 描述：
 */

public class ArticleDetailActivity extends BaseActivity{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.pubDate)
    TextView pubDate;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.description)
    TextView description;

    private RSSItem item;

    @Override
    public void initData(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        item = (RSSItem) getIntent().getSerializableExtra(RssSourceManage.RssInfo);

        initToolbar();
        initWebView();
    }

    private void initToolbar(){
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setTitle(item.getTitle());

    }

    private void initWebView(){
        title.setText(item.getTitle());
        pubDate.setText(item.getPubDate());
        category.setText(item.getCategory());
        description.setText(item.getDescription());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_share:
                AppKit.shareText(this, "「 "+item.getTitle()+" 」"+item.getLink() + " -来自简Live");
                break;
            case R.id.action_copy:
                AppKit.copyToClipBoard(this, item.getLink());
                break;
            case R.id.action_open_in_browser:
                AppKit.openInBrowser(this, item.getLink());
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public int getOptionsMenuId() {
        return R.menu.menu_articledetail;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_articledetail;
    }

    @Override
    public Object newP() {
        return null;
    }

    public static void launch(Context context,RSSItem model) {
        Intent intent = new Intent(context,ArticleDetailActivity.class);
        intent.putExtra(RssSourceManage.RssInfo,model);
        context.startActivity(intent);
    }
}
