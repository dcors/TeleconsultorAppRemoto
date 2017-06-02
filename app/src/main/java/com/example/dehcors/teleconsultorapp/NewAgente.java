package com.example.dehcors.teleconsultorapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class NewAgente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_agente);

        //lista de profissoes do agente
        Spinner nAgente_spProfissao = (Spinner)findViewById(R.id.newAgente_spProfissao);
        ArrayAdapter adAgPro = ArrayAdapter.createFromResource(this, R.array.tipo_profis_agente, android.R.layout.simple_spinner_dropdown_item);
        nAgente_spProfissao.setAdapter(adAgPro);

        //lista de unidades de atendimento
        Spinner nAgente_spUnidade = (Spinner)findViewById(R.id.newAgente_spUnidade);
        ArrayAdapter adAgUni = ArrayAdapter.createFromResource(this, R.array.unidade_atendimento, android.R.layout.simple_spinner_dropdown_item);
        nAgente_spUnidade.setAdapter(adAgUni);

        //botao salvar estes dados
        Button save = (Button)findViewById(R.id.newAgente_btnSalvar);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(NewAgente.this, MainActivity.class);
                startActivity(it);
            }
        });


        //float button cancelar
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.newAgent_floatSair);
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
