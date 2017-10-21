
package com.ifpb.padroes.entidades;

import com.ifpb.padroes.conversores.ConversorData;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Evento implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String descricao;
    private int numeroParticipantes;
    
    @OneToOne
    private Usuario responsavel;
    
    @Temporal(TemporalType.DATE)
    @Convert(converter = ConversorData.class)
    private LocalDate inicio;
    @Temporal(TemporalType.DATE)
    @Convert(converter = ConversorData.class)
    private LocalDate fim;
    
    @OneToMany(mappedBy = "evento")
    private List<Alocacao> alocacoes;

    public Evento() {
        this.alocacoes = new ArrayList<>();
    }

    public Evento(String nome, String descricao, int numeroParticipantes, LocalDate inicio, LocalDate fim) {
        this();
        this.nome = nome;
        this.descricao = descricao;
        this.numeroParticipantes = numeroParticipantes;
        this.inicio = inicio;
        this.fim = fim;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public void setNumeroParticipantes(int numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public List<Alocacao> getAlocacoes() {
        return alocacoes;
    }

    public void setAlocacoes(List<Alocacao> alocacoes) {
        this.alocacoes = alocacoes;
    }
    
    public boolean addAlocacao(Alocacao a) {
        return this.alocacoes.add(a);
    }
    
    public boolean removeAlocacao(Alocacao a) {
        return this.alocacoes.remove(a);
    }

    @Override
    public String toString() {
        return "Evento{" + "nome=" + nome + ", descricao=" + descricao + ", numeroParticipantes=" + numeroParticipantes + ", responsavel=" + responsavel + ", inicio=" + inicio + ", fim=" + fim + ", alocacoes=" + alocacoes + '}';
    }


    
}
