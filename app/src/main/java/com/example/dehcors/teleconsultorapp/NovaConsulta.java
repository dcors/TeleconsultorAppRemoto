package com.example.dehcors.teleconsultorapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NovaConsulta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_consulta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.novaConsulta_Sair);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Clique aqui para cancelar a consulta", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                cancel_click(view);
            }
        });

        Button novaConsulta_saveConsulta = (Button)findViewById(R.id.novaConsulta_saveConsulta);
        novaConsulta_saveConsulta.setOnClickListener(new View.OnClickListener(){
            @Override
                public void onClick (View v){
                salvar_consulta();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void cancel_click(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(NovaConsulta.this);
        alertDialog.setTitle("Cancelar Cadastro...");
        alertDialog.setMessage("Você realmente deseja cancelar? Todas as informações serão perdidas");
        alertDialog.setIcon(R.drawable.ic_logout_variant_black_36dp);
        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int wich) {
                Toast.makeText(NovaConsulta.this.getApplicationContext(),
                        "Até breve...", Toast.LENGTH_SHORT).show();
                NovaConsulta.this.finish();
            }
        });
        alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int wich) {
                Toast.makeText(NovaConsulta.this.getApplicationContext(),
                        "Seguindo em frente!", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void salvar_consulta(){
        Intent it5 = new Intent(NovaConsulta.this, UserDashboard.class);
        startActivity(it5);
    }
}
