
package com.ifpb.padroes.entidades;

import com.ifpb.padroes.enums.EstadoMaterial;

public class Material {

    private int numeroTomabamento;
    private String nome;
    private EstadoMaterial estado;

    public Material(int numeroTomabamento, String nome, EstadoMaterial est) {
        this.numeroTomabamento = numeroTomabamento;
        this.nome = nome;
        this.estado = est;
    }

    public Material() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroTomabamento() {
        return numeroTomabamento;
    }

    public void setNumeroTomabamento(int numeroTomabamento) {
        this.numeroTomabamento = numeroTomabamento;
    }

    public EstadoMaterial getEstado() {
        return estado;
    }

    public void setEstado(EstadoMaterial estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Material{" + "numeroTomabamento=" + numeroTomabamento + ", nome=" + nome + ", estado=" + estado + '}';
    }    
    
}
