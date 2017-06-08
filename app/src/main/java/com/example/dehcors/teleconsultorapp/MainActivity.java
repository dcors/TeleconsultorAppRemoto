package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //logo
        ImageView logo = (ImageView)findViewById(R.id.main_logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.telessaude.uerj.br/nucleorj/";
                Intent itInfo = new Intent(Intent.ACTION_VIEW);
                itInfo.setData(Uri.parse(url));
                startActivity(itInfo);
            }
        });

        //botao 1
        ImageButton main_acessarConta = (ImageButton) findViewById(R.id.main_acessarConta);
        main_acessarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            do_login();
            }
        });

        //botão 2
        ImageButton clinicas = (ImageButton) findViewById(R.id.main_clinicas);
        clinicas.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        encontrar();
        }
    });


        //botao saúde da mulher
        ImageButton sWoman = (ImageButton)findViewById(R.id.main_woman);
        sWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://portalsaude.saude.gov.br/index.php/o-ministerio/principal/secretarias/sas/saude-da-mulher";
                Intent itM = new Intent(Intent.ACTION_VIEW);
                itM.setData(Uri.parse(url));
                startActivity(itM);
            }
        });


        //botao saúde do idoso
        ImageButton sOld = (ImageButton)findViewById(R.id.main_oldMan);
        sOld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://saudedapessoaidosa.fiocruz.br/";
                Intent itO = new Intent(Intent.ACTION_VIEW);
                itO.setData(Uri.parse(url));
                startActivity(itO);
            }
        });

        //botão saúde da criança
        ImageButton sChil = (ImageButton)findViewById(R.id.main_bb);
        sChil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://bvsms.saude.gov.br/bvs/publicacoes/saude_crianca_materiais_infomativos.pdf   ";
                Intent itC = new Intent(Intent.ACTION_VIEW);
                itC.setData(Uri.parse(url));
                startActivity(itC);
            }
        });

        //botão atençao basica
        ImageButton sPs = (ImageButton)findViewById(R.id.main_atPrimaria);
        sPs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://aps.bvs.br";
                Intent itP = new Intent(Intent.ACTION_VIEW);
                itP.setData(Uri.parse(url));
                startActivity(itP);
            }
        });
    }



    public void do_login(){
        Intent it1 = new Intent(MainActivity.this, UserLogin.class);
        startActivity(it1);
    }
    public void encontrar(){
        Intent it2 = new Intent(MainActivity.this, VerClinicas.class);
        startActivity(it2);
    }


}
