package com.example.dehcors.teleconsultorapp.helpers;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.dehcors.teleconsultorapp.NewAgente;
import com.example.dehcors.teleconsultorapp.R;

/**
 * Created by Icons4u TI on 12/06/2017.
 */

public class SolicitanteHelper {

    public SolicitanteHelper(NewAgente activity){

        EditText AgenteNome = (EditText) activity.findViewById(R.id.agentenome);
        EditText AgenteCPF = (EditText) activity.findViewById(R.id.agentecpf);
        EditText AgenteTelefone = (EditText) activity.findViewById(R.id.agentetelefone);
        EditText AgenteEmail = (EditText) activity.findViewById(R.id.agenteemail);
        Spinner AgenteProfissao = (Spinner) activity.findViewById(R.id.newAgente_spProfissao);
        Spinner AgenteUnidade = (Spinner) activity.findViewById(R.id.newAgente_spUnidade);
        EditText AgenteSenha = (EditText) activity.findViewById(R.id.agentesenha);
        EditText AgenteRepitaSenha = (EditText) activity.findViewById(R.id.agenterepitasenha);




    }
}
