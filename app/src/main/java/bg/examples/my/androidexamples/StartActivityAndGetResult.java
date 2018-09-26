package bg.examples.my.androidexamples;
/*

 */


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivityAndGetResult extends AppCompatActivity {

    Button btnStartSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_and_get_result);

        btnStartSecond = (Button)findViewById(R.id.startactivitygetresult_btnStartChild);

        btnStartSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), StartActivityAndGetResultChild.class);
                startActivityForResult(i,1); // Activity is started with requestCode 1
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode) {
            case 2:
                String sMsg = getIntent().getStringExtra("MESSAGE");
                break;
        }
    }
}
