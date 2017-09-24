
package com.ifpb.padroes.commands;

import com.ifpb.padroes.interfaces.Command;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GerenciarFeriados implements Command {

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        // Toda a logica de adicionar os feriados na tela
        RequestDispatcher despachante = requisicao.getRequestDispatcher("gerenciarFer.jsp");
        try {
            despachante.forward(requisicao, resposta);
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
