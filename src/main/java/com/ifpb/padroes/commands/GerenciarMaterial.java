/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Material;
import com.ifpb.padroes.entidades.MaterialDTO;
import com.ifpb.padroes.enums.EstadoMaterial;
import com.ifpb.padroes.facade.FacadeAlocacaoSala;
import com.ifpb.padroes.interfaces.Command;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifpb.padroes.interfaces.MaterialDao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 *
 * @author Rudan
 */
public class GerenciarMaterial implements Command{
    
    @Inject
    private FacadeAlocacaoSala facadeAlocacaoSala;

    @EJB
    private MaterialDao materialDao;
        
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        
        List<Material> todosOsMateriais = materialDao.listarTodos();
        List<Material> materiaisDisponiveis = facadeAlocacaoSala.listarMateriaisDisponiveis();
        List<MaterialDTO> representacoesMaterialDTO = new ArrayList<>();
        
        Iterator<Material> itm = todosOsMateriais.iterator();
            while(itm.hasNext()){
                Material material = itm.next();
                int tombamento = material.getTombamento();
                
                MaterialDTO  materialDTO = new MaterialDTO();
                materialDTO.setTombamento(material.getTombamento());
                materialDTO.setNome(material.getNome());
                
                Iterator<Material> imd = materiaisDisponiveis.iterator();
                
                boolean alocado = false;
                while (imd.hasNext()) {
                    if(imd.next().getTombamento()== tombamento){
                        alocado = true;
                    }
                }
                
                if(alocado == true)
                    materialDTO.setStatus(EstadoMaterial.Disponivel);
                else
                    materialDTO.setStatus(EstadoMaterial.Indisponivel);
                
                representacoesMaterialDTO.add(materialDTO);
                
            }
                
        
        
            
        requisicao.setAttribute("materiais", representacoesMaterialDTO);
        
        String pesquisa = requisicao.getParameter("pesquisa");        
        
        if((pesquisa == null) || (pesquisa.equals(""))) {
            requisicao.setAttribute("materiais", representacoesMaterialDTO);
        } else {
            List<Material> materiais = materialDao.listarTodos();
            List<Material> resultPesquisa = new ArrayList<>();
            
            for(Material m: materiais) {
                if(m.getNome().startsWith(pesquisa, 0)) resultPesquisa.add(m);
            }
            
            requisicao.setAttribute("materiais", resultPesquisa);
        }
        
        RequestDispatcher dispatcher = requisicao.getRequestDispatcher("gerenciarMaterial.jsp");
        try {
            dispatcher.forward(requisicao, resposta);
        } catch (IOException | ServletException ex) {
            ex.printStackTrace();
        } 
    }
    
}
