package cn.coder_felicia.simplelive.net;

import android.util.Log;

import cn.coder_felicia.simplelive.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.net
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/16
 * 描述：
 */

public class Api {

    private IWebPageService webPageService;
    private Retrofit mRetrofit;

    public IWebPageService getWebPageService(String baseurl) {

        if (webPageService == null) {
            synchronized (Api.class) {
                if (webPageService == null) {
                    webPageService = retrofit(baseurl).create(IWebPageService.class);
                }
            }
        }
        return webPageService;
    }



    private Retrofit retrofit(String baseurl) {
        if (mRetrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

//            if (BuildConfig.DEBUG) {
//                // Log信息拦截器
//                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//                //设置 Debug Log 模式
//                builder.addInterceptor(loggingInterceptor);
//            }
            OkHttpClient okHttpClient = builder.build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();

        }
        return mRetrofit;
    }

}
