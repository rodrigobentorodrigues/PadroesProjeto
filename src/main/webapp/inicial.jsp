<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Inicial</title>
    </head>
    <body>
        <h3>ID: ${usuarioLogado.id} </h3>
        <h3>Nome: ${usuarioLogado.nome} </h3>
        <h3>Senha: ${usuarioLogado.senha}</h3>
        <h3>Email: ${usuarioLogado.email} </h3>
        <h3>Matricula: ${usuarioLogado.matricula} </h3>
        <h3>Papel: ${usuarioLogado.papel} </h3>
    </body>
</html>