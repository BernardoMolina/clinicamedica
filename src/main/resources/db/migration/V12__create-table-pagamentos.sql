create table pagamentos(

                           id serial not null primary key ,
                           idconsulta int ,
                           idexame int ,
                           formadepagamento varchar(50) not null,
                           valor float not null,
                           foreign key (idconsulta) references consultas(id),
                           foreign key (idexame) references exames(id)
)