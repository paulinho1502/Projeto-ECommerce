-- E um comentario!
/* 
 Comentario de multiplas linhas!
 */

-- DDL - criar - Create (Scema, Tabela)
Create Schema clinica; 

-- create table <SCHEMA , NOME_DA_TABELA>
Create Table clinica.medico (
   -- Informar Colunas
   -- NOME_DA_COLUNA TIPO_DE_DADO
   -- PRIMARY KEY - CAHVE PRIMARIA
   -- GENERETE ALWAYS AS IDENTY - A CHAVE E CRIADA AUTOMATICAMENTE
   id_medico INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   nome TEXT Not Null,
   crm TEXT Not Null,
   especialidade TEXT Not Null
);
Create Table clinica.paciente (
   id_paciente INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
   nome TEXT Not Null,
   idade INT Not Null,
   data_nascimento DATE Not Null
);

CREATE TABLE clinica.clinica (
id_clinica INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
nome TEXT Not Null,
descricao TEXT Not Null,
endereco TEXT
);

CREATE TABLE clinica.consulta (
  id_consulta INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  data TIMESTAMPTZ Not Null,
  valor NUMERIC (10, 4),
  id_medico INT Not Null,
  FOREIGN KEY (id_medico) REFERENCES clinica.medico(id_medico),
  -- Maneira abreviada
  id_clinica INT Not Null REFERENCES clinica.clinica(id_clinica),
  id_paciente INT Not Null REFERENCES clinica.paciente(id_paciente) 
);

--Apagar Tabela - DROP
/*
DROP TABLE clinica.consulta;
DROP TABLE clinica.clinica;
DROP TABLE clinica.paciente;
DROP TABLE clinica.medico;
*/
