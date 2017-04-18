package cn.coder_felicia.simplelive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import cn.coder_felicia.simplelive.R;
import cn.coder_felicia.simplelive.basetool.baseadapter.SimpleRecAdapter;
import cn.coder_felicia.simplelive.basetool.basemvp.BindView;
import cn.coder_felicia.simplelive.tool.FeedBySAX.RSSItem;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.adapter
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/31
 * 描述：
 */

public class RSSTitleAdapter extends SimpleRecAdapter<RSSItem,RSSTitleAdapter.ViewHolder> {
    public static final int TAG_VIEW = 0;

    public RSSTitleAdapter(Context context) {
        super(context);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final RSSItem item = data.get(position);
        holder.pubDate.setText(item.getPubDate());
        holder.title.setText(item.getTitle());
        holder.category.setText(item.getCategory());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getRecItemClick() != null) {
                    getRecItemClick().onItemClick(position, item, TAG_VIEW, holder);
                }
            }
        });

    }

    @Override
    public ViewHolder newViewHolder(View itemView) {
        //设置监听跳转
        return new ViewHolder(itemView);
    }

    @Override
    public int getLayoutId() {
        return R.layout.rsstitle_item;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @butterknife.BindView(R.id.pubDate)
        TextView  pubDate;
        @butterknife.BindView(R.id.title)
        TextView title;
        @butterknife.BindView(R.id.category)
        TextView category;
        public ViewHolder(View itemView) {
            super(itemView);
            BindView.bind(this, itemView);
        }
    }

}

