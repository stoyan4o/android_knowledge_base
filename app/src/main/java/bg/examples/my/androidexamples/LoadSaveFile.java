package bg.examples.my.androidexamples;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LoadSaveFile extends AppCompatActivity {

    Button btnLoad;
    Button btnSave;

    EditText txtScore;
    EditText txtLoadedText;

    String fileName = "saves.txt";

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadsavefromfile);

        btnLoad = (Button)findViewById(R.id.btnLoad);
        btnSave = (Button)findViewById(R.id.btnSave);

        txtScore = (EditText)findViewById(R.id.editScore);
        txtLoadedText = (EditText)findViewById(R.id.edtLoadedText);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // LoadDataFromFile();
                readHighScore();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveFile();
            }
        });

        context = getApplicationContext();
    }

    private String LoadDataFromFile() {
        if (context == null) {
            return null;
        }

        String sResult = "";
        final File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/folderName/" );

        if (!dir.exists())
        {
            if(!dir.mkdirs()){
                Log.e("ALERT","Could not create the directories");
            }
        }
        final File myFile = new File(dir, fileName + ".txt");

        String fileName = myFile.getAbsoluteFile().getPath();
        try {
            InputStream inputStream = context.openFileInput(fileName);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int size = inputStream.available();
                char[] buffer = new char[size];

                inputStreamReader.read(buffer);

                inputStream.close();
                sResult = new String(buffer);
                // txtLoadedText.setText(sResult);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return sResult;

    }

    private void SaveFile() {
        FileOutputStream fos = null;
        try {
            final File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/folderName/" );

            if (!dir.exists())
            {
                if(!dir.mkdirs()){
                    Log.e("ALERT","could not create the directories");
                }
            }

            final File myFile = new File(dir, fileName + ".txt");

            if (!myFile.exists())
            {
                myFile.createNewFile();
            }

            fos = new FileOutputStream(myFile);

            fos.write(txtScore.getText().toString().getBytes());

            fos.close();
            Toast.makeText(getBaseContext(),
                    "Done writing SD 'mysdfile.txt'",
                    Toast.LENGTH_SHORT).show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int readHighScore() {
        final File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/folderName/" );
        int highScore = 0;
        if (!dir.exists())
        {
            if(!dir.mkdirs()){
                Log.e("ALERT","could not create the directories");
            }
        }
        final File myFile = new File(dir, fileName + ".txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(myFile));
            try {
                highScore = Integer.parseInt(br.readLine());
                br.close();
            } catch (NumberFormatException | IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            try {
                myFile.createNewFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            e.printStackTrace();
        }
        txtLoadedText.setText(String.valueOf(highScore));
        return highScore;
    }
}
