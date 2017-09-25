$('#btnLogin').click((event) => {
    event.preventDefault();

    var login = $('#login').val();
    var senha = $('#senha').val();

    // console.log(login, senha)

    

    var xhttp = new XMLHttpRequest();
    xhttp.open('POST', `http://localhost:8080/padroesprojeto/frontController?login=${login}&senha=${senha}&comando=Login`);

    xhttp.onload = () => {
        if(xhttp.status == 200) alert('okay');
    }

    xhttp.send();    
})