package bg.examples.my.androidexamples;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.PointF;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnPop;
    Button btnTOuchDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPop = (Button)findViewById(R.id.buttonPop);

        btnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PopupActicity.class));
            }
        });
        btnTOuchDemo = (Button)findViewById(R.id.btnTouchDemo);

        btnTOuchDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TouchActivity.class));
            }
        });
    }


}
