package com.eramiro.first

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

/**
 * This is the Signup
 * transformed into a calendar
 * @author ernesto
 * @see Login
 */
class Signup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

    // Method for Signup button
    fun openLogin(v: View?) {
        val intent = Intent(this@Signup, Login::class.java)
        startActivity(intent)
    }

    // Method for Signup button
    fun openMain(v: View?) {
        val intent = Intent(this@Signup, Main::class.java)
        startActivity(intent)
    }
}
