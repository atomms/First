package com.eramiro.first

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/**
 * This is the login
 * @author eramiro
 */
class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val logo = findViewById<ImageView>(R.id.logo)
        val myanim = AnimationUtils.loadAnimation(this, R.anim.fadein)
        logo?.startAnimation(myanim)

        val mGirl = findViewById<ImageView>(R.id.girl)
        mGirl?.let {
            Glide.with(this)
                .load("https://images.unsplash.com/photo-1489424731084-a5d8b219a5bb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80")
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .centerCrop()
                .placeholder(ColorDrawable(ContextCompat.getColor(this, R.color.teal_200)))
                .into(it)
        }
    }

    // Method for Login button (referenced in XML android:onClick)
    fun openMain(v: View) {
        val intent = Intent(this@Login, Main::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        startActivity(intent)
    }

    // Method for Signup button (referenced in XML android:onClick)
    fun openSignup(v: View) {
        val intent = Intent(this@Login, Signup::class.java)
        startActivity(intent)
    }
}
