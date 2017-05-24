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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class NovaConsulta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_consulta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //lista de genero feminino/masculino
        Spinner nvConsul_spGenero = (Spinner)findViewById(R.id.nvConsul_spGenero);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.spGenero, android.R.layout.simple_spinner_dropdown_item);
        nvConsul_spGenero.setAdapter(adapter1);

        //lista de áreas da medicina
        Spinner nvConsul_idArea = (Spinner)findViewById(R.id.nvConsul_idArea);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.spArea, android.R.layout.simple_spinner_dropdown_item);
        nvConsul_idArea.setAdapter(adapter2);

        //lista de regiões geograficas
        Spinner nvConsult_idRegiao = (Spinner)findViewById(R.id.nvConsul_idRegiao);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.spRegiao, android.R.layout.simple_spinner_dropdown_item);
        nvConsult_idRegiao.setAdapter(adapter3);

        //lista de tipos de dúvidas
        Spinner nvConsult_tipoDuvida = (Spinner)findViewById(R.id.nvConsul_tipoDuvida);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(this, R.array.spDuvida, android.R.layout.simple_spinner_dropdown_item);
        nvConsult_tipoDuvida.setAdapter(adapter4);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.nvConsul_Sair);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Clique aqui para cancelar a consulta", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                cancel_click(view);
            }
        });

        Button nvConsul_saveConsulta = (Button)findViewById(R.id.nvConsul_saveConsulta);
        nvConsul_saveConsulta.setOnClickListener(new View.OnClickListener(){
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
