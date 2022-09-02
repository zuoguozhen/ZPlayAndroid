package com.zgz.zplayandroid.base.di.component;


import androidx.fragment.app.Fragment;


import com.zgz.zplayandroid.base.di.module.FragmentModule;
import com.zgz.zplayandroid.base.di.scope.FragmentScope;
import com.zgz.zplayandroid.ui.home.HomeFragment;

import org.jetbrains.annotations.NotNull;

import dagger.Component;

@FragmentScope
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    /**
     * 获取Fragment
     *
     * @return Fragment
     */
    Fragment getFragment();

    void inject(@NotNull HomeFragment homeFragment);

//    void inject(@NotNull LoginFragment fragment);

}
