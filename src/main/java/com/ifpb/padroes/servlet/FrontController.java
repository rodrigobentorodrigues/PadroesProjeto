
package com.ifpb.padroes.servlet;

import com.ifpb.padroes.interfaces.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.util.AnnotationLiteral;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "front", urlPatterns = "/frontController")
public class FrontController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String comando = req.getParameter("comando");
        
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        PrintWriter pw = resp.getWriter();
        
        try {
            Command command = (Command) 
                    CDI.current().select(Class.forName("com.ifpb.padroes.commands." + comando), new AnnotationLiteral<Any>(){}).get();
            command.execute(req, resp);
        } catch (ClassNotFoundException ex) {
            pw.write(ex.getMessage());
        } 
    }            

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    
    
}
