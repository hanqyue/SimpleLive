package cn.coder_felicia.simplelive.tool;

import android.util.Log;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.tool
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/16
 * 描述：
 */

public class URLAnalysis {
    private String baseurl;
    private String feedtype;

    public URLAnalysis(String url){
        analysis(url);
    }
    public String getBaseurl() {
        return baseurl;
    }

    public String getFeedtype() {
        return feedtype;
    }
    public void analysis(String url) {

        if (!"".equals(url)) {// 如果URL不是空字符串
            String inter= url.substring(url.indexOf("//") + 2);
            int position = inter.indexOf("/") + 1;
            feedtype = inter.substring(position);
            baseurl = url.substring(0,position+7);
        }
    }
}
