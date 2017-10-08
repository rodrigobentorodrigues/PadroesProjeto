/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifpb.padroes.filters;

import com.ifpb.padroes.entidades.Usuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author natan
 * @desc Filtro responsável por verificar se o usuário está na sessão
 */
@WebFilter(
        filterName = "UsuarioLogado", urlPatterns = { "*.jsp" },
        servletNames = { "FrontController" },
        dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE }
)
public class UsuarioLogado implements Filter {

    private FilterConfig config;
    private PrintWriter out;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        try {
            out = new PrintWriter(new File("FilterLog.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuarioLogado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest reqForFilter = (HttpServletRequest) request;
        HttpServletResponse resForFilter = (HttpServletResponse) response;
        HttpSession session = reqForFilter.getSession();
        
        if(session.getAttribute("usuarioLogado") == null) {
            out.print("Usuário não está logado");
            resForFilter.sendRedirect("index.html");
        } else {
            Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
            out.println("Usuario "+usuario.getNome()+" logado");
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        config = null;
        out.close();
    }
    
}
