package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Usuario;
import com.ifpb.padroes.interfaces.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ifpb.padroes.interfaces.UsuarioDao;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;

public class Login implements Command {

    @EJB
    private UsuarioDao dao;

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        try {
            String login = requisicao.getParameter("login");
            String senha = requisicao.getParameter("senha");
            
//            System.out.println("Login: " + login + " Senha: " + senha);
            
            Usuario auxiliar = dao.autentica(login, senha);
            if (auxiliar != null) {
                HttpSession sessao = requisicao.getSession();
                sessao.setAttribute("usuarioLogado", auxiliar);
                resposta.sendRedirect("inicial.jsp");
            } else {
                resposta.sendRedirect("index.html");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
