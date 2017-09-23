
package com.ifpb.padroes.entidades;

import java.util.ArrayList;
import java.util.List;

public class Bloco {
    
    private String nome;
    private List<Sala> salas;

    public Bloco() {
        this.salas = new ArrayList<>();
    }

    public Bloco(String nome, List<Sala> salas) {
        this.nome = nome;
        this.salas = salas;
    }
    
    public boolean addSala(Sala sala){
        return salas.add(sala);
    }
    
    public boolean removerSala(Sala sala){
        return salas.remove(sala);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    @Override
    public String toString() {
        return "Bloco{" + "nome=" + nome + ", salas=" + salas + '}';
    }
        
}
