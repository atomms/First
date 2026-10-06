package com.eramiro.first

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/**
 * @author eramiro
 * trabajando en mejora de la animación
 */
class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        openApp()

        // implements and starts animation
        // objeto thunder sobre el cual aplicaremos la animación
        val thunder: ImageView? = findViewById(R.id.logosplash)

        // creamos un objeto animación que incorpora la animación descrita en el xml y con el método
        // startAnimation lo aplicamos al imageview del logo
        val myanim: Animation = AnimationUtils.loadAnimation(this, R.anim.shake)
        thunder?.startAnimation(myanim)

        // Glide for loading girls
        val mSea: ImageView? = findViewById(R.id.backView)

        mSea?.let {
            Glide.with(this)
                .load("https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80")
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(ColorDrawable(ContextCompat.getColor(this, R.color.teal_200)))
                .into(it)
        }
    }

    private fun openApp() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@Splash, Login::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
            startActivity(intent)
        }, 5000)
    }
}
