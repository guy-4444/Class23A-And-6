package com.guy.class23a_and_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class Activity_lottie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);

        LottieAnimationView lottie = findViewById(R.id.animation_view);
        lottie.resumeAnimation();
    }
}