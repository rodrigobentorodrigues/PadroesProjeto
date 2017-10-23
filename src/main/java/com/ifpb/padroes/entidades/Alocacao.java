/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author natan
 */
@Entity
public class Alocacao implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="id_sala")
    private Sala sala;
    
    @OneToMany(mappedBy = "alocacao")
    private List<Material> materiais;

    public Alocacao() {
        this.materiais = new ArrayList<>();
    }
    
    public Alocacao(int id, Evento evento) {
        this();
        this.id = id;
        this.evento = evento;
        this.sala = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }
    
    public boolean addMaterial(Material a){
        return this.materiais.add(a);
    }
    
    public boolean removerMaterial(Material a){
        return this.materiais.remove(a);
    }

    @Override
    public String toString() {
        return "Alocacao{" + "id=" + id + ", evento=" + evento + ", sala=" + sala + ", materiais=" + materiais + '}';
    }
     
}
