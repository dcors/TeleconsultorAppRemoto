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
import android.widget.AdapterView;
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
        final Spinner nvCon_spGenero = (Spinner)findViewById(R.id.nvConsul_spGenero);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.spGenero, android.R.layout.simple_spinner_dropdown_item);
        nvCon_spGenero.setAdapter(adapter1);
        AdapterView.OnItemSelectedListener genero = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ((!nvCon_spGenero.getSelectedItem().toString().equalsIgnoreCase("Genero do paciente:"))) {
                    Toast.makeText(NovaConsulta.this,
                            nvCon_spGenero.getSelectedItem().toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };nvCon_spGenero.setOnItemSelectedListener(genero);


        //lista de áreas da medicina
        final Spinner nvCon_area = (Spinner)findViewById(R.id.nvConsul_idArea);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.spAreaConsulta, android.R.layout.simple_spinner_dropdown_item);
        nvCon_area.setAdapter(adapter2);
        AdapterView.OnItemSelectedListener area = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ((!nvCon_area.getSelectedItem().toString().equalsIgnoreCase("Especialidade:"))) {
                    Toast.makeText(NovaConsulta.this,
                            nvCon_area.getSelectedItem().toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };nvCon_area.setOnItemSelectedListener(area);


        //lista de regiões geograficas
        final Spinner nvCon_Regiao = (Spinner)findViewById(R.id.nvConsul_idRegiao);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.spRegiaoNucleo, android.R.layout.simple_spinner_dropdown_item);
        nvCon_Regiao.setAdapter(adapter3);
        AdapterView.OnItemSelectedListener regiao = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ((!nvCon_Regiao.getSelectedItem().toString().equalsIgnoreCase("Núcleo de Atendimento:"))) {
                    Toast.makeText(NovaConsulta.this,
                            nvCon_Regiao.getSelectedItem().toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };nvCon_Regiao.setOnItemSelectedListener(regiao);



        //lista de tipos de dúvidas
        final Spinner nvCon_Duvida = (Spinner)findViewById(R.id.nvConsul_tipoDuvida);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(this, R.array.spDuvida, android.R.layout.simple_spinner_dropdown_item);
        nvCon_Duvida.setAdapter(adapter4);
        AdapterView.OnItemSelectedListener duvida = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ((!nvCon_Duvida.getSelectedItem().toString().equalsIgnoreCase("Sua dúvida é sobre:"))) {
                    Toast.makeText(NovaConsulta.this,
                            nvCon_Duvida.getSelectedItem().toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };nvCon_Duvida.setOnItemSelectedListener(duvida);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.nvConsul_Sair);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Cancelar esta consulta", Snackbar.LENGTH_LONG)
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
        alertDialog.setTitle("Cancelar Consulta...");
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
