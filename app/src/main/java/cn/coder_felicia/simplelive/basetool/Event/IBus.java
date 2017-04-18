package cn.coder_felicia.simplelive.basetool.Event;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.basetool.Event
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/29
 * 描述：
 */

public interface IBus {

    void register(Object object);
    void unregister(Object object);
    void post(IEvent event);
    void postSticky(IEvent event);


    interface IEvent {
        int getTag();
    }

}
