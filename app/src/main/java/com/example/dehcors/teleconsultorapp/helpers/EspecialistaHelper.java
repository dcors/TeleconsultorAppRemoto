package com.example.dehcors.teleconsultorapp.helpers;

import android.widget.EditText;
import android.widget.Spinner;

import com.example.dehcors.teleconsultorapp.NewEspecialista;
import com.example.dehcors.teleconsultorapp.R;
import com.example.dehcors.teleconsultorapp.models.Especialista;

/**
 * Created by Icons4u TI on 15/06/2017.
 */

public class EspecialistaHelper {

    private final EditText especialistaCPF;
    private final EditText especialistaNome;
    private final Spinner especialistaProfissao;
    private final EditText especialistaEmail;

    private final EditText especialistaRepitaSenha;
    private final EditText especialistaSenha;

    public EspecialistaHelper(NewEspecialista activity){

        especialistaEmail = (EditText)activity.findViewById(R.id.especialistaemail);
        especialistaCPF = (EditText) activity.findViewById(R.id.especialistacpf);
        especialistaNome = (EditText) activity.findViewById(R.id.especialistanome) ;
        especialistaProfissao = (Spinner) activity.findViewById(R.id.newEsp_spProfissao) ;
        especialistaSenha = (EditText) activity.findViewById(R.id.especialistasenha) ;
        especialistaRepitaSenha = (EditText) activity.findViewById(R.id.especialistarepitasenha) ;
    }

    public Especialista getEspecialista(){

        Especialista especialista = new Especialista();
        especialista.setEspecialistaCPF(especialistaCPF.getText().toString());
        especialista.setEspecialistaNome(especialistaNome.getText().toString());
        especialista.setEspecialistaProfissao(especialistaProfissao.getSelectedItem().toString());
        especialista.setEspecialistaSenha(especialistaSenha.getText().toString());
        especialista.setEspecialistaRepitaSenha(especialistaRepitaSenha.getText().toString());
        especialista.setEspecialistaEmail(especialistaEmail.getText().toString());
        especialista.setIdTipo(2);

        return especialista;

    }
}
