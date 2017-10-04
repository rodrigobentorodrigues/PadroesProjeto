/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.GerenciadorMaterial;
import com.ifpb.padroes.interfaces.Command;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifpb.padroes.interfaces.MaterialDao;
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
        
        RequestDispatcher dispatcher = requisicao.getRequestDispatcher("gerenciarMaterial.jsp");
        try {
            dispatcher.forward(requisicao, resposta);
        } catch (IOException | ServletException ex) {
            ex.printStackTrace();
        } 
    }
    
}
