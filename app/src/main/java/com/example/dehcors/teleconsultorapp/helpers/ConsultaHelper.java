package com.example.dehcors.teleconsultorapp.helpers;

import android.widget.EditText;
import android.widget.Spinner;

import com.example.dehcors.teleconsultorapp.NovaConsulta;
import com.example.dehcors.teleconsultorapp.R;
import com.example.dehcors.teleconsultorapp.models.Consulta;
import com.example.dehcors.teleconsultorapp.models.Solicitante;

/**
 * Created by Icons4u TI on 15/06/2017.
 */

public class ConsultaHelper {

    private final Spinner area;
    private final Spinner tipoDuvida;
    private final EditText caso;
    private final EditText cpf;

    public ConsultaHelper(NovaConsulta activity){

         area = (Spinner) activity.findViewById(R.id.nvConsul_idArea);
         tipoDuvida = (Spinner) activity.findViewById(R.id.nvConsul_tipoDuvida);
         caso = (EditText) activity.findViewById(R.id.nvConsul_txCaso);
        cpf = (EditText) activity.findViewById(R.id.consultacpf);

    }

    public Consulta getConsulta(){

        Consulta consulta = new Consulta();
        consulta.setEspecialidade(area.getSelectedItem().toString());
        consulta.setTxCaso(caso.getText().toString());
        consulta.setCpfPaciente(cpf.getText().toString());

        return consulta;
    }
}
