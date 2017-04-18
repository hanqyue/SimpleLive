package cn.coder_felicia.simplelive.basetool.baseadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.coder_felicia.simplelive.tool.FeedBySAX.RSSItem;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.basetool.baseadapter
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/31
 * 描述：
 */

public abstract class SimpleRecAdapter<T,F extends RecyclerView.ViewHolder> extends RecyclerAdapter<T, F>  {

    public SimpleRecAdapter(Context context) {
        super(context);
    }

    @Override
    public F onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
        return newViewHolder(view);
    }

    public abstract F newViewHolder(View itemView);

    public abstract int getLayoutId();

}
