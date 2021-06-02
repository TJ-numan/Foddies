package com.tjnuman.foddies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {
    Animation topAnimation, bottomAnimation;
    LottieAnimationView animationView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        animationView = findViewById(R.id.animationView);
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.toptodown);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.downtotop);
        imageView = findViewById(R.id.image);
        imageView.setAnimation(bottomAnimation);
        animationView.setAnimation(topAnimation);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                animationView.playAnimation();
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        },5000);



    }
}