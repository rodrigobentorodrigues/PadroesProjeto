
package com.ifpb.padroes.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "minha_seq_feriado", 
        sequenceName = "seq_feriado",
        allocationSize = 1,
        initialValue = 1)
public class Feriado implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minha_seq_feriado")
    private int id;
    private String nome;
    private LocalDate data;

    public Feriado(String nome, LocalDate data) {
        this.nome = nome;
        this.data = data;
    }

    public Feriado() {
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
