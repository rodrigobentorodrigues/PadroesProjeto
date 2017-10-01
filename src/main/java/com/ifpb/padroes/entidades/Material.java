
package com.ifpb.padroes.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Material extends MaterialPrototype implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tombamento;
    
    public Material(String nome) {
        super(nome);
    }

    public Material() {
        super();
    }

    @Override
    public Material clonar(MaterialPrototype materialPrototype) {
        return new Material(materialPrototype.getNome());
    }

}
