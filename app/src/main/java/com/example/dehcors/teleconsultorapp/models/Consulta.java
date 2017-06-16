package com.example.dehcors.teleconsultorapp.models;

/**
 * Created by Icons4u TI on 15/06/2017.
 */

public class Consulta {
    private String cpfUsuario;
    private String tipoConsulta ;
    private int idConsulta ;
    private String cpfPaciente ;
    private String especialidade ;
    private int idUsuario ;
    private int idParecer ;
    private String txCaso;
    private int atendida;

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public int getAtendida() {
        return atendida;
    }

    public void setAtendida(int atendida) {
        this.atendida = atendida;
    }

    public String getTxCaso() {
        return txCaso;
    }

    public void setTxCaso(String txCaso) {
        this.txCaso = txCaso;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
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
        String atendida ="";
        if(getAtendida()==0){
            atendida = "Não atendida";
        } else {
            atendida = "Atendida";
        }

        return getTipoConsulta()+"-"+atendida;
    }
}
