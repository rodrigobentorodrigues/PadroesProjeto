package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.GerenciadorUsuario;
import com.ifpb.padroes.entidades.Usuario;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.UsuarioDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirUsuario implements Command {

    @EJB
    private UsuarioDao dao;

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        int id = Integer.parseInt(requisicao.getParameter("id"));
        Usuario usuario = new Usuario();
        usuario.setId(id);
        dao.remover(usuario);
        try {
            // Tratar essa parte da String de resposta. Na pagina inicial.jsp tbm
            resposta.sendRedirect("frontController?comando=GerenciarUsuarios");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
