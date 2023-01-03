package com.guy.class23a_and_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class Activity_Splash extends AppCompatActivity {

    private AppCompatImageView splash_IMG_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splash_IMG_logo = findViewById(R.id.splash_IMG_logo);

        startAnimation(splash_IMG_logo);

    }

    private void startAnimation(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        view.setY(-height / 2);

        view.setScaleX(0.0f);
        view.setScaleY(0.0f);
        view.setAlpha(0.0f);

        view.animate()
                .scaleY(1.0f)
                .scaleX(1.0f)
                .alpha(1.0f)
                .translationY(0)
                .setDuration(4000)
                //.setInterpolator(new LinearOutSlowInInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        startApp();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

    private void startApp() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}