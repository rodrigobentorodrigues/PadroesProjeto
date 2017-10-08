/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.commands;

import com.ifpb.padroes.interfaces.Command;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author natan
 */
public class Logout implements Command {

    @Override
    public void execute(HttpServletRequest requisicao, HttpServletResponse resposta) {
        HttpSession sessao = requisicao.getSession();
        sessao.setAttribute("usuarioLogado", null);
        try {
            resposta.sendRedirect("index.html");
        } catch (IOException ex) {
            Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
