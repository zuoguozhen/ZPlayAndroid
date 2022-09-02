package com.zgz.zplayandroid.base;

import android.os.Bundle;
import android.view.View;

public abstract class SimpleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getBefore(savedInstanceState);
        setContentView(getRootView());

        initView();
        initData();
        initListenerAndEvent();


    }

    /**
     * 获取布局文件
     *
     * @return
     */
    protected abstract View getRootView();


    /**
     * 初始化Bundle
     *
     * @param savedInstanceState savedInstanceState
     */
    protected abstract void getBefore(Bundle savedInstanceState);

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化监听和事件
     */
    protected abstract void initListenerAndEvent();
}
