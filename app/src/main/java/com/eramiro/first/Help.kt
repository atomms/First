package com.eramiro.first

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.eramiro.first.databinding.ActivityHelpBinding
import com.eramiro.first.ui.main.HelpSectionsPagerAdapter

class Help : AppCompatActivity() {

    private lateinit var binding: ActivityHelpBinding
    private lateinit var helpSectionsPagerAdapter: HelpSectionsPagerAdapter
    private val prevStarted = "yes"

    override fun onResume() {
        super.onResume()
        val sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            val editor = sharedpreferences.edit()
            editor.putBoolean(prevStarted, true)
            editor.apply()
        } else {
            moveToSecondary()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        helpSectionsPagerAdapter = HelpSectionsPagerAdapter(this, supportFragmentManager)
        val viewPager2: ViewPager = findViewById(R.id.view_hpager)
        viewPager2.adapter = helpSectionsPagerAdapter
    }

    fun moveToSecondary() {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
}
