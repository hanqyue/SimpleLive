package cn.coder_felicia.simplelive.tool.FeedBySAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.tool.FeedBySAX
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/28
 * 描述：
 */

public class MyHandlerSAX extends DefaultHandler {
    private String nodeName;
    private String rootName;
    private RSSItem mRSSItem;
    private RSSSite mRSSSite;

    private String TAG = this.getClass().getSimpleName();

    public RSSSite getmRSSSite() {
        return mRSSSite;
    }

    //刚开始解析时调用
    @Override
    public void startDocument() throws SAXException {
        nodeName = "";
        rootName = "";
        mRSSSite = new RSSSite();
    }

    //开始解析节点时调用
    @Override
    public void startElement(String url, String localName, String qName, Attributes attributes){
        //当遇到一个item节点时，就实例化一个RSSItem对象
        if(localName.equals("channel")){
            rootName = localName;
        }else if(localName.equals("item")){
            rootName = localName;
            mRSSItem = new RSSItem();
        }else {
            nodeName = localName;
        }

    }

    //获取节点内容时调用
    @Override
    public void characters(char[] ch,int start,int length)throws SAXException{

        if(rootName.equals("channel")){
            if(nodeName.equals("title")){
                mRSSSite.setTitle(ch, start, length);
            }else if(nodeName.equals("description")){
                mRSSSite.setDescription(ch, start, length);
            }else if(nodeName.equals("link")){
                mRSSSite.setLink(ch, start, length);
            }
        }else if(rootName.equals("item")){
            if(nodeName.equals("title")){
                mRSSItem.setTitle(ch, start, length);
            }else if(nodeName.equals("description")){
                mRSSItem.setDescription(ch, start, length);
            }else if(nodeName.equals("link")){
                mRSSItem.setLink(ch, start, length);
            }else if(nodeName.equals("pubDate")){
                mRSSItem.setPubDate(ch, start, length);
            }else if(nodeName.equals("category")){
                mRSSItem.setCategory(ch, start, length);
            }
        }

    }
    //完成节点解析时调用
    @Override
    public void endElement(String url,String localName,String qName)throws SAXException {
        if (localName.equals("item")) {
            mRSSSite.setmRSSItems(mRSSItem);
        }
    }
    //完成整个XML解析时调用
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

}
