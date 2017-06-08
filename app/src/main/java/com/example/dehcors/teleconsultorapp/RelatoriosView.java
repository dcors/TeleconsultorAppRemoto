package com.example.dehcors.teleconsultorapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RelatoriosView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_relat);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_relatorios, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //extrair dados do relatorio para
        if (id == R.id.relatorio_extrair){


            return true;
        }

        //compartilhar relatorio via
        if (id == R.id.relatorio_compartilhar){

            return true;
        }



        return super.onOptionsItemSelected(item);
    }


}


