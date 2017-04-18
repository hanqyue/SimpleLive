package cn.coder_felicia.simplelive.tool.FeedBySAX;

import android.util.Log;

import java.io.Serializable;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.tool.FeedBySAX
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/28
 * 描述：
 */

public class RSSItem implements Serializable{
    private StringBuilder title;
    private StringBuilder description;
    private StringBuilder pubDate;
    private StringBuilder link;
    private StringBuilder category;
    RSSItem(){
        title = new StringBuilder();
        description = new StringBuilder();
        pubDate = new StringBuilder();
        link = new StringBuilder();
        category = new StringBuilder();
    }
    public String getTitle() {
        return title.toString().trim();
    }

    public void setTitle(char[] ch,int start,int length) {
        this.title.append(ch, start, length);
    }

    public String getDescription() {
        String html = description.toString().trim();
        String str = html.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
        str = str.replaceAll("[(/>)<]", "");
        return str;
    }

    public void setDescription(char[] ch,int start,int length) {
        this.description.append(ch, start, length);
    }

    public String getPubDate() {
        return pubDate.toString().trim();
    }

    public void setPubDate(char[] ch,int start,int length) {
        this.pubDate.append(ch, start, length);
    }

    public String getLink() {
        return link.toString().trim();
    }

    public void setLink(char[] ch,int start,int length) {
        this.link.append(ch, start, length);
    }

    public String getCategory() {
        return category.toString().trim();
    }

    public void setCategory(char[] ch,int start,int length) {
        for(int i=start;i<length+start;i++){
            if(ch[i]!='\n'&&ch[i]!=' ')
                this.category.append(ch[i]);
        }
    }


}
