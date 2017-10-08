
package com.ifpb.padroes.entidades;

import com.ifpb.padroes.conversores.ConversorData;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Temporal(TemporalType.DATE)
    @Convert(converter = ConversorData.class)
    private LocalDate dataFeriado;

    public Feriado(String nome, LocalDate data) {
        this.nome = nome;
        this.dataFeriado = data;
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

    public LocalDate getDataFeriado() {
        return dataFeriado;
    }

    public void setDataFeriado(LocalDate data) {
        this.dataFeriado = data;
    }

    @Override
    public String toString() {
        return "Feriado{" + "nome=" + nome + ", data=" + dataFeriado + '}';
    }
    
}
