package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.UsuarioDao;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.Dao;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GerenciarUsuarios implements Command {

    private Dao dao = new UsuarioDao();

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
//        requisicao.setAttribute("usuarios", dao.listarTodos());
        requisicao.getSession().setAttribute("usuarios", dao.listarTodos());

        String url = resposta.encodeURL("gerenciarUsu.jsp");
        try {
            resposta.sendRedirect(url);
//        RequestDispatcher despachante = requisicao.getRequestDispatcher(url);
//        despachante.forward(requisicao, resposta);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
