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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //lista de tipos de usuários
        Spinner novoUsuario_spTipoUsuario = (Spinner)findViewById(R.id.novoUsuario_spTipoUsuario);
        ArrayAdapter adapter5 = ArrayAdapter.createFromResource(this, R.array.tipo_user, android.R.layout.simple_spinner_dropdown_item);
        novoUsuario_spTipoUsuario.setAdapter(adapter5);

        //lista de profissão de acordo com tipo de usuario
        Spinner novoUsuario_spProfissao = (Spinner)findViewById(R.id.novoUsuario_spProfissao);
        //colocar condição para chamar o spiner de acordo com o tipo de usuario escolhido
        //if spTipoUsuario = 1 {}
        ArrayAdapter adapter7a = ArrayAdapter.createFromResource(this, R.array.tipo_profis_agente, android.R.layout.simple_spinner_dropdown_item);
        novoUsuario_spProfissao.setAdapter(adapter7a);


        //Lista de regioes do usuario
        Spinner novoUsuario_spUnidade = (Spinner)findViewById(R.id.novoUsuario_spUnidade);
        ArrayAdapter adapter6 = ArrayAdapter.createFromResource(this,R.array.unidade_atendimento,android.R.layout.simple_spinner_dropdown_item);
        novoUsuario_spUnidade.setAdapter(adapter6);

        //botão salvar novo usuário
        Button novoUsuario_btnSalvar = (Button) findViewById(R.id.novoUsuario_btnSalvar);
        novoUsuario_btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itsalvar = new Intent(NewAgente.this, MainActivity.class);
                startActivity(itsalvar);
            }
        }
    );


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.novoUsuario_floatSair);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               cancel_click(view);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
