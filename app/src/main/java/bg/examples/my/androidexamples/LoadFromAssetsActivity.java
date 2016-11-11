package bg.examples.my.androidexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LoadFromAssetsActivity extends AppCompatActivity {

    String TAG = "demo";

    Button btnMap1;
    Button btnmap2;
    TextView textOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_from_assets);

        btnMap1 = (Button)findViewById(R.id.LoadFromAssets_btnLoadMap1);
        btnmap2 = (Button)findViewById(R.id.LoadFromAssets_btnLoadMap2);
        textOutput = (TextView)findViewById(R.id.LoadFromAssets_textOutput);

        btnMap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadMap("files/file1.txt");
            }
        });

        btnmap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadMap("files/file2.txt");
            }
        });
    }

    private void LoadMap(String fileName) {
        textOutput.setText("");

        BufferedReader reader = null;
        InputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try{
            inputStream = getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while((line = reader.readLine()) != null)
            {
                Log.i(TAG, line);
                builder.append(line);
                builder.append("\n");
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        } finally {

            if(inputStream != null)
            {
                try {
                    inputStream.close();
                } catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }

            if(reader != null)
            {
                try {
                    reader.close();
                } catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        }
        Log.i(TAG, "builder.toString(): " + builder.toString());

        textOutput.setText(builder.toString());

    }
}
