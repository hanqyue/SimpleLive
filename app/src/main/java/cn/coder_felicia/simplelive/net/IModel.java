package cn.coder_felicia.simplelive.net;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.net
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/28
 * 描述：
 */

public interface IModel {
    boolean isNull();       //空数据

    boolean isAuthError();  //验证错误

    boolean isBizError();   //业务错误

    String getErrorMsg();   //后台返回的错误信息
}
