package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dehcors.teleconsultorapp.DAO.GenericDAO;
import com.example.dehcors.teleconsultorapp.models.Consulta;

public class AtenderActivity extends AppCompatActivity {

    String cpfUsuario ="";
    int idConsulta =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atender);
        Intent intent = getIntent();
        cpfUsuario = intent.getStringExtra("cpfUsuario");
        idConsulta = intent.getIntExtra("idConsulta",0);

        final GenericDAO dao = new GenericDAO(this);
        final Consulta consulta = dao.getConsultaPorId(idConsulta);
        TextView idConsulta = (TextView) findViewById(R.id.atenderidconsulta);
        idConsulta.setText(Integer.toString(consulta.getIdConsulta()));

        TextView especialidade = (TextView) findViewById(R.id.atenderespecialidade);
        especialidade.setText(consulta.getEspecialidade().toString());

        TextView caso = (TextView) findViewById(R.id.atenderduvida);
        caso.setText(consulta.getTxCaso().toString());

        final EditText parecer = (EditText) findViewById(R.id.atenderresposta);


        Button salvar = (Button) findViewById(R.id.atendersalvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.insereParecer(consulta.getIdConsulta(),parecer.getText().toString());
                dao.atualizaAtendida(consulta.getIdConsulta());
                finish();
            }
        });



    }
}
