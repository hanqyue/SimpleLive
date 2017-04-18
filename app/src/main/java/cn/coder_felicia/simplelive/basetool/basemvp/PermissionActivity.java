package cn.coder_felicia.simplelive.basetool.basemvp;


import android.Manifest;
import android.os.Bundle;

import rx.functions.Action1;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.basetool.basemvp
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/29
 * 描述：
 */

public class PermissionActivity extends BaseActivity {

    @Override
    public void initData(Bundle savedInstanceState) {
//        getRxPermissions()
//                .request(Manifest.permission.CAMERA)
//                .subscribe(new Action1<Boolean>() {
//                    @Override
//                    public void call(Boolean granted) {
//                        if (granted) {
//                            //TODO 许可
//
//                        } else {
//                            //TODO 未许可
//
//                        }
//                    }
//                });
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public Object newP() {
        return null;
    }
}
