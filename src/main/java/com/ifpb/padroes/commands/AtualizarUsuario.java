
package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.GerenciadorUsuario;
import com.ifpb.padroes.entidades.Usuario;
import com.ifpb.padroes.enums.Papel;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.UsuarioDao;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizarUsuario implements Command {
    
    private UsuarioDao dao = new GerenciadorUsuario();

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        int id = Integer.parseInt(requisicao.getParameter("id"));
        String nome = requisicao.getParameter("nome");
        String email = requisicao.getParameter("email");
        String senha = requisicao.getParameter("senha");
        int matricula = Integer.parseInt(requisicao.getParameter("matricula"));
        Papel papel = Enum.valueOf(Papel.class, requisicao.getParameter("papel"));
        Usuario usuario = new Usuario(nome, email, senha, matricula, papel); 
        usuario.setId(id);
        dao.atualizar(usuario);
        String url = resposta.encodeURL("frontController?comando=GerenciarUsuarios");
        try {
            resposta.sendRedirect(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
