<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Feriado</title>
        <!-- Estilo para resetar as config. dos navegadores -->
        <link href="css/reset.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="libs/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- CSS -->
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h2>Atualizar dados de feriado</h2>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Descricao</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                <form action="frontController" method="POST">
                    <input type="hidden" name="comando" value="AtualizarFeriado"/>
                    <input type="hidden" name="id" value="${feriadoEdit.id}"/>

                    <td>
                        <div class="form-group">              
                            <input name="data" type="date" class="form-control" id="data" value="${feriadoEdit.dataFeriado}" required=""/>
                        </div>
                    </td>
                    <td>
                        <div class="form-group">                            
                            <input name="nome" type="text" class="form-control" id="nome" value="${feriadoEdit.nome}" required=""/>
                        </div>
                    </td>
                    <td>
                        <button type="submit" class="btn btn-success" title="Atualizar Feriado"><span class="glyphicon glyphicon-floppy-disk"></span></button>
                    </td>
                </form>
                <td>
                    <form action="frontController" method="post">
                        <input type="hidden" name="comando" value="ExcluirFeriado">
                        <input type="hidden" name="id" value="${feriadoEdit.id}">
                        <button type="submit" class="btn btn-danger" title="Excluir Feriado"><span class="glyphicon glyphicon-trash"></span></button>
                    </form>
                </td>
                </tr> 
                </tbody>
            </table>
            <a href="inicial.jsp"><button class="btn btn-primary" title="Voltar">Voltar</button></a>
        </div>

    </body>
</html>
