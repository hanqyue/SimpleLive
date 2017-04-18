package cn.coder_felicia.simplelive.basetool.Event;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.basetool.basemvp
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/29
 * 描述：
 */

public class RxBusImpl implements IBus {

    private final Subject<IEvent, IEvent> bus = new SerializedSubject<>(PublishSubject.<IEvent>create());

    @Override
    public void register(Object object) {

    }

    @Override
    public void unregister(Object object) {

    }

    @Override
    public void post(IEvent event) {
        bus.onNext(event);
    }

    @Override
    public void postSticky(IEvent event) {

    }

    public <T extends IEvent> Observable<T> toObservable(Class<T> eventType) {
        return bus.ofType(eventType);
    }
}
