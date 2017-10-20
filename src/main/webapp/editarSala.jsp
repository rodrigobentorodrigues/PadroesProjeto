<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Sala</title>
        <!-- Estilo para resetar as config. dos navegadores -->
        <link href="css/reset.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="libs/bootstrap/bootstrap.min.css" rel="stylesheet">
        <!-- CSS -->
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h2>Atualizar Sala</h2>
            <hr>
            <form action="frontController" method="POST">
                <input type="hidden" name="comando" value="AtualizarSala"/>
                <input type="hidden" name="idSala" value="${Sala.id}"/>
                <div class="form-group">
                    <label class="form-control-label" for="nome">Nome:</label>
                    <input name="nome" type="text" class="form-control" id="nome" value="${Sala.nome}"/>
                </div>
                <div class="form-group">
                    <label for="bloco"><span class="glyphicon glyphicon-eye-open"></span>Bloco</label>
                    <select class="form-control" name="idBloco" id="idBloco" required> 
                        <option value="${Sala.bloco.id}">${Sala.bloco.nome}</option>
                        <c:forEach var="bloco" items="${requestScope.blocos}">
                            <option value="${bloco.id}">${bloco.nome}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label class="form-control-label" for="nome">Capacidade:</label>
                    <input name="capacidade" type="Number" class="form-control" id="capacidade" value="${Sala.capacidade}"/>
                </div>
                <div class="form-group">
                    <label for="sel1">Tipo:</label>
                    <select class="form-control" name="tipo" id="tipo">
                        <option value="${Sala.tipo}">${Sala.tipo}</option>
                        <option value="Comum">Comum</option>
                        <option value="Laboratorio">Laboratorio</option>
                        <option value="Oficina">Oficina</option>
                        <option value="Inteligente">Inteligente</option>
                    </select>
                </div>
                <div class="col-md-offset-11">
                    <button type="submit" class="btn btn-success">Atualizar</button>
                </div>
            </form>
            <a href="inicial.jsp"><button class="btn btn-primary" title="Voltar">Voltar</button></a>
        </div>

    </body>
</html>
