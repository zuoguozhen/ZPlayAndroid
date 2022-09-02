package com.zgz.zplayandroid.base.di.component;

import android.app.Activity;

import com.zgz.zplayandroid.base.di.module.ActivityModule;
import com.zgz.zplayandroid.base.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    /**
     * 获取Activity
     *
     * @return Activity
     */
    Activity getActivity();


}
