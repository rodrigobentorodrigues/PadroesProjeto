/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.entidades;

import com.ifpb.padroes.enums.EstadoMaterial;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Rudan
 */
@MappedSuperclass
public abstract class MaterialPrototype implements Serializable {
    
    @Column(length = 50)
    private String nome;
    protected EstadoMaterial estado;
    protected String localAtual;

    public MaterialPrototype(String nome) {
        this.nome = nome;
        this.estado = EstadoMaterial.Disponivel;
        this.localAtual = "n/s";
    }

    public MaterialPrototype() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoMaterial getEstado() {
        return estado;
    }

    public void setEstado(EstadoMaterial estado) {
        this.estado = estado;
    }

    public String getLocalAtual() {
        return localAtual;
    }

    public void setLocalAtual(String localAtual) {
        this.localAtual = localAtual;
    }

    public abstract Material clonar(MaterialPrototype materialPrototype);
}
