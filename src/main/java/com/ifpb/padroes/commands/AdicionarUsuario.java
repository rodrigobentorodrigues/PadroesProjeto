package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.UsuarioDao;
import com.ifpb.padroes.entidades.Usuario;
import com.ifpb.padroes.enums.Papel;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.Dao;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionarUsuario implements Command {

    private Dao dao = new UsuarioDao();

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        String nome = requisicao.getParameter("nome");
        String email = requisicao.getParameter("email");
        String senha = requisicao.getParameter("senha");
        int matricula = Integer.parseInt(requisicao.getParameter("matricula"));
        Papel papel = Enum.valueOf(Papel.class, requisicao.getParameter("papel"));
        Usuario usuario = new Usuario(nome, email, senha, matricula, papel);
        dao.adicionar(usuario);
        try {
            resposta.sendRedirect("index.html");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
