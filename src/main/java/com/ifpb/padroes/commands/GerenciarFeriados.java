package com.ifpb.padroes.commands;

import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.FeriadoDao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GerenciarFeriados implements Command {

    @EJB
    private FeriadoDao dao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        // Toda a logica de adicionar os feriados na tela
        String url = resposta.encodeURL("gerenciarFeriados.jsp");
        requisicao.setAttribute("feriados", dao.listarTodos());
        try {
//            resposta.sendRedirect(url);
            RequestDispatcher despachante = requisicao.getRequestDispatcher(url);
            despachante.forward(requisicao, resposta);
        } catch (ServletException ex) {
            Logger.getLogger(GerenciarFeriados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciarFeriados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
