
package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.BlocoDao;
import com.ifpb.padroes.entidades.Bloco;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.Dao;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionarBloco implements Command {
    
    private Dao dao = new BlocoDao();

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        String nome = requisicao.getParameter("nome");
        Bloco bloco = new Bloco(nome);
        dao.adicionar(bloco);
        try {
            resposta.sendRedirect("cadastroBloco.html");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
        
    
}
