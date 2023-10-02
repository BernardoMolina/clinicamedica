create table receitas (

    id serial not null primary key ,
    idconsulta int not null ,
    dataprescricao date not null ,
    datavalidade date not null ,
    foreign key (idconsulta) references consultas(id)
)
