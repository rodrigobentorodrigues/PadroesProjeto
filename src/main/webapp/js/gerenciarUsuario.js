/*
 * author: Natan Severo
 */

$(document).ready(function () {
    $("#cadastrarUsuario").click(function () {
        $("#modalCadastrarUsuario").modal();
        console.log("clicado");
    });
    
    $('#btnCadastrar').click(function(event) {
        event.preventDefault();
        
        var nome = $('#nome').val();
        var email = $('#email').val();
        var senha = $('#senha').val();
        var matricula = $('#matricula').val();
        var papel = $('#papel').val();

        var email_regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        
        var nome_regex = /^[A-Za-z0-9]+(?:[][A-Za-z0-9]+)*$/
        
        if(nome_regex.test(nome) && email_regex.test(email) && senha && matricula && papel) {
            var url = `http://localhost:8080/padroesprojeto/frontController?comando=AdicionarUsuario&nome=${nome}&email=${email}&senha=${senha}&matricula=${matricula}&papel=${papel}`;
            
            $.post(url, function(status){
                window.location = '/padroesprojeto/frontController?comando=GerenciarUsuarios';
            });
        } else {
            var msg = `Verifique se não há algum campo vazio ou com caractere especial!`;
            $('#msgAlerta')
                .text(msg)
                .addClass('alert-danger')
                .css('font-weight', 'bold')
                .css('font-size', '18px');
        }
    });
});
