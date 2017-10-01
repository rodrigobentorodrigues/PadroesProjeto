
package com.ifpb.padroes.commands;

import com.ifpb.padroes.daos.GerenciadorBloco;
import com.ifpb.padroes.entidades.Bloco;
import com.ifpb.padroes.interfaces.BlocoDao;
import com.ifpb.padroes.interfaces.Command;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditarBloco implements Command{

    private BlocoDao dao = new GerenciadorBloco();
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        int id = Integer.parseInt(requisicao.getParameter("id"));
        // Modificar Generics, não necessario fazer o Parser
        Bloco bloco = (Bloco) dao.buscaPorId(id);
        requisicao.setAttribute("blocoEdit", bloco);
        RequestDispatcher despachante = requisicao.getRequestDispatcher("editarBloco.jsp");
        try {
            despachante.forward(requisicao, resposta);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        } 
    }
    
}
