package com.example.dehcors.teleconsultorapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.dehcors.teleconsultorapp.helpers.DiagnosticoHelper;
import com.example.dehcors.teleconsultorapp.models.Diagnostico;

/**
 * Created by cors on 06/06/17.
 */
public class NovoDiagnostico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_diagnostico);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button salvarDiagnostico = (Button) findViewById(R.id.diagnosticoenviar);
        salvarDiagnostico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar_consulta();
            }
        });


        //spinner genero do paciente
        final Spinner nDgenero = (Spinner) findViewById(R.id.nvDiagno_genPaciente);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.spGenero, android.R.layout.simple_spinner_dropdown_item);
        nDgenero.setAdapter(adapter1);
        AdapterView.OnItemSelectedListener genero = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if ((!nDgenero.getSelectedItem().toString().equalsIgnoreCase("Genero do paciente:"))) {
                    Toast.makeText(NovoDiagnostico.this,
                            nDgenero.getSelectedItem().toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        nDgenero.setOnItemSelectedListener(genero);


        //spinner para especialidades médicas
        final Spinner nuAt = (Spinner) findViewById(R.id.nvDiagno_areaMedic);
        ArrayAdapter adAt = ArrayAdapter.createFromResource(this, R.array.spAreaConsulta, android.R.layout.simple_spinner_dropdown_item);
        nuAt.setAdapter(adAt);
        AdapterView.OnItemSelectedListener especialidade = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!nuAt.getSelectedItem().toString().equalsIgnoreCase("Especialidade:")) {
                    Toast.makeText(NovoDiagnostico.this,
                            nuAt.getSelectedItem().toString(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        nuAt.setOnItemSelectedListener(especialidade);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    public void cancel_click(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(NovoDiagnostico.this);
        alertDialog.setTitle("Cancelar Solicitação...");
        alertDialog.setMessage("Você realmente deseja cancelar? Todas as informações serão perdidas");
        alertDialog.setIcon(R.drawable.ic_logout_variant_black_36dp);
        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int wich) {
                Toast.makeText(NovoDiagnostico.this.getApplicationContext(),
                        "Até breve...", Toast.LENGTH_SHORT).show();
                NovoDiagnostico.this.finish();
            }
        });
        alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int wich) {
                Toast.makeText(NovoDiagnostico.this.getApplicationContext(),
                        "Seguindo em frente!", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    public void salvar_consulta() {
        DiagnosticoHelper helper = new DiagnosticoHelper(NovoDiagnostico.this);
        Diagnostico diagnostico = helper.getDiagnostico();
        GenericDAO dao = new GenericDAO(NovoDiagnostico.this);
        dao.insereDiagnostico(diagnostico);


        Toast.makeText(NovoDiagnostico.this,"Diagnóstico salvo com sucesso",Toast.LENGTH_LONG).show();
        Intent it5 = new Intent(NovoDiagnostico.this, UserDashboard.class);
        startActivity(it5);
    }
}
