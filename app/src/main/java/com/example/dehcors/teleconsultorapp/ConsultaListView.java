package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class ConsultaListView extends AppCompatActivity {




    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_listar_Consultas:

                    return true;
                case R.id.menu_listar_Diagnostico:

                    Intent itDiag = new Intent(ConsultaListView.this,DiagnosticoListView.class);
                    startActivity(itDiag);
                    return true;
                     }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arquivos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.arq_toolbar);
        setSupportActionBar(toolbar);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.listarArquivos_btNavigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        ExpandableListView activity_consulta_list_view = (ExpandableListView) findViewById(R.id.view_listarConsultas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }



}
