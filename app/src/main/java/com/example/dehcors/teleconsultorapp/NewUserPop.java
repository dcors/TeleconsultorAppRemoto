package com.example.dehcors.teleconsultorapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by cors on 01/06/17.
 */

public class NewUserPop extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_new_user);

        //dimensões da janela pop
        DisplayMetrics dmNew = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dmNew);
        int width = dmNew.widthPixels;
        int height = dmNew.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .4)); //.8 significa 80% da tela

        Button new_agent = (Button) findViewById(R.id.new_agente);
        new_agent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itnAg = new Intent(NewUserPop.this, NewAgente.class);
                startActivity(itnAg);
            }
        });

        Button new_espec = (Button) findViewById(R.id.new_especial);
        new_espec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itnEs = new Intent(NewUserPop.this, NewEspecialista.class);
                startActivity(itnEs);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
