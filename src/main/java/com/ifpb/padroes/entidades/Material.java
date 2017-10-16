
package com.ifpb.padroes.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Material implements Serializable {
    private static Material material;
    private static String nomeMaterial;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tombamento;
    private String nome;
    
    
    public Material() {
        this.nome = nomeMaterial;
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

    public static String getNomeMaterial() {
        return nomeMaterial;
    }

    public static void setNomeMaterial(String nomeMaterial) {
        Material.nomeMaterial = nomeMaterial;
    }
    
    
    
    public int getTombamento() {
        return tombamento;
    }

    public void setTombamento(int tombamento) {
        this.tombamento = tombamento;
    }
    
    public static Material clonar(Material material){
        return material;
    }

}
