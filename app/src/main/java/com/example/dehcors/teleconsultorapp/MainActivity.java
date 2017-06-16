package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.dehcors.teleconsultorapp.DAO.GenericDAO;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //logo
        ImageView logo = (ImageView) findViewById(R.id.main_logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.telessaude.uerj.br/nucleorj/";
                Intent itInfo = new Intent(Intent.ACTION_VIEW);

                itInfo.setData(Uri.parse(url));
                startActivity(itInfo);
                finish();
            }
        });

        //botão Acessar teleconsultoria e telediagnostico
        ImageButton main_acessarConta = (ImageButton) findViewById(R.id.main_acessarConta);
        main_acessarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_login();
                
            }
        });


        //botão Chat online
        ImageButton suporte = (ImageButton) findViewById(R.id.main_suporte);
        suporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.telessaude.uerj.br/site/br/chat";
                Intent itChat = new Intent(Intent.ACTION_VIEW);
                itChat.setData(Uri.parse(url));
                startActivity(itChat);
                finish();
            }
        });


        //botao saúde da mulher
        ImageButton sWoman = (ImageButton) findViewById(R.id.main_woman);
        sWoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://portalsaude.saude.gov.br/index.php/o-ministerio/principal/secretarias/sas/saude-da-mulher";
                Intent itM = new Intent(Intent.ACTION_VIEW);
                itM.setData(Uri.parse(url));
                startActivity(itM);
                finish();
            }
        });


        //botao saúde do idoso
        ImageButton sOld = (ImageButton) findViewById(R.id.main_oldMan);
        sOld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://saudedapessoaidosa.fiocruz.br/";
                Intent itO = new Intent(Intent.ACTION_VIEW);
                itO.setData(Uri.parse(url));
                startActivity(itO);
                finish();
            }
        });

        //botão rede universitaria
        ImageButton sUni = (ImageButton) findViewById(R.id.main_rute);
        sUni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://rute.rnp.br/sigs";
                Intent itR = new Intent(Intent.ACTION_VIEW);
                itR.setData(Uri.parse(url));
                startActivity(itR);
                finish();
            }
        });

        //botão atençao basica
        ImageButton sPs = (ImageButton) findViewById(R.id.main_atPrimaria);
        sPs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://aps.bvs.br";
                Intent itP = new Intent(Intent.ACTION_VIEW);
                itP.setData(Uri.parse(url));
                startActivity(itP);
                finish();
            }
        });
    }


    public void do_login() {
        Intent it1 = new Intent(MainActivity.this, UserLogin.class);
        startActivity(it1);
        finish();
    }

}
