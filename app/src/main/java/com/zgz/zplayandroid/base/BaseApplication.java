package com.zgz.zplayandroid.base;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.zgz.zplayandroid.base.di.component.ApplicationComponent;
import com.zgz.zplayandroid.base.di.component.DaggerApplicationComponent;
import com.zgz.zplayandroid.base.di.module.ApplicationModule;

/**
 * @author StormstoutChen
 * @project IZIVY
 * @date 2019/12/17
 * @time 14:33
 * @description
 **/
public class BaseApplication extends MultiDexApplication {
    private static BaseApplication application;
    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    /**
     * 获取applicationComponent
     *
     * @return ApplicationComponent
     */
    public static ApplicationComponent getApplicationComponent() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(application))
                    .build();
        }
        return applicationComponent;
    }
}
