package com.eramiro.first

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

/**
 * This is the Signup
 * transformed into a calendar
 * @author ernesto
 * @see Login
 */
class Date : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        val dateView = findViewById<TextView>(R.id.mydate)
        dateView?.let { setDate(it) }
    }

    fun setDate(view: TextView) {
        val today = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd/MM/yy", Locale.getDefault())
        val date = formatter.format(today)
        view.text = date
    }
}
