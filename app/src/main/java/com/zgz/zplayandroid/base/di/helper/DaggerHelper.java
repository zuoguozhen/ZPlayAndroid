package com.zgz.zplayandroid.base.di.helper;


import android.app.Activity;

import androidx.fragment.app.Fragment;

import com.zgz.zplayandroid.base.BaseApplication;
import com.zgz.zplayandroid.base.di.component.ActivityComponent;
import com.zgz.zplayandroid.base.di.component.DaggerActivityComponent;
import com.zgz.zplayandroid.base.di.component.DaggerFragmentComponent;
import com.zgz.zplayandroid.base.di.component.FragmentComponent;
import com.zgz.zplayandroid.base.di.module.ActivityModule;
import com.zgz.zplayandroid.base.di.module.FragmentModule;

public class DaggerHelper {

    /**
     * 获取FragmentComponent
     *
     * @param fragment fragment
     * @return FragmentComponent
     */
    public static FragmentComponent getFragmentComponent(Fragment fragment) {
        return DaggerFragmentComponent.builder()
                .applicationComponent(BaseApplication.getApplicationComponent())
                .fragmentModule(new FragmentModule(fragment))
                .build();
    }

    /**
     * 获取ActivityComponent
     *
     * @param activity activity
     * @return ActivityComponent
     */
    public static ActivityComponent getActivityComponent(Activity activity) {
        return DaggerActivityComponent.builder()
                .applicationComponent(BaseApplication.getApplicationComponent())
                .activityModule(new ActivityModule(activity))
                .build();

    }
}
