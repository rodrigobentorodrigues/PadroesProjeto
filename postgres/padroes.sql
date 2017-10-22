CREATE TABLE usuario (
    id SERIAL primary key,
    nome varchar(50) not null,
    email varchar(60) not null,
    senha varchar(20) not null,
    matricula int not null,
    papel varchar(16) not null
);

INSERT INTO usuario VALUES (1, 'admin', 'admin@gmail.com', 'admin123', '999999', 'Administrador');