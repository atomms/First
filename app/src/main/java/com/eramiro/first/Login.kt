package com.eramiro.first;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
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
//        ImageView mLogo = findViewById(R.id.logo);


//      Intenta varias cargas hasta que la imagen se muestre
//        loadImage(mGirl,"https://images.unsplash.com/photo-1489424731084-a5d8b219a5bb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80", 2, 0);

        Glide.with(this)
                .load("https://images.unsplash.com/photo-1489424731084-a5d8b219a5bb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1974&q=80")
//              .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .centerCrop()
//                .circleCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .into(mGirl);
//
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

//    public static void loadImageWithRetry(ImageView imageView, String imageUrl, int maxRetries) {
//        loadImage(imageView, imageUrl, maxRetries, 0);
//    }
//
//    private static void loadImage(ImageView imageView, String imageUrl, int maxRetries, int currentRetry) {
//        Glide.with(imageView.getContext())
//                .load(imageUrl)
//                .listener(new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                        if (currentRetry < maxRetries) {
//                            // Reintentar después de un retraso
//                            new Handler().postDelayed(() -> {
//                                loadImage(imageView, imageUrl, maxRetries, currentRetry + 1);
//                            }, 2000); // 2 segundos de retraso
//                        } else {
//                            // Mostrar una imagen de error después de alcanzar el límite de reintentos
//                            imageView.setImageResource(R.drawable.error_image); // Cambia por tu imagen de error
//                        }
//                        return true; // Indica que manejamos el error
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, com.bumptech.glide.load.DataSource dataSource, boolean isFirstResource) {
//                        // La imagen se cargó correctamente
//                        return false; // Glide continúa con su comportamiento predeterminado
//                    }
//                })
//                .into(imageView);
//    }
}




