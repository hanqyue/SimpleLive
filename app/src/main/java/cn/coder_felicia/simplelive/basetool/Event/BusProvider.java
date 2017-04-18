package cn.coder_felicia.simplelive.basetool.Event;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.basetool.basemvp
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/29
 * 描述：
 */

public class BusProvider {
    private static RxBusImpl bus;

    public static RxBusImpl getBus() {
        if (bus == null) {
            synchronized (BusProvider.class) {
                if (bus == null) {
                    bus = new RxBusImpl();
                }
            }
        }
        return bus;
    }
}
