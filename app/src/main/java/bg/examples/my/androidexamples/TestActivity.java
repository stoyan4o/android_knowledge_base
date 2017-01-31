package bg.examples.my.androidexamples;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class TestActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "CL_FireworksActivity";
    MySurfaceView mySurfaceView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_test);

            findViewById(R.id.btnStart).setOnClickListener(this);
            findViewById(R.id.btnStop).setOnClickListener(this);

            mySurfaceView = (MySurfaceView) (findViewById(R.id.surfaceView1));
        } catch (Exception e) {
            Log.d(TAG, "Failed to create; " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                try {
                    mySurfaceView.startThread();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            case R.id.btnStop:
                mySurfaceView.stopThread();
                break;
        }
    }
}
