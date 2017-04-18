package cn.coder_felicia.simplelive.basetool.basemvp;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.tool.basemvp
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/8
 * 描述：
 */

public interface IPresent<V> {
    void attachV(V view);

    void detachV();
}