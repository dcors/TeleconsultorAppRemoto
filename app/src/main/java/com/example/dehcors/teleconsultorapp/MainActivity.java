package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        //botao 1
        ImageButton main_logar = (ImageButton)findViewById(R.id.main_logar);
        main_logar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            do_login();
        }
        });

        //botão 2
        ImageButton main_registrar = (ImageButton)findViewById(R.id.main_registrar);
        main_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
*/

    }
    public void do_login(){
        Intent it1 = new Intent(MainActivity.this, UserLogin.class);
        startActivity(it1);
    }
    public void register(){
        Intent it2 = new Intent(MainActivity.this, NovoUsuario.class);
        startActivity(it2);
    }

    public void shutOff(View v){
        this.finish();
    }
}
