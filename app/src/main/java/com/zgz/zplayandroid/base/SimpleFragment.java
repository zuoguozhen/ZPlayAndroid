package com.zgz.zplayandroid.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author StormstoutChen
 * @project IZIVY
 * @date 2019/12/13
 * @time 18:17
 * @description
 **/
public abstract class SimpleFragment extends Fragment {

    public Context mContext;
    protected View mView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), null, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getBefore(savedInstanceState);
        initView();
        initData();
        initListenerAndEvent();

    }

    /**
     * 初始化Bundle
     *
     * @param savedInstanceState savedInstanceState
     */
    protected abstract void getBefore(Bundle savedInstanceState);

    /**
     * 获取布局文件
     *
     * @return 布局ResId
     */
    protected abstract int getLayoutId();


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
