package bg.examples.my.androidexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class StartActivityAndGetResultChild extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_and_get_result_child);
        findViewById(R.id.startactivitygetresultchild_btnClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = ((EditText)findViewById(R.id.editText)).getText().toString();
                Intent intent = new Intent();
                intent.putExtra("MESSAGE",message);
                setResult(2, intent);
                finish(); // finishing activity
            }
        });
    }
}
