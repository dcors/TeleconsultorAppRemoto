package com.example.dehcors.teleconsultorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dehcors.teleconsultorapp.DAO.GenericDAO;
import com.example.dehcors.teleconsultorapp.models.Consulta;

import java.util.List;

public class ListaDeConsultas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_consultas);


        GenericDAO dao = new GenericDAO(this);
        List<Consulta> consultas = dao.getConsultas();
        dao.close();

        ListView listaConsulta = (ListView) findViewById(R.id.listadeconsultas);
        ArrayAdapter<Consulta> adapter  = new ArrayAdapter<Consulta>(this,android.R.layout.simple_list_item_1,consultas);
        listaConsulta.setAdapter(adapter);
    }
}
