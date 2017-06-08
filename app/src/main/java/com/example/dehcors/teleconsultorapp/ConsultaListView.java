package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by cors on 06/06/17.
 */

public class ConsultaListView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //navegaçao da barra inferior
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.listarArquivos_btNavigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(false);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_listar_Consultas:

                        break;

                    case R.id.menu_listar_Diagnostico:
                        Intent it2 =new Intent(ConsultaListView.this, DiagnosticoListView.class);
                        startActivity(it2);
                        break;
                }
                return false;
            }
        });

        //Lista mostrando consultas
        ExpandableListView activity_consulta_list_view = (ExpandableListView) findViewById(R.id.view_listarConsultas);



       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



}
