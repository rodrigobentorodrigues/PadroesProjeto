
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
    
    public Material() {
        super();
    }

    public Material(String nome) {
        super(nome);
    }

    @Override
    public Material clonar(MaterialPrototype prototipo) {
        return new Material(prototipo.getNome());
    }

    
 
}
