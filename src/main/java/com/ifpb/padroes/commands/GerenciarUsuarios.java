
package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.UsuarioDao;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.Dao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GerenciarUsuarios implements Command {

    private Dao dao = new UsuarioDao();
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        requisicao.setAttribute("usuarios", dao.listarTodos());
        RequestDispatcher despachante = requisicao.getRequestDispatcher("gerenciarUsu.jsp");
        try {
            despachante.forward(requisicao, resposta);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }
    }

    
}
