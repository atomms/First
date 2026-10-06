package com.eramiro.first

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * main class here
 */
class MainBab : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainbab)

        val bottomAppBar = findViewById<BottomAppBar>(R.id.bottom_app_bar)
        val myfab = findViewById<FloatingActionButton>(R.id.fab)

        myfab?.setOnClickListener {
            Toast.makeText(this@MainBab, "FAB Clicked", Toast.LENGTH_SHORT).show()
        }

        bottomAppBar?.setNavigationOnClickListener {
            showBottomSheetDialog()
        }

        bottomAppBar?.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.heart -> {
                    Toast.makeText(this@MainBab, "Added to favourites", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this@MainBab, "Beginning search", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    private fun showBottomSheetDialog() {
        val view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_layout, null)

        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()

        val option1 = view.findViewById<TextView>(R.id.option1)
        val option2 = view.findViewById<TextView>(R.id.option2)
        val option3 = view.findViewById<TextView>(R.id.option3)

        option1?.setOnClickListener {
            Toast.makeText(this@MainBab, "Settings clicked", Toast.LENGTH_SHORT).show()
            bottomSheetDialog.dismiss()
        }

        option2?.setOnClickListener {
            Toast.makeText(this@MainBab, "About clicked", Toast.LENGTH_SHORT).show()
            bottomSheetDialog.dismiss()
        }

        option3?.setOnClickListener {
            Toast.makeText(this@MainBab, "Logout clicked", Toast.LENGTH_SHORT).show()
            bottomSheetDialog.dismiss()
        }
    }
}
