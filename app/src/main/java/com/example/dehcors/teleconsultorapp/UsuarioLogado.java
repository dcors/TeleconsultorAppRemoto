package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
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
    private StringBuffer alterando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.us_logado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Intent intent = getIntent();
        cpfUsuario = intent.getStringExtra("cpfUsuario");

        final GenericDAO dao = new GenericDAO(this);
        final Solicitante solicitante = dao.buscaUsuario(cpfUsuario);

        TextView nome     = (TextView)findViewById(R.id.usuariologadonome);
        nome.setText(solicitante.getAgenteNome());

        TextView tipo     = (TextView)findViewById(R.id.usuariologadotipo);
        if(solicitante.getIdTipo()==1){
            tipo.setText("Solicitante");
        }else {
            tipo.setText("Teleconsultor");
        }

        TextView cpf      = (TextView)findViewById(R.id.usuariologadocpf);
        cpf.setText(solicitante.getAgenteCPF());

        EditText telefone = (EditText) findViewById(R.id.usuariologadotelefone);
        telefone.setText(solicitante.getAgenteTelefone());

        EditText email    = (EditText)findViewById(R.id.usuariologadoemail);
        email.setText(solicitante.getAgenteEmail());

        EditText unidade = (EditText)findViewById(R.id.usuariologadounidade);
        unidade.setText(solicitante.getAgenteUnidade());

        final EditText senha = (EditText)findViewById(R.id.usuariologadosenha);
        final String alteraSenha="";
        senha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                 alterando = new StringBuffer();
                alterando.append(senha.getText().toString());


            }
        });

        solicitante.setAgenteTelefone(telefone.getText().toString());
        solicitante.setAgenteEmail(email.getText().toString());
        solicitante.setAgenteUnidade(unidade.getText().toString());
        solicitante.setAgenteSenha(senha.getText().toString());
        solicitante.setAgenteCPF(cpfUsuario);




        Button salvar = (Button)findViewById(R.id.usuariologadosalvar);


        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solicitante.setAgenteSenha(alterando.toString());
                dao.alteraUsuario(solicitante);
                Intent intent = new Intent(UsuarioLogado.this,UserDashboard.class);
                intent.putExtra("cpfUsuario",cpfUsuario);
                startActivity(intent);
            }
        });





    }





}

