package com.zgz.zplayandroid.base.di.module;


import android.app.Activity;

import androidx.fragment.app.Fragment;

import com.zgz.zplayandroid.base.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    private Fragment mFragment;


    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }


    @Provides
    @FragmentScope
    public Fragment provideFragment() {
        return mFragment;
    }


    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return mFragment.getActivity();
    }

}
