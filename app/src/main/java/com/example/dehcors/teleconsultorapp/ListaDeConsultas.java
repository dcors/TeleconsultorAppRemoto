package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dehcors.teleconsultorapp.DAO.GenericDAO;
import com.example.dehcors.teleconsultorapp.models.Consulta;

import java.util.List;

public class ListaDeConsultas extends AppCompatActivity {

String cpfUsuario = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<Consulta> consultas = null;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_consultas);

        Intent intent = getIntent();
        cpfUsuario = intent.getStringExtra("cpfUsuario");

        GenericDAO dao = new GenericDAO(this);
       int idTipo =  dao.verificaTipo(cpfUsuario);
        if(idTipo==1){
            consultas = dao.getConsultas(cpfUsuario);
            dao.close();
        }else {
            consultas = dao.getConsultasEspecialista();
            dao.close();
        }


        ListView listaConsulta = (ListView) findViewById(R.id.listadeconsultas);
        ArrayAdapter<Consulta> adapter  = new ArrayAdapter<Consulta>(this,android.R.layout.simple_list_item_1,consultas);
        listaConsulta.setAdapter(adapter);
    }
}
