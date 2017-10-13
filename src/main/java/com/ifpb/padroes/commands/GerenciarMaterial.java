/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Material;
import com.ifpb.padroes.interfaces.Command;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifpb.padroes.interfaces.MaterialDao;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

/**
 *
 * @author Rudan
 */
public class GerenciarMaterial implements Command{

    @EJB
    private MaterialDao dao;
        
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        requisicao.setAttribute("materiais", dao.listarTodos());
        
        String pesquisa = requisicao.getParameter("pesquisa");        
        
        if((pesquisa == null) || (pesquisa.equals(""))) {
            requisicao.setAttribute("materiais", dao.listarTodos());
        } else {
            List<Material> materiais = dao.listarTodos();
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
