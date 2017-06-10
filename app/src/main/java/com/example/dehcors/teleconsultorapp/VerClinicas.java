package com.example.dehcors.teleconsultorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class VerClinicas extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_clinicas);

        WebView wv = (WebView) findViewById(R.id.rota_webView);
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);

        //acessar url
        wv.loadUrl("https://smsrio.org/subpav/ondeseratendido/");
    }
}




