/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.entidades;

import com.ifpb.padroes.enums.EstadoMaterial;
import java.io.Serializable;

/**
 *
 * @author Rudan
 */
public class MaterialDTO implements Serializable {
    
    private int tombamento;
    private String nome;
    protected EstadoMaterial status;
    protected String local;

    public MaterialDTO() {
    }
    
    public MaterialDTO(int tombamento, String nome, EstadoMaterial status, String local) {
        this.tombamento = tombamento;
        this.nome = nome;
        this.status = status;
        this.local = local;
    }

    public int getTombamento() {
        return tombamento;
    }

    public void setTombamento(int tombamento) {
        this.tombamento = tombamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoMaterial getStatus() {
        return status;
    }

    public void setStatus(EstadoMaterial status) {
        this.status = status;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }


    
    
}
