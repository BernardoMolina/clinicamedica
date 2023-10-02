create table pacientes(

    id serial not null primary key ,
    nome varchar(50) not null ,
    sobrenome varchar(50) not null ,
    email varchar(100) not null unique ,
    cpf varchar(14) not null unique ,
    telefone varchar(14) not null unique ,
    plano_de_saude varchar(50) not null ,
    cep varchar(9) not null ,
    numero varchar(20) not null ,
    complemento varchar(100) ,
    cidade varchar(100) not null ,
    uf char(2) not null ,
    bairro varchar(100) not null

)