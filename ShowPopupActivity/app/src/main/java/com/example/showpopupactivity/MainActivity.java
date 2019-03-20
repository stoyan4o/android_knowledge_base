package com.example.showpopupactivity;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    NotificationHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new NotificationHelper(this);

    if (NotificationHelper.PrizmaCase == 1)
    {

    }
        findViewById(R.id.btn_popup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startActivity(new Intent(MainActivity.this, PopupActivity.class));
                String title = "Bonanza";
                String message = "wooop";
                Notification.Builder builder = helper.getChannelNotification(title, message);
                helper.getManager().notify(new Random().nextInt(), builder.build());
            }
        });
    }
}
