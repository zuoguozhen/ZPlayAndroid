package com.zgz.zplayandroid.ui.home

import android.os.Bundle
import com.zgz.zplayandroid.R
import com.zgz.zplayandroid.base.BaseFragment
import com.zgz.zplayandroid.base.BasePresenter
import com.zgz.zplayandroid.base.di.helper.DaggerHelper
import javax.inject.Inject

/**
 * @author       zuoguozhen
 * @date         2021/5/7 10:42
 * @description
 **/
class HomeFragment : BaseFragment(), HomeContract.View {

    @Inject
    lateinit var mPresenter: HomePresenter

    companion object {
        fun newInstance(): HomeFragment {
            val args = Bundle()

            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getBefore(p0: Bundle?) {

    }

    override fun getLayoutId(): Int = R.layout.home_fragment

    override fun initView() {
    }


    override fun initData() {
    }


    override fun initListenerAndEvent() {

    }

    override fun inject() {
        DaggerHelper.getFragmentComponent(this).inject(this)
    }

    override fun injectPresenter(): BasePresenter<*> = mPresenter.bindView(this)
}