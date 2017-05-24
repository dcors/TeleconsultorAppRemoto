package com.example.dehcors.teleconsultorapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class RotaActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.rota_menu_home:
                    mTextMessage.setText(R.string.title_home_rota);
                    return true;
                case R.id.rota_menu_dashboard:
                    mTextMessage.setText(R.string.title_dashboard_rota);
                    return true;
                case R.id.rota_menu_alertas:
                    mTextMessage.setText(R.string.title_notifications_rota);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rota);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView rotaMenu = (BottomNavigationView) findViewById(R.id.rotaMenu);
        rotaMenu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
