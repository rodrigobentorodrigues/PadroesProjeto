package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Sala;
import com.ifpb.padroes.interfaces.BlocoDao;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.SalaDao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rodrigobento
 */
public class EditarSala implements Command {

    @EJB
    private SalaDao salaDao;
    @EJB
    private BlocoDao blocoDao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        int idSala = Integer.parseInt(requisicao.getParameter("idSala"));
        Sala sala = salaDao.buscaPorId(idSala);
        
        try {
            requisicao.setAttribute("Sala", sala);
            requisicao.setAttribute("blocos", blocoDao.listarTodos());
            RequestDispatcher despachante = requisicao.getRequestDispatcher("editarSala.jsp");
            despachante.forward(requisicao, resposta);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(EditarSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
