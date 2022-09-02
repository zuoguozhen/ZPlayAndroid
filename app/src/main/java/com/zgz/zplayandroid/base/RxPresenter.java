package com.zgz.zplayandroid.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author StormstoutChen
 * @project IZIVY
 * @date 2019/12/17
 * @time 15:50
 * @description
 **/
public class RxPresenter<V extends BaseView> implements BasePresenter<V> {

    protected V mView;
    private CompositeDisposable mCompositeDisposable;


    /**
     * 添加订阅者进行管理
     *
     * @param subscription 订阅者
     */
    protected void addSubscribe(Disposable subscription) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }


    @Override
    public BasePresenter bindView(V view) {
        this.mView = view;
        return this;
    }

    @Override
    public void unBindView() {
        unSubscribe();
    }


    /**
     * 取消订阅
     */
    private void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }
}
