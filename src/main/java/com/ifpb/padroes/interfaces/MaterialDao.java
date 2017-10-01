package com.ifpb.padroes.interfaces;

import com.ifpb.padroes.entidades.Material;
import com.ifpb.padroes.entidades.MaterialPrototype;
import java.util.List;

public interface MaterialDao{

    void adicionar(MaterialPrototype materialPrototype, int quantidade);
    void remover(int tombamento);
    void atualizar(Material material);
    Material buscaPorId(int id);
    List<Material> listarTodos();
    
}