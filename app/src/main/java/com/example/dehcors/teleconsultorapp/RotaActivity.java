package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class RotaActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.rota_menu_home:

                    break;
                case R.id.rota_menu_programar:
                    Intent itMap = new Intent(RotaActivity.this, MapsActivity.class);
                    startActivity(itMap);
                    break;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rota);

        WebView wv = (WebView)findViewById(R.id.rota_webView);
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);

        //acessar url
        wv.loadUrl("https://smsrio.org/subpav/ondeseratendido/");

        BottomNavigationView rotaMenu = (BottomNavigationView) findViewById(R.id.rotaMenu);
        rotaMenu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



        }
   }




