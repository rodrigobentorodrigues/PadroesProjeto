<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Feriado</title>
        <!-- Estilo para resetar as config. dos navegadores -->
        <link href="css/reset.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="libs/bootstrap/bootstrap.min.css" rel="stylesheet">
        <!-- CSS -->
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h2>Atualizar dados de feriado</h2>
            <hr>
            <form action="frontController" method="POST">
                <input type="hidden" name="comando" value="AtualizarFeriado"/>
                <input type="hidden" name="id" value="${feriadoEdit.id}"/>
                <div class="form-group">
                    <label class="form-control-label" for="nome">Nome:</label>
                    <input name="nome" type="text" class="form-control" id="nome" value="${feriadoEdit.nome}"/>
                </div>
                <div class="form-group">
                    <label class="form-control-label" for="data">Data:</label>
                    <input name="data" type="date" class="form-control" id="data" value="${feriadoEdit.dataFeriado}"/>
                </div>
                <div class="col-md-offset-11">
                    <button type="submit" class="btn btn-success">Atualizar</button>
                </div>
            </form>  
        </div>

    </body>
</html>
