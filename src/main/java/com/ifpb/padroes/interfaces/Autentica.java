
package com.ifpb.padroes.interfaces;

import com.ifpb.padroes.entidades.Usuario;

public interface Autentica {
    
    Usuario autentica(String login, String senha);
    
}
