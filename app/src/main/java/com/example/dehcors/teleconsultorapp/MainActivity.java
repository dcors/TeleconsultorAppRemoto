package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //botao 1
        ImageButton main_acessarConta = (ImageButton) findViewById(R.id.main_acessarConta);
        main_acessarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            do_login();
            }
        });

        //botão 2
        ImageButton main_criarConta = (ImageButton) findViewById(R.id.main_criarConta);
        main_criarConta.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        register();
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

//"http://189.28.128.100/dab/docs/portaldab/publicacoes/protocolo_saude_mulher.pdf


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

        //botão primeiros socorros
        ImageButton sPs = (ImageButton)findViewById(R.id.main_primSoc);
        sPs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.youtube.com/watch?v=a_dlsNm5HsU";
                Intent itP = new Intent(Intent.ACTION_VIEW);
                itP.setData(Uri.parse(url));
                startActivity(itP);
            }
        });
    }

//http://bvsms.saude.gov.br/bvs/publicacoes/saude_crianca_crescimento_desenvolvimento.pdf
//http://bvsms.saude.gov.br/bvs/publicacoes/saude_crianca_materiais_infomativos.pdf
//http://www.prefeiturarp.usp.br/pages/cipa/manual_primeiros_socorros.htm
//https://www.youtube.com/watch?v=a_dlsNm5HsU
//http://lproweb.procempa.com.br/pmpa/prefpoa/sma/usu_doc/samu.pdf

    public void do_login(){
        Intent it1 = new Intent(MainActivity.this, UserLogin.class);
        startActivity(it1);
    }
    public void register(){
        Intent it2 = new Intent(MainActivity.this, NewUserPop.class);
        startActivity(it2);
    }


}
