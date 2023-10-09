ALTER TABLE consultas DROP COLUMN dataconsulta;
ALTER TABLE consultas DROP COLUMN horaconsulta;

ALTER TABLE receitas DROP COLUMN dataprescricao;
ALTER TABLE receitas DROP COLUMN datavalidade;


ALTER TABLE consultas ADD dataconsulta varchar(12) not null;
ALTER TABLE consultas ADD horaconsulta varchar(12) not null;

ALTER TABLE receitas ADD dataprescricao varchar(12) not null;
ALTER TABLE receitas ADD datavalidade varchar(12) not null;