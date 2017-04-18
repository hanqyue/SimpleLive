package cn.coder_felicia.simplelive.tool;

import android.util.Log;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.tool
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/29
 * 描述：
 */

public abstract class ApiCallback<M> extends Subscriber<M> {

    public abstract void onSuccess(M model);

    public abstract void onFailure(String msg);

    public abstract void onFinish();


    @Override
    public void onError(Throwable e) {
//
//        RetrofitError ex = (RetrofitError) e;
//        Response res = ex.getResponse();
//        if(res!=null){
//            int statusCode = res.getStatus();
//        }

        e.printStackTrace();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()

            int code = httpException.code();
            String msg = httpException.getMessage();

            if (code == 504) {
                msg = "网络不给力";
            }
            if (code == 502 || code == 404) {
                msg = "服务器异常，请稍后再试";
            }
            onFailure(msg);
        } else {
            onFailure(e.getMessage());
        }
        onFinish();
    }

    @Override
    public void onNext(M model) {
        Log.e("ApiCallback<M>",model.toString());
        onSuccess(model);
    }

    @Override
    public void onCompleted() {
        onFinish();
    }
}
