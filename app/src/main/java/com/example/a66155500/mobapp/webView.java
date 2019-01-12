package com.example.a66155500.mobapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class webView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        final Button btn = (Button) findViewById(R.id.web_view_button);
        final WebView wv = (WebView) findViewById(R.id.web_view);

        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView wv, WebResourceRequest r) {
                wv.loadUrl(r.getUrl().toString());
                return true;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv.loadUrl("file:///android_assets/Magic8Ball.html");
                btn.setVisibility(View.INVISIBLE);
                /*String htmlString =
                "<html><body><h1>Magic!</h1><img src='magic8_gray.png'/></body></html>";
                wv.loadDataWithBaseURL("file:///android_asset/",
                        htmlString,    // Data-String
                "text/html",   // Mime-Type
                null,          // Encoding, Standard UTF-8
                null           // History URL
                );*/
            }
        });

        wv.getSettings().setJavaScriptEnabled(true);
    }
}
