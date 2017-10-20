<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
        <!-- Estilo para resetar as config. dos navegadores -->
        <link href="css/reset.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="libs/bootstrap/bootstrap.min.css" rel="stylesheet">
        <!-- CSS -->
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h2>Atualizar dados de Bloco</h2>
            <hr>
            <form action="frontController" method="POST">
                <input type="hidden" name="comando" value="AtualizarBloco"/>
                <input type="hidden" name="id" value="${blocoEdit.id}"/>   
                <div class="form-group">
                    <label class="form-control-label" for="nome">Nome:</label>
                    <input name="nome" type="text" class="form-control" id="nome" value="${blocoEdit.nome}"/>
                </div>
                <div class="col-md-offset-11">
                    <button type="submit" class="btn btn-success">Atualizar</button>
                </div>
            </form>
            <a href="inicial.jsp"><button class="btn btn-primary" title="Voltar">Voltar</button></a>
        </div>
    </body>
</html>
