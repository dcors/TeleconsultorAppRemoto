package com.example.dehcors.teleconsultorapp.helpers;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.dehcors.teleconsultorapp.NewAgente;
import com.example.dehcors.teleconsultorapp.R;
import com.example.dehcors.teleconsultorapp.models.Solicitante;

/**
 * Created by Icons4u TI on 12/06/2017.
 */

public class SolicitanteHelper {


    private final EditText agenteNome;
    private final EditText agenteCPF;
    private final EditText agenteTelefone;
    private final EditText agenteEmail;
    private final Spinner agenteProfissao;
    private final Spinner agenteUnidade;
    private final EditText agenteSenha;
    private final EditText agenteRepitaSenha;

    public SolicitanteHelper(NewAgente activity){

         agenteNome = (EditText) activity.findViewById(R.id.agentenome);
         agenteCPF = (EditText) activity.findViewById(R.id.agentecpf);
         agenteTelefone = (EditText) activity.findViewById(R.id.agentetelefone);
         agenteEmail = (EditText) activity.findViewById(R.id.agenteemail);
         agenteProfissao = (Spinner) activity.findViewById(R.id.newAgente_spProfissao);
         agenteUnidade = (Spinner) activity.findViewById(R.id.newAgente_spUnidade);
         agenteSenha = (EditText) activity.findViewById(R.id.agentesenha);
         agenteRepitaSenha = (EditText) activity.findViewById(R.id.agenterepitasenha);




    }


    public Solicitante pegaSolicitante() {
        Solicitante solicitante = new Solicitante();
        solicitante.setIdTipo(1);
        solicitante.setAgenteNome(agenteNome.getText().toString());
        solicitante.setAgenteCPF(agenteCPF.getText().toString());
        solicitante.setAgenteTelefone(agenteTelefone.getText().toString());
        solicitante.setAgenteEmail(agenteEmail.getText().toString());
        solicitante.setAgenteProfissao(agenteProfissao.getSelectedItem().toString());
        solicitante.setAgenteSenha(agenteSenha.getText().toString());
        solicitante.setAgenteRepitaSenha(agenteRepitaSenha.getText().toString());
        return solicitante;
    }
}
