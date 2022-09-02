package com.zgz.zplayandroid.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zgz.zplayandroid.R
import com.zgz.zplayandroid.base.SimpleActivity
import com.zgz.zplayandroid.databinding.ActivityMainBinding
import com.zgz.zplayandroid.ui.home.HomeFragment

class MainActivity : SimpleActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun getRootView(): View = binding.root

    override fun getBefore(savedInstanceState: Bundle?) {
    }

    override fun initView() {
        val fragments = ArrayList<Fragment>()
        fragments.add(HomeFragment.newInstance())
        fragments.add(HomeFragment.newInstance())
        fragments.add(HomeFragment.newInstance())
        binding.vMainPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = fragments.size
            override fun createFragment(position: Int): Fragment = fragments[position]
        }
        binding.vMainPager.offscreenPageLimit = fragments.size
        binding.vMainPager.isUserInputEnabled = false
    }

    override fun initData() {
    }

    override fun initListenerAndEvent() {


        binding.vMainMenu.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.v_main_home -> binding.vMainPager.setCurrentItem(0, false)
                R.id.v_main_search -> binding.vMainPager.setCurrentItem(1, false)
                R.id.v_main_mine -> binding.vMainPager.setCurrentItem(2, false)
            }
        }
        binding.vMainMenu.check(R.id.v_main_home)
    }
}