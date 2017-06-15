package com.example.dehcors.teleconsultorapp.models;

/**
 * Created by Icons4u TI on 15/06/2017.
 */

public class Consulta {
    private int tipoConsulta ;
    private int idConsulta ;
    private String cpfPaciente ;
    private String especialidade ;
    private int idUsuario ;
    private int idParecer ;
    private String txCaso;

    public String getTxCaso() {
        return txCaso;
    }

    public void setTxCaso(String txCaso) {
        this.txCaso = txCaso;
    }

    public int getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdParecer() {
        return idParecer;
    }

    public void setIdParecer(int idParecer) {
        this.idParecer = idParecer;
    }

    @Override
    public String toString() {
        return getCpfPaciente()+ " - "+getEspecialidade();
    }
}
