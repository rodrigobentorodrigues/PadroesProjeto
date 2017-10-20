
package com.ifpb.padroes.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Material implements Serializable {
    private static Material material;
    private static String nomeMaterial;
    @Id
    @SequenceGenerator(name = "seq_tombamento" , sequenceName = "seq_tombamento", initialValue = 1111111, allocationSize = 2)
    @GeneratedValue(generator = "seq_tombamento", strategy = GenerationType.SEQUENCE)
    @Column(length = 7)
    private int tombamento;
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "id_alocacao")
    private Alocacao alocacao;
    
    public Material() {
        this.alocacao = null;
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
