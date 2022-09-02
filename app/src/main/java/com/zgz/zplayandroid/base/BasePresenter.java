package com.zgz.zplayandroid.base;

/**
 * @author StormstoutChen
 * @project IZIVY
 * @date 2019/12/13
 * @time 16:57
 * @description
 **/
public interface BasePresenter<V extends BaseView> {


    /**
     * 绑定view
     *
     * @param view view
     * @return
     */
    BasePresenter bindView(V view);


    /**
     * 取消绑定View
     */
    void unBindView();
}
