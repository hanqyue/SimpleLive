package cn.coder_felicia.simplelive.ui;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.ui
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/29
 * 描述：
 */


public class VDelegateBase implements VDelegate {

    private Context context;

    private VDelegateBase(Context context) {
        this.context = context;
    }

    public static VDelegate create(Context context) {
        return new VDelegateBase(context);
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destory() {

    }

    @Override
    public void visible(boolean flag, View view) {
        if (flag) view.setVisibility(View.VISIBLE);
    }

    @Override
    public void gone(boolean flag, View view) {
        if (flag) view.setVisibility(View.GONE);
    }

    @Override
    public void inVisible(View view) {
        view.setVisibility(View.INVISIBLE);
    }

    @Override
    public void toastShort(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toastLong(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
