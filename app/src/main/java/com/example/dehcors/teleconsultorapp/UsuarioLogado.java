package com.example.dehcors.teleconsultorapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class UsuarioLogado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuario_logado);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_usuario_logado, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
          int id = item.getItemId();
        if (id == R.id.userLogado_info){


            return true;
           }

        if (id == R.id.userLogado_senha){
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(UsuarioLogado.this);
            alertDialog.setTitle("ALTERE SUA SENHA");
            alertDialog.setMessage("Digite a nova senha");

            final EditText input = new EditText(this);
            alertDialog.setView(input);

            alertDialog.setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int wich) {
                    Toast.makeText(getApplicationContext(), input.getText().toString().trim(),
                            Toast.LENGTH_SHORT).show();
                    UsuarioLogado.this.finish();
                }
            });
            alertDialog.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int wich) {
                    Toast.makeText(UsuarioLogado.this.getApplicationContext(),
                            "Senha Não Alterada", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            });
            alertDialog.show();

            return true;
        }



        return super.onOptionsItemSelected(item);
    }


    }

