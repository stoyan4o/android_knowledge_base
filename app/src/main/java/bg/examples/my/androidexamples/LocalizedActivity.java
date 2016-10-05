package bg.examples.my.androidexamples;
/*
This activity demostrates how to start single activity with different localization resources.
On the onCreateMethod the activity must call updateConfiguration before calling setContentView(...)

Localized String should be placed in values/strings.xml
english files should be in values-en folder,
bulgarian files should be in values-bg folder

values folder holds the default localization strings.
 */
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import java.util.Locale;

public class LocalizedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This code must be before setContentView()
        Context context = getApplicationContext();
        String language_code = "bg";

        Resources res = context.getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.locale = new Locale(language_code.toLowerCase());
        res.updateConfiguration(conf, dm);

        setContentView(R.layout.activity_localized);
    }
}
