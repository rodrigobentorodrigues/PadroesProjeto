
package com.ifpb.padroes.servlet;

import com.ifpb.padroes.interfaces.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.enterprise.inject.spi.CDI;
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
            // CDI
//            Command command = (Command) Class.
//                    forName("com.ifpb.padroes.commands." + comando).newInstance();
            Command command = (Command) CDI.current().getBeanManager().getBeans("com.ifpb.padroes.commands." + comando).iterator().next();
            
            command.execute(req, resp);
        } catch (Exception ex) {
            pw.print(ex);
        } 
    }            

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    
    
}
