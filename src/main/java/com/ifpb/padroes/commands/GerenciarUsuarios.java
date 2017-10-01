package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.GerenciadorUsuario;
import com.ifpb.padroes.entidades.Usuario;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.UsuarioDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    comando=GerenciarUsuarios
    pesquisa=Valor
*/
public class GerenciarUsuarios implements Command {

    private UsuarioDao dao = new GerenciadorUsuario();

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
//        requisicao.setAttribute("usuarios", dao.listarTodos());
        String pesquisa = requisicao.getParameter("pesquisa");
        
        if(pesquisa.equals("")) {
            requisicao.getSession().setAttribute("usuarios", dao.listarTodos());
        } else {
            List<Usuario> usuarios = dao.listarTodos();
            List<Usuario> resultPesquisa = new ArrayList<>();
            
            for(Usuario u: usuarios) {
                if(u.getNome().startsWith(pesquisa, 0)) resultPesquisa.add(u);
            }
            
            requisicao.getSession().setAttribute("usuarios", resultPesquisa);
        }     
        
        String url = resposta.encodeURL("gerenciarUsuarios.jsp");
        try {
            resposta.sendRedirect(url);
//        RequestDispatcher despachante = requisicao.getRequestDispatcher(url);
//        despachante.forward(requisicao, resposta);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
