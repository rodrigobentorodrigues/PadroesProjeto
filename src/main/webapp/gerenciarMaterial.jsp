<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Materiais</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Estilo para resetar as config. dos navegadores -->
        <link href="css/reset.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="libs/bootstrap/bootstrap.min.css" rel="stylesheet">
	<!-- CSS -->
        <link href="css/style.css" rel="stylesheet">
                        
        <style>
            .modal-header, h4, .close {
                background-color: #5cb85c;
                color:white !important;
                text-align: center;
                font-size: 30px;
            }
            .modal-footer {
                background-color: #f9f9f9;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Gerenciar Materiais</h2>        
            <table class="table table-hover">
              <thead>
                <tr>
                    <th colspan="4" class="teste">
                        <div class="btn-group col-md-1">
                            <button type="button" class="btn btn-primary" title="Adicionar Material" id="botaoCadastrarMaterial"><span class="glyphicon glyphicon-plus"></span></button>
                        </div>
                        <div class="input-group col-md-10">
                            <form class="form-inline" action="frontController" method="POST">
                                <input type="hidden" name="comando" value="GerenciarMaterial" />
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Buscar material..." name="pesquisa">
                                </div>

                                <button type="submit" class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                                    
                            </form>
                        </div>
                    </th>
                </tr>
                    
                <tr>
                  <th>Material</th>
                  <th>Tombamento</th>
                  <th>Status</th>
                  <th>Local</th>
                  <th>Devolver</th>
                  <th>Editar</th>
                  <th>Excluir</th>
                </tr>
              </thead>
              <tbody>
                  <c:forEach var="material" items="${materiais}">
                    <tr>
                      <td>${material.nome}</td>
                      <td>${material.tombamento}</td>
                      <td>#status</td>
                      <td>#local</td>
                      <td><button type="button" class="btn btn-primary" title="Devolver Material"><span class="glyphicon glyphicon-download"></span></button></td>
                      <td>
                        <form action="frontController" method="post">                       
                            <input type="hidden" name="comando" value="EditarMaterial">
                            <input type="hidden" name="tombamento" value="${material.tombamento}">
                            <button type="submit" class="btn btn-success" title="Editar Material"><span class="glyphicon glyphicon-pencil"></span></button>
                        </form>
                      </td>
                      <td>
                          <form action="frontController" method="post">
                              <input type="hidden" name="comando" value="ExcluirMaterial">
                              <input type="hidden" name="tombamento" value="${material.tombamento}">
                              <button type="submit" class="btn btn-danger" title="Excluir Material"><span class="glyphicon glyphicon-trash"></span></button>
                          </form>
                      </td>
                          
                    </tr>
                  </c:forEach>
              </tbody>
            </table>
            <a href="inicial.jsp"><button class="btn btn-primary" title="Voltar">Voltar</button></a>
          </div>
        
        <!-- Modal -->
        <div class="modal fade" id="modalCadastrarMaterial" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header" style="padding:35px 50px;">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4><span class="glyphicon glyphicon-lock"></span>Cadastrar Material</h4>
              </div>
              <div class="modal-body" style="padding:40px 50px;">
                  <form role="form" action="frontController" method="post">
                      <input type="hidden" name="comando" value="AdicionarMaterial"/>
                      <div class="form-group">
                        <label for="descricao"><span class="glyphicon glyphicon-user"></span>Descriçao</label>
                        <input type="text" class="form-control"  maxlength="50" name="descricao" id="descricao" placeholder="Descrição" required>
                      </div>
                      <div class="form-group">

<!--                        <label for="quantidade"><span class="glyphicon glyphicon-eye-open"></span>Quantidade</label>-->
                        <input type="hidden" class="form-control" name="quantidade" id="quantidade" value="1">

                      </div>
                        <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Cadastrar</button>
                </form>
              </div>
            </div>

          </div>
        </div> 
             

        <!-- Importando o jQuery -->
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

          <!-- Importando o js do bootstrap -->
          <script src="libs/bootstrap/bootstrap.min.js"></script>


 
        <script>
            $(document).ready(function(){
                $("#botaoCadastrarMaterial").click(function(){
                    $("#modalCadastrarMaterial").modal();
                });
            });
        </script>
    </body>
</html>
