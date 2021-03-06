package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.GerenciadorBloco;
import com.ifpb.padroes.interfaces.BlocoDao;
import com.ifpb.padroes.interfaces.Command;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GerenciarBlocos implements Command {

    @EJB
    private BlocoDao dao;

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        try {
            requisicao.setAttribute("blocos", dao.listarTodos());
//        String url = resposta.encodeURL("gerenciarBlocos.jsp");
            RequestDispatcher despachante = requisicao.getRequestDispatcher("gerenciarBlocos.jsp");
            despachante.forward(requisicao, resposta);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }
    }

}
