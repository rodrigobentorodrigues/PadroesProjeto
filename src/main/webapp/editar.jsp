<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="frontController" method="POST">
            <input type="hidden" name="comando" value="Atualizar"/>
            <input type="hidden" name="id" value="${usuarioEdit.id}"/>
            <input type="hidden" name="matricula" value="${usuarioEdit.matricula}"/>
            Nome: <input type="text" name="nome" value="${usuarioEdit.nome}"/><br>
            Senha: <input type="password" name="senha" value="${usuarioEdit.senha}"/><br>
            Email: <input type="email" name="email" value="${usuarioEdit.email}"/><br>
            Papel: <select name="papel">
                <option>Administrador</option>
                <option>Assistente</option>
                <option>Professor</option>
            </select><br>
            <input type="submit" value="Atualizar"/>
        </form>
    </body>
</html>
