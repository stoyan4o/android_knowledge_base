package bg.examples.my.androidexamples;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.webkit.WebView;

public class ScrollingMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        this.setTitle("CT to palace smoke");

        Display display = getWindowManager().getDefaultDisplay();
        int scrWidth = display.getWidth();
        int scrHeight = display.getHeight();
        int screenWidth = getResources().getDisplayMetrics().widthPixels-4;
        screenWidth = pxToDp(screenWidth);
        String text = "<html>" +
        "<head>Go to CT corner<br></head>" +
        "<body>" +
                "<img src=\"http://wssone.files.wordpress.com/2018/11/mirrage_ct_spawn_to_palace1.jpg\" width=\"" + screenWidth +"\" height=\"200\">" +
                "<br> " +
        "<i>Stand in CT</i>" +
                "<br>" +
                "<img src=\"https://wssone.files.wordpress.com/2018/11/mirrage_ct_spawn_to_palace2.jpg\" width=\"" + screenWidth +"\" height=\"200\">" +
                "<br>" +
                "<i>Aim here</i>" +
                "<br>" +
                "<img src=\"https://wssone.files.wordpress.com/2018/11/mirrage_ct_spawn_to_palace3.jpg\" width=\"" + screenWidth +"\" height=\"200\">" +
                "<br>" +
                "<i>Jump throw</i>" +
                "<br>" +
                "<img src=\"https://wssone.files.wordpress.com/2018/11/mirrage_ct_spawn_to_palace4.jpg\" width=\"" + screenWidth +"\" height=\"200\">" +
                "<br>" +
                "<i>Final result</i>" +
                "<br>" +
                "</body>" +
                "</html>";

        WebView wview = findViewById(R.id.webViewSmoke);
        wview.loadData(text,"text/html", "UTF-8");
    }

    public int pxToDp(int px) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }
}
