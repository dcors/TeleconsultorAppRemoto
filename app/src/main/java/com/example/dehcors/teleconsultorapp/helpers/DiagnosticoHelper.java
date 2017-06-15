package com.example.dehcors.teleconsultorapp.helpers;

import android.widget.EditText;
import android.widget.Spinner;

import com.example.dehcors.teleconsultorapp.NovoDiagnostico;
import com.example.dehcors.teleconsultorapp.R;
import com.example.dehcors.teleconsultorapp.models.Diagnostico;

/**
 * Created by Icons4u TI on 15/06/2017.
 */

public class DiagnosticoHelper {

    private final EditText prontuario;
    private final Spinner especialidade;
    private final EditText caso;

    public DiagnosticoHelper(NovoDiagnostico activity){

         prontuario = (EditText) activity.findViewById(R.id.diagnosticoprontuario);
         especialidade = (Spinner) activity.findViewById(R.id.nvDiagno_areaMedic);
         caso = (EditText) activity.findViewById(R.id.diagnosticotexto);

    }

    public Diagnostico getDiagnostico(){

        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setEspecialidade(especialidade.getSelectedItem().toString());
        diagnostico.setProntuario(prontuario.getText().toString());
        diagnostico.setCaso(caso.getText().toString());
        return diagnostico;
    }
}
