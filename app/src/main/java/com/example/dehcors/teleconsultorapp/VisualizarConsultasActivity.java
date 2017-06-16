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

public class VisualizarConsultasActivity extends AppCompatActivity {

    private String cpfUsuario;
    private int idConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_consultas);

        Intent intent = getIntent();
        cpfUsuario = intent.getStringExtra("cpfUsuario");
        idConsulta = intent.getIntExtra("idConsulta",0);

        final GenericDAO dao = new GenericDAO(this);
        final Consulta consulta = dao.getConsultaPorId(idConsulta);
        TextView idConsulta = (TextView) findViewById(R.id.visualizaridconsulta);
        idConsulta.setText(Integer.toString(consulta.getIdConsulta()));

        TextView especialidade = (TextView) findViewById(R.id.visualizarespecialidade);
        especialidade.setText(consulta.getEspecialidade().toString());

        TextView caso = (TextView) findViewById(R.id.visualizarduvida);
        caso.setText(consulta.getTxCaso().toString());

        String textoParecer = dao.getTextoParecer(this.idConsulta);

        if(textoParecer !=null) {
            TextView parecer = (TextView) findViewById(R.id.visualizarresposta);
            parecer.setText(textoParecer);
        }else {
            TextView parecer = (TextView) findViewById(R.id.visualizarresposta);
            parecer.setText("Esta consulta ainda não foi atendida");
        }

        Button voltar = (Button) findViewById(R.id.visualizarsalvar);
        voltar.setText("Voltar");
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VisualizarConsultasActivity.this,ListaDeConsultas.class);
                intent.putExtra("cpfUsuario",cpfUsuario);
                finish();
            }
        });


    }
}
