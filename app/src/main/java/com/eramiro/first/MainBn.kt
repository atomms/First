@file:Suppress("RestrictedApi")

package com.eramiro.first

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.eramiro.first.ui.main.SectionsPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

/**
 * gradle update
 */
@SuppressLint("RestrictedApi")
class MainBn : AppCompatActivity() {

    private lateinit var sectionsPagerAdapter: SectionsPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_bn)

        sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager1 = findViewById<ViewPager>(R.id.view_pager)
        viewPager1.adapter = sectionsPagerAdapter

        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        dotsIndicator.attachTo(viewPager1)

        val mybottomNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val bottomNavigationMenuView = mybottomNavView.getChildAt(0) as BottomNavigationMenuView
        val v = bottomNavigationMenuView.getChildAt(2)
        val itemView = v as BottomNavigationItemView

        LayoutInflater.from(this).inflate(R.layout.layout_badge, itemView, true)

        @Suppress("DEPRECATION")
        mybottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.likes -> {
                    item.isChecked = true
                    Toast.makeText(this@MainBn, "Likes clicked.", Toast.LENGTH_SHORT).show()
                    removeBadge(mybottomNavView, item.itemId)
                    viewPager1.currentItem = 0
                    true
                }
                R.id.add -> {
                    item.isChecked = true
                    Toast.makeText(this@MainBn, "Add clicked.", Toast.LENGTH_SHORT).show()
                    removeBadge(mybottomNavView, item.itemId)
                    viewPager1.currentItem = 1
                    true
                }
                R.id.browse -> {
                    item.isChecked = true
                    Toast.makeText(this@MainBn, "Browse clicked.", Toast.LENGTH_SHORT).show()
                    removeBadge(mybottomNavView, item.itemId)
                    viewPager1.currentItem = 2
                    true
                }
                R.id.personal -> {
                    item.isChecked = true
                    Toast.makeText(this@MainBn, "Personal clicked.", Toast.LENGTH_SHORT).show()
                    removeBadge(mybottomNavView, item.itemId)
                    viewPager1.currentItem = 3
                    true
                }
                else -> false
            }
        }

        viewPager1.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                mybottomNavView.menu.getItem(position).isChecked = true
                removeBadge(mybottomNavView, mybottomNavView.menu.getItem(position).itemId)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }

    companion object {
        /**
         * Remove badge.
         *
         * @param bottomNavigationView the bottom navigation view
         * @param itemId               the item id
         */
        @JvmStatic
        @SuppressLint("RestrictedApi")
        fun removeBadge(bottomNavigationView: BottomNavigationView, @IdRes itemId: Int) {
            val itemView = bottomNavigationView.findViewById<BottomNavigationItemView>(itemId)
            itemView?.let {
                if (it.childCount == 3) {
                    it.removeViewAt(2)
                }
            }
        }
    }
}
