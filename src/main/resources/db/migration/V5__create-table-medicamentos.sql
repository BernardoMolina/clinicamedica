create table medicamentos(

    id serial not null primary key ,
    idreceita int not null ,
    medicamento varchar(255) ,
    dosagem varchar(50) ,
    instrucoes varchar(255) ,
    foreign key (idreceita) references receitas(id)

);
