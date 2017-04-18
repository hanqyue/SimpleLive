package cn.coder_felicia.simplelive;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/9
 * 描述： 基础订阅源类
 */
public enum RssSourceEnum {

     MrPeak("MrPeak杂货铺","http://mrpeak.cn/feed.xml"),
     Jaeger("写代码的猴子","http://jaeger.itscoder.com/feed/"),
     GcsSloop("GcsSloop","http://www.gcssloop.com/feed.xml");

    //droidyue("技术小黑屋","http://droidyue.com/atom.xml"),
    //hukai("胡凯","http://hukai.me/atom.xml"),

    private String tag;
    private String url;

    RssSourceEnum(String tag, String url) {
        this.tag = tag;
        this.url = url;
    }

    public String getTag() {
        return tag;
    }

    public String getUrl() {
        return url;
    }

}

