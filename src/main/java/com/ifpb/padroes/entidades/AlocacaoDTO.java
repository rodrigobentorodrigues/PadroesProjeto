/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.entidades;

import java.util.Date;

/**
 *
 * @author natan
 */
public class AlocacaoDTO {
    private Date dataHoraInicio;
    private String duracao;
    private String nomeEvento;
    private String situacao;
    private String local;

    public AlocacaoDTO(Date dataHoraInicio, String duracao, String nomeEvento, String situacao, String local) {
        this.dataHoraInicio = dataHoraInicio;
        this.duracao = duracao;
        this.nomeEvento = nomeEvento;
        this.situacao = situacao;
        this.local = local;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "AlocacaoDTO{" + "dataHoraInicio=" + dataHoraInicio + ", duracao=" + duracao + ", nomeEvento=" + nomeEvento + ", situacao=" + situacao + ", local=" + local + '}';
    }
    
    
}
