package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by cors on 07/06/17.
 */

public class ArquivosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arquivos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //navegaçao da barra inferior
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.listarArquivos_btNavigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(false);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.menu_listar_Consultas:
                        Intent it1 = new Intent(ArquivosActivity.this, ConsultaListView.class);
                        startActivity(it1);
                        break;

                    case R.id.menu_listar_Diagnostico:
                        Intent it2 = new Intent(ArquivosActivity.this, DiagnosticoListView.class);
                        startActivity(it2);
                        break;
                }
                return false;
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
