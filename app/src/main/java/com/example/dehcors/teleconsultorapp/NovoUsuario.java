package com.example.dehcors.teleconsultorapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class NovoUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo_usuario);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.novoUsuario_floatSair);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               cancel_click(view);

                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show(); */
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void cancel_click(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(NovoUsuario.this);
        alertDialog.setTitle("Cancelar Cadastro...");
        alertDialog.setMessage("Você realmente deseja cancelar? Todas as informações serão perdidas");
        alertDialog.setIcon(R.drawable.ic_logout_variant_black_36dp);
        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int wich) {
                Toast.makeText(NovoUsuario.this.getApplicationContext(),
                        "Até breve...", Toast.LENGTH_SHORT).show();
                NovoUsuario.this.finish();
            }
        });
        alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int wich) {
                Toast.makeText(NovoUsuario.this.getApplicationContext(),
                        "Seguindo em frente!", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        alertDialog.show();
    }


}
