package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @author eramiro
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
//    ImageView mForest = findViewById(R.id.backforest);
//
////    New Glide
//        Glide.with(this)
//                .load(R.drawable.mforest)
//                .centerCrop()
//                .transition(DrawableTransitionOptions.withCrossFade(500))
//            .placeholder(new ColorDrawable(this.getResources().getColor(R.color.light_purple_button)))
////                .circleCrop()
////                .diskCacheStrategy(DiskCacheStrategy.NONE)
//            .into(mForest);



    public void onClick(View v){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

