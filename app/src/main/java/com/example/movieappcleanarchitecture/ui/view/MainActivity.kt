package com.example.movieappcleanarchitecture.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movieappcleanarchitecture.databinding.ActivityMainBinding
import com.example.movieappcleanarchitecture.ui.adapters.AdapterTabLayout
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Popular"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Favorites"))

        val adapter = AdapterTabLayout(this, supportFragmentManager, binding.tabLayout.tabCount)
        binding.viewPager.adapter = adapter

        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
    }
}