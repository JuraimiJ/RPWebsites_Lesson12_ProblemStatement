package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Website extends AppCompatActivity {

    WebView wvSites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.website);

        wvSites = findViewById(R.id.webViewPage);


        Intent intentReceived = getIntent();
        String website = intentReceived.getStringExtra("Website");
        wvSites.loadUrl(website);

    }
}
