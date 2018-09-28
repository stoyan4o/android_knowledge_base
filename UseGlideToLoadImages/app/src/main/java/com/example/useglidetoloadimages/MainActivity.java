package com.example.useglidetoloadimages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivBall = findViewById(R.id.imageView);

        Glide.with(this)
                .load(R.drawable.basketball)
                .into(ivBall);
    }
}
