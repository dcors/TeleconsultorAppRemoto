package com.example.dehcors.teleconsultorapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class UsuarioLogado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.us_logado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user_logado, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
          int id = item.getItemId();
        if (id == R.id.userLogado_info){
    //mostrar informações editaveis do usuario que está logado

            return true;
           }

     //mostrar opção para trocar a senha
        if (id == R.id.userLogado_senha){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(UsuarioLogado.this);
            View mView = getLayoutInflater().inflate(R.layout.pop_troca_senha, null);


            //componentes do layout pop trocar senha:
            EditText txSenha = (EditText)mView.findViewById(R.id.alterSenha_senha); //campo de senha
            EditText txReSenha = (EditText)mView.findViewById(R.id.altersenha_repeteSenha); //campo para repetir senha
            Button btConfirma = (Button)mView.findViewById(R.id.btn_alterSenha_confirma); //botao confirma
            Button btCancel = (Button)mView.findViewById(R.id.btn_alterSenha_cancela); //botao cancela


            alertDialog.setView(mView);
            AlertDialog dialog = alertDialog.create();
            dialog.show();
            return true;
        }



        return super.onOptionsItemSelected(item);
    }


    }

