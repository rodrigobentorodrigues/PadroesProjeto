
package com.ifpb.padroes.entidades;

import java.time.LocalDate;

public class Feriado {
    
    private String nome;
    private LocalDate data;

    public Feriado(String nome, LocalDate data) {
        this.nome = nome;
        this.data = data;
    }

    public Feriado() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Feriado{" + "nome=" + nome + ", data=" + data + '}';
    }
    
}
