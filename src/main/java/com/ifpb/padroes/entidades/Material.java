
package com.ifpb.padroes.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Material implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tombamento;
    private String nome;
    
    public Material() {
        
    }

    public Material(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getTombamento() {
        return tombamento;
    }

    public void setTombamento(int tombamento) {
        this.tombamento = tombamento;
    }

}
