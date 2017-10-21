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
            <h2>Atualizar dados de usuário</h2>
            <hr>
            <form action="frontController" method="POST">
                <input type="hidden" name="comando" value="AtualizarUsuario"/>
                <input type="hidden" name="id" value="${usuarioEdit.id}"/>
                <input type="hidden" name="matricula" value="${usuarioEdit.matricula}"/>
                <div class="form-group">
                    <label class="form-control-label" for="nome">Nome:</label>
                    <input name="nome" type="text" class="form-control" id="nome" value="${usuarioEdit.nome}"/>
                </div>
                <div class="form-group">
                    <label class="form-control-label" for="email">Email:</label>
                    <input name="email" type="text" class="form-control" id="email" value="${usuarioEdit.email}"/>
                </div>
                <div class="form-group">
                    <label class="form-control-label" for="senha">Senha:</label>
                    <input name="senha" type="text" class="form-control" id="senha" value="${usuarioEdit.senha}"/>
                </div>
                <div class="form-group">
                    <label class="form-control-label" for="papel">Papel:</label>
                    <select name="papel" id="papel" class="form-control">
                        <option>Administrador</option>
                        <option>Assistente</option>
                        <option>Professor</option>
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
