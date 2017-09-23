
package com.ifpb.padroes.entidades;

import com.ifpb.padroes.enums.TipoSala;

public class Sala {
    
    private String nome;
    private Bloco bloco;
    private int capacidade;
    private TipoSala tipo;

    public Sala() {
    }

    public Sala(String nome, Bloco bloco, int capacidade, TipoSala tipo) {
        this.nome = nome;
        this.bloco = bloco;
        this.capacidade = capacidade;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public TipoSala getTipo() {
        return tipo;
    }

    public void setTipo(TipoSala tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Sala{" + "nome=" + nome + ", bloco=" + bloco + ", capacidade=" + capacidade + ", tipo=" + tipo + '}';
    }
    
}
