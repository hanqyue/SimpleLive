package cn.coder_felicia.simplelive.tool.FeedBySAX;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.tool.FeedBySAX
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/28
 * 描述：
 */

public class RSSSite {
    private StringBuilder title;
    private StringBuilder description;
    private StringBuilder link;
    private List<RSSItem> mRSSItems;
    RSSSite(){
        title = new StringBuilder();
        description = new StringBuilder();
        link = new StringBuilder();
        mRSSItems = new ArrayList();
    }
    public String getTitle() {
        return this.title.toString().trim();
    }

    public void setTitle(char[] ch,int start,int length) {
        this.title.append(ch, start, length);
    }

    public String getDescription() {
        return description.toString().trim();
    }

    public void setDescription(char[] ch,int start,int length) {
        this.description.append(ch, start, length);
    }

    public String getLink() {
        return link.toString().trim();
    }

    public void setLink(char[] ch,int start,int length) {
        this.link.append(ch, start, length);
    }

    public List<RSSItem> getmRSSItems() {
        return mRSSItems;
    }

    public void setmRSSItems(RSSItem mRSSItems) {
        this.mRSSItems.add(mRSSItems);
    }


}
