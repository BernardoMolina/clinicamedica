create table consultas (

    id serial not null primary key ,
    idpaciente int not null,
    idmedico int not null,
    dataconsulta date not null,
    horaconsulta time not null ,
    status varchar(50) not null,
    foreign key (idpaciente) references pacientes(id),
    foreign key (idmedico) references medicos(id)
)
