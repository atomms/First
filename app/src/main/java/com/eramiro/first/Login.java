package com.eramiro.first;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.eramiro.first.R;

/**
 * This is the login
 * @author eramiro
 */

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //implements and starts animation
        // objeto thunder sobre el cual aplicaremos la animación
        ImageView logo = findViewById(R.id.logo);

        //creamos un objeto animación que incorpora la animación descrita en el xml y con el método
        // startAnimation lo aplicamos al imageview del logo
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        logo.startAnimation(myanim);


//    Glide for loading girls
        ImageView mGirl = findViewById(R.id.girl);
        ImageView mLogo = findViewById(R.id.logo);

        Glide.with(this)
              .load(R.drawable.girl)
//                .transition(DrawableTransitionOptions.withCrossFade(2000))
//                .centerCrop()
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .into(mGirl);

//        Glide.with(this)
//                .load("https://images.unsplash.com/photo-1489424731084-a5d8b219a5bb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80")
//                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
//                .circleCrop()
//                .into(mLogo);

    }




    // Method for Login button
    public void openMain(View v) {
        Intent intent = new Intent(Login.this, Main.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    // Method for Signup button
    public void openSignup(View v) {
        Intent intent = new Intent(Login.this, Signup.class);
        startActivity(intent);
    }

}

