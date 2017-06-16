package com.example.dehcors.teleconsultorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.dehcors.teleconsultorapp.DAO.GenericDAO;

public class RelatoriosView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_relat);
        setSupportActionBar(toolbar);


        TextView consultasSolicitadas = (TextView) findViewById(R.id.relatoriosconsultasolicitada);
        TextView consultasRespondidas = (TextView) findViewById(R.id.relatoriosconsultarespondida);
        TextView diagnosticosSolicitados = (TextView) findViewById(R.id.relatoriosdiagnosticosolicitado);
        TextView diagnosticosRespondidos = (TextView) findViewById(R.id.relatoriosdiagnosticorespondido);
        consultasSolicitadas.setText(getConsultasSolicitadas());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public String getConsultasSolicitadas(){
        int total =0;
        String totalizado ="";
        GenericDAO dao = new GenericDAO(RelatoriosView.this);
        total = dao.getConsultasSolicitadas();
        totalizado = Integer.toString(total);

        return totalizado;

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
        if (id == R.id.relatorio_extrair) {


            return true;
        }

        //compartilhar relatorio via
        if (id == R.id.relatorio_compartilhar) {

            return true;
        }


        return super.onOptionsItemSelected(item);
    }


}


