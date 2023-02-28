package com.example.movieappcleanarchitecture.ui.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.movieappcleanarchitecture.ui.view.FavoritesFragment
import com.example.movieappcleanarchitecture.ui.view.PopularFragment

internal class AdapterTabLayout(var context: Context, fm: FragmentManager, var totalTabs:Int):
    FragmentPagerAdapter(fm) {


    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                PopularFragment()
            }
            1 ->{
                FavoritesFragment()
            }
            else -> getItem(position)
        }
    }
}