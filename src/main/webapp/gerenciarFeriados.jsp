<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feriados</title>
        <!-- Estilo para resetar as config. dos navegadores -->
        <link href="css/reset.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="libs/bootstrap/bootstrap.min.css" rel="stylesheet">
        <!-- CSS -->
        <link href="css/style.css" rel="stylesheet">
        
        <!-- Calendario -->
        <link rel='stylesheet' href='fullcalendar-3.6.1/fullcalendar.css' />
        <script src='js/jquery.min.js'></script>
        <script src='js/moment.min.js'></script>
        <script src='fullcalendar-3.6.1/fullcalendar.js'></script>
        <script src='fullcalendar-3.6.1/locale/pt-br.js'></script>

    </head>
    <body>
        <div class="container">
            <h2>Gerenciar Feriados</h2><br>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th colspan="4">
                            <div class="btn-group col-md-2">
                                <!--<a href="cadastro.html">-->
                                <button type="button" class="btn btn-primary" title="Adicionar Feriado" id="cadastrarFeriado"><span class="glyphicon glyphicon-plus"></span></button>
                                <!--</a>-->
                            </div>
                            <div class="input-group col-md-10 text-right">
                                <button type="button" class="btn btn-primary" title="Importar Feriados" id="importarFeriados"><span class="glyphicon glyphicon-open"></span>Importar</button>
                            </div>
                        </th>
                    </tr>
                    <tr>
                        <th>Nome</th>  
                        <th>Data</th>
                        <th>Editar</th>
                        <th>Excluir</th>                        
                    </tr>
                </thead>
                <tbody>
                    <div id="calendar"></div>
                
                </tbody>
            </table>
            <!--<a href="inicial.jsp">Voltar</a>-->
        </div>
        
        <div class="modal fade" role="dialog" id="modalCadastrarFeriado" >
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header cabecalho">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4><span class="glyphicon glyphicon-lock"></span>Cadastrar Feriado</h4>
                    </div>

                    <div class="modal-body corpo">
                        <form method="post" action="frontController">
                            <input type="hidden" name="comando" value="AdicionarFeriado"/>
                            <div class="form-group">
                                <label for="nome">Nome:</label>
                                    <input id="nome" class="form-control" type="text" name="nomeFeriado" required="required"/>
                            </div>
                            <div class="form-group">
                                <label for="data">Data</label>
                                <input id="data" class="form-control" type="date" name="data" required="required"/>
                            </div>
                            <button type="submit" id="btnCadastrarFeriado" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Cadastrar</button>
                        </form>  
                    </div>
                </div>
            </div>
        </div>

        <!--Modal de importar csv feriados--> 
        <div class="modal fade" role="dialog" id="modalImportarFeriados" >
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header cabecalho">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4><span class="glyphicon glyphicon-lock"></span>Importar Feriados</h4>
                    </div>

                    </span>
                    <div class="modal-body corpo">                    
                        <form enctype="multipart/form-data" action="frontController" method="post">
                            <div class="form-group">
                                <input type="hidden" name="comando" value="ImportarFeriados" />
                                <input type="file" name="csv" class="form-control" />
                            </div>

                            <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Importar CSV</button>

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
        $(document).ready(function() {
            $('#calendar').fullCalendar({
                theme: true,
                editable: false,
                events: "CalendarJsonServlet"
            });
        });
        </script>
        <script>
            $("#cadastrarFeriado").click(function () {
                $("#modalCadastrarFeriado").modal();
                console.log("clicado cadastrar feriado");
            });

            $("#importarFeriados").click(function () {
                $("#modalImportarFeriados").modal();
                console.log("clicado importar feriados");
            });
        </script>
    </body>
</html>
