-- PACIENTES

INSERT INTO pacientes (id,nome, sobrenome, email, cpf, telefone, plano_de_saude, cep, numero, complemento, cidade, uf, bairro)
VALUES (1,'João', 'Silva', 'joaosilva@email.com', '132.211.813-20', '(11)98765-4321', 'Plano A', '12345-678', '100', 'Apto 101', 'São Paulo', 'SP', 'Centro');

INSERT INTO pacientes (id,nome, sobrenome, email, cpf, telefone, plano_de_saude, cep, numero, complemento, cidade, uf, bairro)
VALUES (2,'Maria', 'Santos', 'mariasantos@email.com', '245.255.824-51', '(22)87654-3210', 'Plano B', '23456-789', '200', 'Apto 202', 'Rio de Janeiro', 'RJ', 'Copacabana');

INSERT INTO pacientes (id,nome, sobrenome, email, cpf, telefone, plano_de_saude, cep, numero, complemento, cidade, uf, bairro)
VALUES (3,'Pedro', 'Oliveira', 'pedrooliveira@email.com', '358.299.835-82', '(33)76543-2109', 'Plano C', '34567-890', '300', null , 'Belo Horizonte', 'MG', 'Pampulha');

INSERT INTO pacientes (id,nome, sobrenome, email, cpf, telefone, plano_de_saude, cep, numero, complemento, cidade, uf, bairro)
VALUES (4,'Ana', 'Pereira', 'anapereira@email.com', '471.333.846-13', '(44)65432-1098', 'Plano D', '45678-901', '400','Apto 403' , 'Porto Alegre','RS','Moinhos de Vento');

INSERT INTO pacientes (id,nome, sobrenome, email, cpf, telefone, plano_de_saude, cep ,numero ,complemento ,cidade ,uf ,bairro)
VALUES (5,'Carlos','Ribeiro','carlosribeiro@email.com','584.367.857-44','(55)54321-0987','Plano E','56789-012','500','Apto 505' ,'Curitiba','PR','Batel');


--MEDICOS

INSERT INTO medicos (id,nome, sobrenome, email, cpf, telefone, especializacao, registro_medico, cep, numero, complemento, cidade, uf, bairro)
VALUES (1,'Lucas', 'Almeida', 'lucasAalmeida@email.com', '789.101.112-34', '(66)43210-9876', 'Dermatologia', 'A23888', '67890-123', '600', 'Apto 606', 'Florianópolis', 'SC', 'Centro');

INSERT INTO medicos (id,nome, sobrenome, email, cpf, telefone, especializacao, registro_medico, cep, numero, complemento, cidade, uf, bairro)
VALUES (2,'Julia', 'Rocha', 'juliarocha@email.com', '891.011.123-45', '(77)32109-8765', 'Pediatria', 'A23456', '78901-234', '700', null , 'Salvador', 'BA', 'Pituba');

INSERT INTO medicos (id,nome, sobrenome, email, cpf, telefone, especializacao, registro_medico, cep ,numero ,complemento ,cidade ,uf ,bairro)
VALUES (3,'Gabriel','Ferreira','gabrielferreira@email.com','901.111.234-56','(88)21098-7654','Ortopedia','C98345','89012-345','800','Apto 808' ,'Fortaleza','CE','Meireles');

INSERT INTO medicos (id,nome, sobrenome, email, cpf, telefone, especializacao, registro_medico, cep ,numero ,complemento ,cidade ,uf ,bairro)
VALUES (4,'Laura','Costa','lauracosta@email.com','011.121.345-67','(99)10987-6543','Ginecologia','C12345','90123-456','900','Apto 909' ,'Recife','PE','Boa Viagem');

INSERT INTO medicos (id,nome, sobrenome, email, cpf, telefone, especializacao, registro_medico ,cep ,numero ,complemento ,cidade ,uf ,bairro)
VALUES (5,'Rafael','Santana','rafaelsantana@email.com','121.131.456-78','(21)09876-5432','Cardiologia','A12234','91234-567','1000' ,'Apto 1001' ,'Natal' ,'RN' ,'Ponta Negra');


--CONSULTAS

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (1,1, 1, '2023-11-01', '09:00:00', 'Agendado');

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (2,2, 2, '2023-11-02', '10:00:00', 'Agendado');

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (3,3, 3, '2023-11-03', '11:00:00', 'Agendado');

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (4,4, 4, '2023-11-04', '14:00:00', 'Agendado');

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (5,5, 5, '2023-11-05', '15:00:00', 'Agendado');

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (6,2, 3, '2023-11-16', '10:00:00', 'Cancelado');

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (7,4, 5, '2023-11-18', '14:00:00', 'Cancelado');

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (8,3, 4, '2023-11-19', '11:00:00', 'Concluído');

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (9,4, 3, '2023-11-20', '14:00:00', 'Concluído');

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (10,5, 2, '2023-11-21', '15:00:00', 'Concluído');

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (11,1, 5, '2023-11-22', '09:00:00', 'Concluído');

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (12,2, 1, '2023-11-23', '10:00:00', 'Concluído');

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (13,3, 2, '2023-11-24', '11:00:00', 'Concluído');

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (14,4, 1, '2023-11-25', '14:00:00', 'Concluído');

INSERT INTO consultas (id,idpaciente, idmedico, dataconsulta, horaconsulta, status)
VALUES (15,5, 4, '2023-11-26', '15:00:00', 'Concluído');

--RECEITAS

INSERT INTO receitas (id,idconsulta, dataprescricao, datavalidade)
VALUES (1,8, '2023-11-19', '2023-12-19');

INSERT INTO receitas (id,idconsulta, dataprescricao, datavalidade)
VALUES (2,9, '2023-11-20', '2023-12-20');

INSERT INTO receitas (id,idconsulta, dataprescricao, datavalidade)
VALUES (3,10, '2023-11-21', '2023-12-21');

INSERT INTO receitas (id,idconsulta, dataprescricao, datavalidade)
VALUES (4,11, '2023-11-22', '2023-12-22');

INSERT INTO receitas (id,idconsulta, dataprescricao, datavalidade)
VALUES (5,12, '2023-11-23', '2023-12-23');

INSERT INTO receitas (id,idconsulta, dataprescricao, datavalidade)
VALUES (6,13, '2023-11-24', '2023-12-24');

INSERT INTO receitas (id,idconsulta, dataprescricao, datavalidade)
VALUES (7,14, '2023-11-25', '2023-12-25');

INSERT INTO receitas (id,idconsulta, dataprescricao, datavalidade)
VALUES (8,15, '2023-11-26', '2023-12-26');

--MEDICAMENTOS

INSERT INTO medicamentos (id,idreceita, medicamento, dosagem, instrucoes)
VALUES (1,1, 'Medicamento A', '500mg', 'Tomar 1 vez ao dia após a refeição');

INSERT INTO medicamentos (id,idreceita, medicamento, dosagem, instrucoes)
VALUES (2,2, 'Medicamento B', '250mg', 'Tomar 2 vezes ao dia');

INSERT INTO medicamentos (id,idreceita, medicamento, dosagem, instrucoes)
VALUES (3,3, 'Medicamento C', '100mg', 'Tomar 1 vez ao dia');

INSERT INTO medicamentos (id,idreceita, medicamento, dosagem, instrucoes)
VALUES (4,4, 'Medicamento D', '50mg', 'Tomar 1 vez ao dia antes da refeição');

INSERT INTO medicamentos (id,idreceita, medicamento, dosagem, instrucoes)
VALUES (5,5, 'Medicamento E', '200mg', 'Tomar 2 vezes ao dia após a refeição');

INSERT INTO medicamentos (id,idreceita, medicamento, dosagem, instrucoes)
VALUES (6,6, 'Medicamento F', '150mg', 'Tomar 1 vez ao dia');

INSERT INTO medicamentos (id,idreceita, medicamento, dosagem, instrucoes)
VALUES (7,7, 'Medicamento G', '300mg', 'Tomar 1 vez ao dia após a refeição');

INSERT INTO medicamentos (id,idreceita, medicamento, dosagem, instrucoes)
VALUES (8,8, 'Medicamento H', '350mg', 'Tomar 2 vezes ao dia');

--USUARIOS

INSERT INTO usuarios (id,login, senha, permissao)
VALUES (1,'admin@gmail.com', '123', 'ROLE_ADMIN');

INSERT INTO usuarios (id,login, senha, permissao)
VALUES (2,'paciente@gmail.com', '123', 'ROLE_PACIENTE');

INSERT INTO usuarios (id,login, senha, permissao)
VALUES (3,'medico@gmail.com', '123', 'ROLE_MEDICO');









