package com.eramiro.first.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.eramiro.first.fragments.Page1
import com.eramiro.first.fragments.Page2
import com.eramiro.first.fragments.Page3
import com.eramiro.first.fragments.Page4

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(
    private val mContext: Context,
    fm: FragmentManager
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Page1()
            1 -> Page2()
            2 -> Page3()
            3 -> Page4()
            else -> Page1()
        }
    }

    override fun getCount(): Int {
        return 4
    }
}
