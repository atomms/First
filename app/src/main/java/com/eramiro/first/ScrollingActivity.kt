package com.eramiro.first

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eramiro.first.databinding.ActivityScrollingBinding
import com.google.android.material.snackbar.Snackbar

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        val toolBarLayout = binding.toolbarLayout
        toolBarLayout.title = title

        val fab = binding.fab
        fab?.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}
