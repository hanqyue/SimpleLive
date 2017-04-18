package cn.coder_felicia.simplelive.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.net
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/16
 * 描述：
 */

public interface IWebPageService {
    @GET("{type}")
    Observable<ResponseBody> getSiteInfo(@Path("type") String type);
}
