package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class RotaActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.rota_menu_home:
                    //permanecer nesta activity
                    break;
                case R.id.rota_menu_programar:
                    Intent itMap = new Intent(RotaActivity.this, MapsActivity.class);
                    startActivity(itMap);
                    break;
                case R.id.rota_menu_alertas:

                    break;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rota);


        BottomNavigationView rotaMenu = (BottomNavigationView) findViewById(R.id.rotaMenu);
        rotaMenu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
   }

}
