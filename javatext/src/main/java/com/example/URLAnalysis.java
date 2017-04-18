package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名：  SimpleLive
 * 包名：    com.example
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/16
 * 描述：
 */

public class URLAnalysis {
    private Map<String, String> paramMap = new HashMap<String, String>();

    public void analysis(String url) {
        paramMap.clear();
        if (!"".equals(url)) {// 如果URL不是空字符串
            url = url.substring(url.indexOf('?') + 1);
            String paramaters[] = url.split("&");
            for (String param : paramaters) {
                String values[] = param.split("=");
                paramMap.put(values[0], values[1]);
            }
        }
    }

    public String getParam(String name) {
        return paramMap.get(name);
    }

    public static void main(String[] args) {
        String test = "http://droidyue.com/atom.xml";
        if (!"".equals(test)) {// 如果URL不是空字符串
            String  inter= test.substring(test.indexOf("//") + 2);
            int position = inter.indexOf("/") + 1;
            inter = inter.substring(position);
            String baseurl = test.substring(0,position+7);
            System.out.println(baseurl+"  "+inter);
        }
//        URLAnalysis urlAnalysis = new URLAnalysis();
//        urlAnalysis.analysis(test);
//        System.out.println("name = " + urlAnalysis.getParam("name"));
//        System.out.println("id = " + urlAnalysis.getParam("id"));
    }
}