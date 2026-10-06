package com.eramiro.first.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.eramiro.first.fragments.HPage1
import com.eramiro.first.fragments.HPage2
import com.eramiro.first.fragments.HPage3

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class HelpSectionsPagerAdapter(
    private val mContext: Context,
    fm: FragmentManager
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HPage1()
            1 -> HPage2()
            2 -> HPage3()
            else -> HPage1()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}
