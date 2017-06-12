package com.example.dehcors.teleconsultorapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dehcors.teleconsultorapp.helpers.SolicitanteHelper;

public class NewAgente extends AppCompatActivity {

    private SolicitanteHelper solicitanteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_agente);
        solicitanteHelper = new SolicitanteHelper(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.agt_toolbar);
        setSupportActionBar(toolbar);

        //lista de profissoes do agente
        final Spinner nAgPro = (Spinner) findViewById(R.id.newAgente_spProfissao);
        ArrayAdapter adAgPro = ArrayAdapter.createFromResource(this, R.array.tipo_profis_agente, android.R.layout.simple_spinner_dropdown_item);
        nAgPro.setAdapter(adAgPro);

        AdapterView.OnItemSelectedListener escolherPro = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!nAgPro.getSelectedItem().toString().equalsIgnoreCase("Sua profissão é:")) {
                    Toast.makeText(NewAgente.this,
                            nAgPro.getSelectedItem().toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        nAgPro.setOnItemSelectedListener(escolherPro);


        //lista de unidades de atendimento
        final Spinner nAgUni = (Spinner) findViewById(R.id.newAgente_spUnidade);
        ArrayAdapter adAgUni = ArrayAdapter.createFromResource(this, R.array.uni_atendimento, android.R.layout.simple_spinner_dropdown_item);
        nAgUni.setAdapter(adAgUni);

        AdapterView.OnItemSelectedListener escolherUni = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!nAgUni.getSelectedItem().toString().equalsIgnoreCase("Unidade de atendimento:")) {
                    Toast.makeText(NewAgente.this,
                            nAgUni.getSelectedItem().toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        nAgUni.setOnItemSelectedListener(escolherUni);


        //botao salvar estes dados
        Button save = (Button) findViewById(R.id.newAgente_btnSalvar);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent it = new Intent(NewAgente.this, MainActivity.class);
                startActivity(it);
            }
        });


        //float button cancelar
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.newAgent_floatSair);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel_click(v);
            }
        });
    }

    public void cancel_click(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(NewAgente.this);
        alertDialog.setTitle("Cancelar Cadastro...");
        alertDialog.setMessage("Você realmente deseja cancelar? Todas as informações serão perdidas");
        alertDialog.setIcon(R.drawable.ic_logout_variant_black_36dp);
        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int wich) {
                Toast.makeText(NewAgente.this.getApplicationContext(),
                        "Até breve...", Toast.LENGTH_SHORT).show();
                NewAgente.this.finish();
            }
        });
        alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int wich) {
                Toast.makeText(NewAgente.this.getApplicationContext(),
                        "Seguindo em frente!", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        alertDialog.show();
    }


}
