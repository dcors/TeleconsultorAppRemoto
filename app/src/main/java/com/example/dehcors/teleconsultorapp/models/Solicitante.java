package com.example.dehcors.teleconsultorapp.models;

/**
 * Created by Icons4u TI on 12/06/2017.
 */

public class Solicitante {
    private int idSolicitante;
    private String agenteNome;
    private String AgenteCPF ;
    private String agenteTelefone;
    private String agenteEmail ;
    private String agenteProfissao;
    private String agenteUnidade ;
    private String agenteSenha;
    private String agenteRepitaSenha ;
    private String urlFoto;

    public int getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(int idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public String getAgenteNome() {
        return agenteNome;
    }

    public void setAgenteNome(String agenteNome) {
        this.agenteNome = agenteNome;
    }

    public String getAgenteCPF() {
        return AgenteCPF;
    }

    public void setAgenteCPF(String agenteCPF) {
        AgenteCPF = agenteCPF;
    }

    public String getAgenteTelefone() {
        return agenteTelefone;
    }

    public void setAgenteTelefone(String agenteTelefone) {
        this.agenteTelefone = agenteTelefone;
    }

    public String getAgenteEmail() {
        return agenteEmail;
    }

    public void setAgenteEmail(String agenteEmail) {
        this.agenteEmail = agenteEmail;
    }

    public String getAgenteProfissao() {
        return agenteProfissao;
    }

    public void setAgenteProfissao(String agenteProfissao) {
        this.agenteProfissao = agenteProfissao;
    }

    public String getAgenteUnidade() {
        return agenteUnidade;
    }

    public void setAgenteUnidade(String agenteUnidade) {
        this.agenteUnidade = agenteUnidade;
    }

    public String getAgenteSenha() {
        return agenteSenha;
    }

    public void setAgenteSenha(String agenteSenha) {
        this.agenteSenha = agenteSenha;
    }

    public String getAgenteRepitaSenha() {
        return agenteRepitaSenha;
    }

    public void setAgenteRepitaSenha(String agenteRepitaSenha) {
        this.agenteRepitaSenha = agenteRepitaSenha;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}
