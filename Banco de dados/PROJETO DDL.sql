-- DML (Data Manipulation Language)
-- INSERT (Cadastrar)
-- UPDATE (Atualizar)
-- DELETE (Apaga)

-- OPCIONAL 
-- SET search_path TO clinica;
-- clinica.paciente -> paciente

--INSERT
INSERT INTO clinica.medico (nome, especialidade, crm) VALUES
('Paulo', 'Ortopedia', '123456'),
('Gabriel', 'Cardiologia', '456789')

-- DQL (Data Query Language) - Linguagem de consulta de dados
-- SELECT
-- SELECT <QUAIS-COLUNAS> FROM <SHEMA>.<TABELA>
SELECT * FROM clinica.medico;

INSERT INTO clinica.paciente (nome, idade, cpf,data_nascimento) VALUES
('Paulo', 17, '12345678912','2008-02-15')

SELECT * FROM clinica.paciente;

INSERT INTO clinica.clinica(nome, descricao, endereco) VALUES
('Clinica São Caetano', 'Clinica em São Caetano', 'Rua Niteroi' )

SELECT * FROM clinica.clinica;

INSERT INTO clinica.consulta(data, valor, id_medico, id_clinica, id_paciente) VALUES
('2025-08-29 09:30:00-03', 350.49, 1, 1, 2)

SELECT * FROM clinica.consulta;

UPDATE clinica.consulta
SET valor = 200.50
WHERE id_medico = 1;

UPDATE clinica.consulta
SET valor = 530
WHERE valor > 500 AND valor < 1000;

-- DELETE 
DELETE FROM clinica.medico
WHERE id_medico = 1;


