package com.zgz.zplayandroid.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author StormstoutChen
 * @project IZIVY
 * @date 2019/12/17
 * @time 17:47
 * @description
 **/
public abstract class BaseFragment extends SimpleFragment {

    private BasePresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inject();
        mPresenter = injectPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unBindView();
    }


    protected abstract void inject();

    /**
     * 将各子类的presenter传入基类统一管理
     *
     * @return
     */
    protected abstract BasePresenter injectPresenter();
}
