
package com.ifpb.padroes.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "minha_seq_bloco",
        sequenceName = "seq_blo",
        initialValue = 1, allocationSize = 1)
public class Bloco implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minha_seq_bloco")
    private int id;
    private String nome;
    
    @OneToMany(mappedBy = "bloco")
    private List<Sala> salas;

    public Bloco() {
        this.salas = new ArrayList<>();
    }
    
    public Bloco(String nome){
        this();
        this.nome = nome;
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

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }
    
    public boolean addSala(Sala s){
        return this.salas.add(s);
    }
    
    public boolean removerSala(Sala s){
        return this.salas.remove(s);
    }

    @Override
    public String toString() {
        return "Bloco{" + "id=" + id + ", nome=" + nome + ", salas=" + salas + '}';
    }
        
}
