<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciar Blocos</title>
    </head>
    <body>
        <h1>Gerenciar Blocos!</h1>
        <a href="cadastroBloco.html"> Adicionar Bloco</a><br><br>
        <table style="border: 1px solid black">
            <tr>
                <td>Nome</td>
                <td>Editar</td>
                <td>Excluir</td>
            </tr>
            <c:forEach var="bloco" items="${blocos}">
                <tr>
                <td>${bloco.nome}</td>
                <form action="frontController" method="POST">
                    <input type="hidden" name="comando" value="EditarBloco"/>
                    <input type="hidden" name="id" value="${bloco.id}"/>
                    <td><input type="submit" value="Editar"/></td>
                </form>
                <form action="#" method="POST">
                    <input type="hidden" name="comando" value="ExcluirBloco"/>
                    <input type="hidden" name="id" value="${bloco.id}"/>
                    <td><input type="submit" value="Excluir"/></td>
                </form>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="inicial.jsp">Voltar</a>        
    </body>
</html>
