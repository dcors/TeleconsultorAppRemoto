package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dehcors.teleconsultorapp.DAO.GenericDAO;
import com.example.dehcors.teleconsultorapp.models.Solicitante;


public class UsuarioLogado extends AppCompatActivity {
    String cpfUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.us_logado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        cpfUsuario = intent.getStringExtra("cpfUsuario");

        TextView nome     = (TextView)findViewById(R.id.usuariologadonome);
        TextView tipo     = (TextView)findViewById(R.id.usuariologadotipo);
        TextView cpf      = (TextView)findViewById(R.id.usuariologadocpf);
        EditText telefone = (EditText) findViewById(R.id.usuariologadotelefone);
        EditText email    = (EditText)findViewById(R.id.usuariologadoemail);
        EditText unidade = (EditText)findViewById(R.id.usuariologadounidade);
        EditText senha = (EditText)findViewById(R.id.usuariologadosenha);
        Button salvar = (Button)findViewById(R.id.usuariologadosalvar);
        final Solicitante solicitante = new Solicitante();
        solicitante.setAgenteTelefone(telefone.getText().toString());
        solicitante.setAgenteEmail(email.getText().toString());
        solicitante.setAgenteUnidade(unidade.getText().toString());
        solicitante.setAgenteSenha(senha.getText().toString());
        solicitante.setAgenteCPF(cpfUsuario);

        final GenericDAO dao = new GenericDAO(this);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.alteraUsuario(solicitante);
            }
        });





    }



}

