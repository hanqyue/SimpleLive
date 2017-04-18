package cn.coder_felicia.simplelive.ui;

import android.view.View;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.basetool.basemvp
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/29
 * 描述：
 */

public interface VDelegate {
    void resume();

    void pause();

    void destory();

    void visible(boolean flag, View view);
    void gone(boolean flag, View view);
    void inVisible(View view);

    void toastShort(String msg);
    void toastLong(String msg);
}
