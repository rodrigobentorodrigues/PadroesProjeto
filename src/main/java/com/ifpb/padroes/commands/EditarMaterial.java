package com.ifpb.padroes.commands;

import com.ifpb.padroes.entidades.Feriado;
import com.ifpb.padroes.entidades.Material;
import com.ifpb.padroes.interfaces.Command;
import com.ifpb.padroes.interfaces.FeriadoDao;
import com.ifpb.padroes.interfaces.MaterialDao;
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
public class EditarMaterial implements Command {

    @EJB
    private MaterialDao dao;
    
    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        int id = Integer.parseInt(requisicao.getParameter("id"));
        Material material = dao.buscaPorId(id);
        requisicao.setAttribute("Material", material);
        RequestDispatcher despachante = requisicao.getRequestDispatcher("editarMaterial.jsp");
        try {
            despachante.forward(requisicao, resposta);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(EditarMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
