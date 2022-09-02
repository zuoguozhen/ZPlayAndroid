package com.zgz.zplayandroid.base.di.module;

import android.app.Activity;

import com.zgz.zplayandroid.base.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }


   @Provides
   @ActivityScope
   Activity provideActivity(){
        return mActivity;
   }

}
