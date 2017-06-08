package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

/**
 * Created by cors on 06/06/17.
 */

public class DiagnosticoListView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diagnostico_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //navegaçao da barra inferior
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.listarArquivos_btNavigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(false);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.menu_listar_Consultas:
                        Intent it1 = new Intent(DiagnosticoListView.this,ConsultaListView.class);
                        startActivity(it1);
                        break;

                    case R.id.menu_listar_Diagnostico:

                        break;
                }
                return false;
            }
        });



        //Lista mostrando diagnosticos
        ExpandableListView activity_diagnostico_listView = (ExpandableListView) findViewById(R.id.view_listarDiagnostico);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
