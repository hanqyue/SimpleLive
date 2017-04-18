package cn.coder_felicia.simplelive.basetool.baseadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.tool.baseadapter
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/10
 * 描述：    FragmentPagerAdapter适用于页面比较少的情况，FragmentStatePagerAdapter适用于页面比较多的情况,
 *       因此继承FragmentStatePagerAdapter
 */

public class BaseFragmentAdapter<T extends Fragment> extends FragmentStatePagerAdapter {
    private List<T> fragmentList = new ArrayList<>();
    private String[] titles;

    public BaseFragmentAdapter(FragmentManager fm, List<T> fragmentList, String[] titles) {
        super(fm);
        this.fragmentList.clear();
        this.fragmentList.addAll(fragmentList);
        this.titles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null && titles.length > position) {
            return titles[position];
        }
        return "";
    }

    @Override
    public Fragment getItem(int position) {
      //  public final int ordinal()//返回枚举常量在枚举类型中的位置，第一个枚举值序号为0，依次类推；
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
