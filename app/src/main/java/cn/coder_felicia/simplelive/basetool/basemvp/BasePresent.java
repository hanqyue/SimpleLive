package cn.coder_felicia.simplelive.basetool.basemvp;

import android.util.Log;

import cn.coder_felicia.simplelive.net.Api;
import cn.coder_felicia.simplelive.net.IWebPageService;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.tool.basemvp
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/10
 * 描述：
 */

public class BasePresent<V extends IView> implements IPresent<V> {
    public V v;
    protected IWebPageService api;
    private CompositeSubscription mCompositeSubscription;

    @Override
    public void attachV(V view) {
        v = view;
    }

    @Override
    public void detachV() {
        v = null;
        onUnsubscribe();
    }

    protected V getV() {
        if (v == null) {
            throw new IllegalStateException("v can not be null");
        }
        return v;
    }
    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
       // Log.e("BasePresent",mCompositeSubscription.toString());
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }


    public void addSubscription(Observable observable, Subscriber subscriber) {

        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }
}