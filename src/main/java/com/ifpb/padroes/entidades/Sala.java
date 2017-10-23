
package com.ifpb.padroes.entidades;

import com.ifpb.padroes.enums.TipoSala;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Sala implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "bloco_id")
    private Bloco bloco;
    private int capacidade;
    @Enumerated(EnumType.STRING)
    private TipoSala tipo;
    
    @OneToOne(mappedBy = "sala", cascade = CascadeType.ALL)
    private Alocacao alocacao;

    public Sala() {
        this.alocacao = null;
    }

    public Sala(String nome, Bloco bloco, int capacidade, TipoSala tipo) {
        this();
        this.nome = nome;
        this.bloco = bloco;
        this.capacidade = capacidade;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Alocacao getAlocacao() {
        return alocacao;
    }

    public void setAlocacao(Alocacao alocacao) {
        this.alocacao = alocacao;
    }

    @Override
    public String toString() {
        return "Sala{" + "id=" + id + ", nome=" + nome + ", bloco=" + bloco + ", capacidade=" + capacidade + ", tipo=" + tipo + ", alocacao=" + alocacao + '}';
    }

    
}
