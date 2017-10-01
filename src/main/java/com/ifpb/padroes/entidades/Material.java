
package com.ifpb.padroes.entidades;

import java.io.Serializable;
import javax.persistence.Entity;


@Entity
public class Material extends MaterialPrototype implements Serializable {

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
