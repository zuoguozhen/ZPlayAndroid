package com.zgz.zplayandroid.base.di.component;

import com.zgz.zplayandroid.base.BaseApplication;
import com.zgz.zplayandroid.base.di.module.ApplicationModule;
import com.zgz.zplayandroid.base.network.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author zuoguozhen
 * @date 2020/9/14 14:51
 * @description
 **/
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    BaseApplication getApplication();

    RetrofitHelper getRetrofitHelper();
}
