package cn.coder_felicia.simplelive.basetool.basemvp;

import android.os.Bundle;
import android.view.View;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.tool.basemvp
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/8
 * 描述：
 */

public interface IView<P>  {
    void bindUI(View rootView);

    void bindEvent();

    void initData(Bundle savedInstanceState);

    int getOptionsMenuId();

    int getLayoutId();

    boolean useEventBus();

    P newP();
}
