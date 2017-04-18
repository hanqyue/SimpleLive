package cn.coder_felicia.simplelive.present;

import android.util.Log;

import java.io.IOException;

import cn.coder_felicia.simplelive.basetool.basemvp.BasePresent;
import cn.coder_felicia.simplelive.net.Api;
import cn.coder_felicia.simplelive.net.IWebPageService;
import cn.coder_felicia.simplelive.tool.ApiCallback;
import cn.coder_felicia.simplelive.tool.FeedBySAX.RSSBySAX;
import cn.coder_felicia.simplelive.tool.FeedBySAX.RSSSite;
import cn.coder_felicia.simplelive.tool.URLAnalysis;
import cn.coder_felicia.simplelive.ui.BasePagerFragment;
import okhttp3.ResponseBody;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.present
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/10
 * 描述：
 */

public class PBasePager extends BasePresent<BasePagerFragment> {

    /**
     * 调用封装好的网络api类
     * @param url
     * @param page
     */
    public void loadData(String url, final int page) {
        URLAnalysis urlinfo = new URLAnalysis(url);
        Log.i(this.getClass().getSimpleName(),url+","+page);
        IWebPageService api = new Api().getWebPageService(urlinfo.getBaseurl());
        addSubscription(api.getSiteInfo(urlinfo.getFeedtype()),
                new ApiCallback<ResponseBody>() {

                    @Override
                    public void onSuccess(ResponseBody model) {
                        Log.i("PBasePager","请求成功");
                        RSSSite rssSite = null;
                        try {
                            rssSite = RSSBySAX.parseXMLWithSAX(model.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Log.i("QWE",rssSite.getTitle()+"page = "+page);
                        getV().showData(page, rssSite);
                    }

                    @Override
                    public void onFailure(String error) {
                        getV().showError(error);
                    }

                    @Override
                    public void onFinish() {
                        Log.i("PBasePager","结束");
                        //通知视图，停止刷新
                        getV().stopRefresh();
                    }
                });
    }
}