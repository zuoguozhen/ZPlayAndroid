package com.zgz.zplayandroid.ui.home

import com.zgz.zplayandroid.base.RxPresenter
import com.zgz.zplayandroid.base.network.RetrofitHelper
import com.zgz.zplayandroid.ui.home.HomeContract
import javax.inject.Inject

/**
 * @author       zuoguozhen
 * @date         2021/5/7 10:42
 * @description
 **/
class HomePresenter @Inject constructor() : RxPresenter<HomeContract.View>(), HomeContract.Presenter {
    @Inject
    lateinit var retrofitHelper: RetrofitHelper

}