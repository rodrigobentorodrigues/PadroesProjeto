package com.ifpb.padroes.interfaces;

import com.ifpb.padroes.entidades.Material;
import java.util.List;

public interface MaterialDao{

    void adicionar(Material material, int quantidade);
    void remover(int tombamento);
    void atualizar(Material material);
    Material buscaPorId(int id);
    List<Material> buscarPorMateriaisNaoAlocados();
    Material buscarPorNome(String nomeMaterial);
    List<Material> listarTodos();
    
}