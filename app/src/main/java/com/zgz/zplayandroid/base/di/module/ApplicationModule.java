package com.zgz.zplayandroid.base.di.module;

import com.zgz.zplayandroid.base.BaseApplication;
import com.zgz.zplayandroid.base.network.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author zuoguozhen
 * @date 2020/9/14 14:51
 * @description
 **/
@Module
public class ApplicationModule {
    private BaseApplication mBaseApplication;

    public ApplicationModule(BaseApplication baseApplication) {
        this.mBaseApplication = baseApplication;
    }

    @Provides
    @Singleton
    BaseApplication provideApplication() {
        return this.mBaseApplication;
    }

    @Provides
    @Singleton
    RetrofitHelper provideRetrofitHelper() {
        return new RetrofitHelper();
    }
}
