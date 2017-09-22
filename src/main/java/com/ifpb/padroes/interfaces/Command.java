
package com.ifpb.padroes.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    
    void execute(HttpServletRequest requisicao, HttpServletResponse resposta);
    
}
