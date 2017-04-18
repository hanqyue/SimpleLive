package cn.coder_felicia.simplelive.basetool.basemvp;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.Unbinder;
import cn.coder_felicia.simplelive.R;
import cn.coder_felicia.simplelive.basetool.Event.BusProvider;
import cn.coder_felicia.simplelive.ui.VDelegate;
import cn.coder_felicia.simplelive.ui.VDelegateBase;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.tool.basemvp
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/10
 * 描述：
 */

public abstract class BaseFragment<P extends IPresent> extends Fragment implements IView<P> {

    protected Activity context;
    private View rootView;
    protected LayoutInflater layoutInflater;
    private Unbinder unbinder;
    private P p;
    private VDelegate vDelegate;
    private RxPermissions rxPermissions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutInflater = inflater;
        if (rootView == null && getLayoutId() > 0) {
            rootView = inflater.inflate(getLayoutId(), null);
            bindUI(rootView);
        } else {
            ViewGroup viewGroup = (ViewGroup) rootView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(rootView);
            }
        }
        if (useEventBus()) {
            BusProvider.getBus().register(this);
        }

        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("BaseFragment",getClass().getSimpleName());
        bindEvent();
        initData(savedInstanceState);
    }

    @Override
    public void bindUI(View rootView) {
        unbinder = BindView.bind(this,rootView);
    }

    @Override
    public void bindEvent() {

    }

    public VDelegate getvDelegate() {
        if (vDelegate == null) {
            vDelegate = VDelegateBase.create(context);
        }
        return vDelegate;
    }

    protected P getP() {
        if (p == null) {
            p = newP();
            if (p != null) {
                p.attachV(this);
            }
        }
        return p;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.context = (Activity) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        context = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (useEventBus()) {
            BusProvider.getBus().unregister(this);
        }
        if (getP() != null) {
            getP().detachV();
        }
        getvDelegate().destory();

        p = null;
        vDelegate = null;

    }


    protected RxPermissions getRxPermissions() {
        rxPermissions = new RxPermissions(getActivity());
       // rxPermissions.setLogging(XDroidConf.DEV);
        return rxPermissions;
    }

    @Override
    public int getOptionsMenuId() {
        return 0;
    }


    @Override
    public boolean useEventBus() {
        return false;
    }
}
