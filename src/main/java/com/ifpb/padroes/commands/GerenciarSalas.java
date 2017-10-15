/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.interfaces.BlocoDao;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.SalaDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author natan
 */
public class GerenciarSalas implements Command {
//
    @EJB
    private SalaDao salaDao;
    @EJB
    private BlocoDao blocoDao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        try {
                       
            requisicao.setAttribute("salas", salaDao.listarTodos());
            requisicao.setAttribute("blocos", blocoDao.listarTodos());
            
            RequestDispatcher despachante = requisicao.getRequestDispatcher("gerenciarSalas.jsp");
            despachante.forward(requisicao, resposta);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }

    }
    
}
