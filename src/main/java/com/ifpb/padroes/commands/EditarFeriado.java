package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Feriado;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.FeriadoDao;
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
public class EditarFeriado implements Command {

    @EJB
    private FeriadoDao dao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        int id = Integer.parseInt(requisicao.getParameter("id"));
        Feriado feriado = dao.buscaPorId(id);
        requisicao.setAttribute("feriado", feriado);
        RequestDispatcher despachante = requisicao.getRequestDispatcher("editarFeriado.jsp");
        try {
            despachante.forward(requisicao, resposta);
        } catch (ServletException ex) {
            Logger.getLogger(EditarFeriado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EditarFeriado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
