create table exames (

                        id serial not null primary key ,
                        idpaciente int not null,
                        idmedico int not null,
                        dataexame varchar(12) not null,
                        horaexame varchar(12) not null ,
                        status varchar(50) not null,
                        resultado varchar(200) ,
                        foreign key (idpaciente) references pacientes(id),
                        foreign key (idmedico) references medicos(id)
)