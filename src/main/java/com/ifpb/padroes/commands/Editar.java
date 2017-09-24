
package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.UsuarioDao;
import com.ifpb.padroes.entidades.Usuario;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.Dao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Editar implements Command {

    private Dao dao = new UsuarioDao();
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        int id = Integer.parseInt(requisicao.getParameter("id"));
        Usuario usuario = (Usuario) dao.buscaPorId(id);
        requisicao.setAttribute("usuarioEdit", usuario);
        RequestDispatcher despachante = requisicao.getRequestDispatcher("editar.jsp");
        try {
            despachante.forward(requisicao, resposta);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
