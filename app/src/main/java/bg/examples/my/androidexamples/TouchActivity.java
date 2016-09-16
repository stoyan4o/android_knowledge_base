package bg.examples.my.androidexamples;

import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TouchActivity extends AppCompatActivity  {

    TextView txtLabel;
    ImageView imgView;

    PointF joypadZeroPos;
    PointF joypadCurrentPos;
    boolean isDragging = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        joypadZeroPos = new PointF(200,200);
        joypadCurrentPos = new PointF(200,200);

        txtLabel = (TextView)findViewById(R.id.textView2);

        imgView = (ImageView)findViewById(R.id.imageView);
        imgView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        isDragging = true;
                        joypadCurrentPos.set(event.getX(), event.getY());
                        break;
                    case MotionEvent.ACTION_UP:
                        isDragging = false;
                        joypadCurrentPos.set(joypadZeroPos.x, joypadZeroPos.y);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        isDragging = true;
                        joypadCurrentPos.set(event.getX(), event.getY());
                        break;
                }
                String m = String.valueOf(Math.round(joypadCurrentPos.x - joypadZeroPos.x));
                m +=", ";
                m += String.valueOf(Math.round(joypadCurrentPos.y - joypadZeroPos.y));

                txtLabel.setText(m);
                return true;
            }
        });
    }





}
