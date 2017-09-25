
package com.ifpb.padroes.commands;

import com.ifpb.padroes.interfaces.Command;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GerenciarFeriados implements Command {

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        // Toda a logica de adicionar os feriados na tela
        String url = resposta.encodeURL("gerenciarFer.jsp");
        try {
            resposta.sendRedirect(url);
//        RequestDispatcher despachante = requisicao.getRequestDispatcher(url);
//            despachante.forward(requisicao, resposta);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         
    }
    
}
