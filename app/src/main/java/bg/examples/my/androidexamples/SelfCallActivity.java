package bg.examples.my.androidexamples;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SelfCallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_call);

        int old = getIntent().getIntExtra("num",0);
        ((EditText)findViewById(R.id.editValue)).setText(String.valueOf(old));

        findViewById(R.id.btn_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String val = ((EditText)findViewById(R.id.editValue)).getText().toString();
                int number = Integer.parseInt(val);
                number++;
                ((Activity)view.getContext()).finish();
                Intent i = new Intent(view.getContext(), SelfCallActivity.class);
                i.putExtra("num", number);
                startActivity(i);
            }
        });
    }
}
