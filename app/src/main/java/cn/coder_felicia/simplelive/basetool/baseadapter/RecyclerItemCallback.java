package cn.coder_felicia.simplelive.basetool.baseadapter;

/**
 * 项目名：  SimpleLive
 * 包名：    cn.coder_felicia.simplelive.basetool.baseadapter
 * 文件名:
 * 创建者:   涵月felicia
 * 创建时间:  2017/3/31
 * 描述：
 */

public abstract class RecyclerItemCallback<T, F> {
    /**
     * 单击事件
     *
     * @param position 位置
     * @param model    实体
     * @param tag      标签
     * @param holder   控件
     */
    public void onItemClick(int position, T model, int tag, F holder) {
    }

    /**
     * 长按事件
     *
     * @param position 位置
     * @param model    实体
     * @param tag      标签
     * @param holder   控件
     */
    public void onItemLongClick(int position, T model, int tag, F holder) {
    }
}
