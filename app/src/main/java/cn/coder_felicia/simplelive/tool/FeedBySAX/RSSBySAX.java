package cn.coder_felicia.simplelive.tool.FeedBySAX;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.StringReader;

import javax.xml.parsers.SAXParserFactory;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.tool.FeedBySAX
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/29
 * 描述：
 */

public class RSSBySAX {

    public static RSSSite parseXMLWithSAX(String xmlData){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        XMLReader xmlReader = null;
        RSSSite rssSite = null;
        try {
            xmlReader = factory.newSAXParser().getXMLReader();
            MyHandlerSAX handler = new MyHandlerSAX();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new InputSource(new StringReader(xmlData)));
            rssSite = handler.getmRSSSite();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rssSite;
    }
}
