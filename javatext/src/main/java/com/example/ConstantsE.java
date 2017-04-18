package com.example;

/**
 * 项目名：  SimpleLive
 * 包名：    com.example
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/9
 * 描述：
 */

public enum ConstantsE {
    Constants_A("21","我是枚举类型A"),
    Constants_B("112","我是枚举类型B");
    private String description;
    String q,b;

    ConstantsE(String q,String b){
        this.q = q;
        this.b = b;
    }

    public String getB() {
        return b;
    }

    public String getQ() {
        return q;
    }

    private ConstantsE(String _description){
        this.description = _description;
    }

    public String getDescription(){
        return this.description;
    }
}
