
package com.ifpb.padroes.entidades;

import java.time.LocalDate;

public class Evento {
    
    private String nome;
    private String descricao;
    private int numeroParticipantes;
    private Usuario responsavel;
    private LocalDate inicio;
    private LocalDate fim;

    public Evento() {
    }

    public Evento(String nome, String descricao, int numeroParticipantes, Usuario responsavel, LocalDate inicio, LocalDate fim) {
        this.nome = nome;
        this.descricao = descricao;
        this.numeroParticipantes = numeroParticipantes;
        this.responsavel = responsavel;
        this.inicio = inicio;
        this.fim = fim;
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

    @Override
    public String toString() {
        return "Evento{" + "nome=" + nome + ", descricao=" + descricao + ", numeroParticipantes=" + numeroParticipantes + ", responsavel=" + responsavel + ", inicio=" + inicio + ", fim=" + fim + '}';
    }  
    
}
