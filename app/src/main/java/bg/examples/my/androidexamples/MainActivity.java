package bg.examples.my.androidexamples;
/*

 */

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnPop;
    Button btnTOuchDemo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context context = getApplicationContext();
        String language_code = "bg";

        Resources res = context.getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = new Locale(language_code.toLowerCase());
        res.updateConfiguration(conf, dm);

        setContentView(R.layout.activity_main);

        // Touch
        btnTOuchDemo = (Button) findViewById(R.id.MainMenu_btnTouchDemo);

        btnTOuchDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TouchActivity.class));
            }
        });

        // Load From Assets
        findViewById(R.id.MainMenu_btnLoadFromAssets).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoadFromAssetsActivity.class));
            }
        });



        //
        findViewById(R.id.btnLoadSaveFromFile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoadSaveFile.class));
            }
        });

        // SelfCall
        findViewById(R.id.btn_self_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SelfCallActivity.class));
            }
        });
        //
        findViewById(R.id.btn_scrollview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ScrollingMapActivity.class));
            }
        });

        findViewById(R.id.btn_show_more_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ShowMoreTextViewActivity.class));
            }
        });
    }


}
