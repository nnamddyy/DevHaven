package com.example.nd.devhaven;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class web extends AppCompatActivity {

    ProgressDialog prDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);


        WebView wv = (WebView) findViewById(R.id.webview);
        WebSettings ws = wv.getSettings();
        ws.setBuiltInZoomControls(true);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new Callback());
        wv.loadUrl("http://www.twitter.com/okoronamdi");
    }

    private class Callback extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            prDialog = new ProgressDialog(web.this);
            prDialog.setMessage("Please wait ...");
            prDialog.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            prDialog.dismiss();
        }
    }
}

