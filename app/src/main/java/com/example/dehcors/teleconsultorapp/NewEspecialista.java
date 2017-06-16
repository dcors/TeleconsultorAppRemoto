package com.example.dehcors.teleconsultorapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dehcors.teleconsultorapp.DAO.GenericDAO;
import com.example.dehcors.teleconsultorapp.helpers.EspecialistaHelper;
import com.example.dehcors.teleconsultorapp.models.Especialista;

public class NewEspecialista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_especialista);
        Toolbar toolbar = (Toolbar) findViewById(R.id.esp_toolbar);
        setSupportActionBar(toolbar);


        //Lista de profissoes do especialista
        final Spinner nEspPro = (Spinner) findViewById(R.id.newEsp_spProfissao);
        ArrayAdapter adEs = ArrayAdapter.createFromResource(this, R.array.tipo_profis_especial, android.R.layout.simple_spinner_dropdown_item);
        nEspPro.setAdapter(adEs);

        AdapterView.OnItemSelectedListener escolher = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!nEspPro.getSelectedItem().toString().equalsIgnoreCase("Sua especialidade é:")) {
                    Toast.makeText(NewEspecialista.this,
                            nEspPro.getSelectedItem().toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        nEspPro.setOnItemSelectedListener(escolher);


        //botao salvar estes dados
        Button saveEsp = (Button) findViewById(R.id.newEspec_btnSalvar);
        saveEsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EspecialistaHelper helper = new EspecialistaHelper(NewEspecialista.this);
                Especialista especialista = helper.getEspecialista();
                if(especialista.getEspecialistaSennha().equals(especialista.getEspecialistaRepitaSenha()) ){
                    GenericDAO dao = new GenericDAO(NewEspecialista.this);
                    dao.insereEspecialista(especialista);
                    dao.close();
                    Toast.makeText(NewEspecialista.this,"Especialista " +especialista.getEspecialistaNome()+" Salvo com sucesso",Toast.LENGTH_LONG).show();
                    Intent it = new Intent(NewEspecialista.this, MainActivity.class);
                    startActivity(it);
                    finish();
                }else {

                    Toast.makeText(NewEspecialista.this,"As senhas devem ser iguais.",Toast.LENGTH_LONG).show();
                }

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.newEspec_floatSair);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel_click(view);
            }
        });
    }

    public void cancel_click(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(NewEspecialista.this);
        alertDialog.setTitle("Cancelar Cadastro...");
        alertDialog.setMessage("Você realmente deseja cancelar? Todas as informações serão perdidas");
        alertDialog.setIcon(R.drawable.ic_logout_variant_black_36dp);
        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int wich) {
                Toast.makeText(NewEspecialista.this.getApplicationContext(),
                        "Até breve...", Toast.LENGTH_SHORT).show();
                NewEspecialista.this.finish();
            }
        });
        alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int wich) {
                Toast.makeText(NewEspecialista.this.getApplicationContext(),
                        "Seguindo em frente!", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        alertDialog.show();
    }
}
