package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dehcors.teleconsultorapp.DAO.GenericDAO;
import com.example.dehcors.teleconsultorapp.models.Consulta;

import java.util.List;

public class ListaDeConsultas extends AppCompatActivity {

String cpfUsuario = "";
    private ListView listaConsulta;
    private int idTipo;
    List<Consulta> consultas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_consultas);

        Intent intent = getIntent();
        cpfUsuario = intent.getStringExtra("cpfUsuario");
        carregaConsulta();





    }

    public void carregaConsulta(){
        GenericDAO dao = new GenericDAO(this);
        idTipo =  dao.verificaTipo(cpfUsuario);
        if(idTipo==1){
            consultas = dao.getConsultas(cpfUsuario);
            dao.close();
        }else {
            consultas = dao.getConsultasEspecialista();
            dao.close();
        }

        listaConsulta = (ListView) findViewById(R.id.listadeconsultas);
        registerForContextMenu(listaConsulta);
        ArrayAdapter<Consulta> adapter  = new ArrayAdapter<Consulta>(this,android.R.layout.simple_list_item_1,consultas);
        listaConsulta.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaConsulta();

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem menuItem = null;
        if(idTipo==1){
          menuItem =  menu.add("Visualizar");

        }else {
            menuItem =  menu.add("Atender");

        }
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo) menuInfo;
                Consulta consulta = (Consulta) listaConsulta.getItemAtPosition(info.position);
                if(idTipo==1){

                    Intent intent = new Intent(ListaDeConsultas.this,VisualizarConsultasActivity.class);
                    intent.putExtra("cpfUsuario",cpfUsuario);
                    intent.putExtra("idConsulta",consulta.getIdConsulta());
                    startActivity(intent);


                }else{
                    Intent intent = new Intent(ListaDeConsultas.this,AtenderActivity.class);
                    intent.putExtra("cpfUsuario",cpfUsuario);
                    intent.putExtra("idConsulta",consulta.getIdConsulta());
                    startActivity(intent);

                }

                return false;
            }
        });
    }
}
