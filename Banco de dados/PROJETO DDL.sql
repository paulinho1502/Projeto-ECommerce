-- E um comentario!
/* 
 Comentario de multiplas linhas!
 */

-- DDL - criar - Create (Scema, Tabela)
Create Schema clinica IF NOT EXISTS; 

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

-- ALTER - Alterar tabela

ALTER TABLE clinica.paciente
ADD COLUMN cpf VARCHAR(14) UNIQUE;
-- UNIQUE - impede que seja cadastrado algo que ja existe no banco

-- APAGAR COLUNA
ALTER TABLE clinica.paciente
DROP COLUMN cpf;

-- RENOMEAR TABELA
ALTER TABLE clinica.paciente
RENAME TO clinica.novopaciente;


-- TRUNCATE - Limpa a tabela
--TRUNCATE TABLE clinica.consulta RESTART IDENTITY;
-- RESTART IDENTITY - Renicia a sequencia

--Apagar Tabela - DROP
/*
DROP TABLE clinica.consulta;
DROP TABLE clinica.clinica;
DROP TABLE clinica.paciente;
DROP TABLE clinica.medico;
*/



CREATE SCHEMA ecommerce IF NOT EXISTS;

CREATE TABLE ecommerce.cliente(
id_cliente INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
nome_completo TEXT Not Null,
email TEXT Not Null,
senha TEXT Not Null,
telefone TEXT Not Null,
data_cadastro TIMESTAMPTZ Not Null
);

CREATE TABLE ecommerce.pedido(
id_pedido INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
data_pedido TIMESTAMPTZ Not Null,
valor_total NUMERIC(18, 4),
status TEXT Not Null,
id_cliente INT Not Null REFERENCES ecommerce.cliente(id_cliente)
);

CREATE TABLE ecommerce.produto(
id_produto INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
nome_produto TEXT Not Null,
descricao TEXT Not Null,
preco NUMERIC(10,4) Not Null,
estoque INT Not Null,
imagem_url TEXT Not Null
);

CREATE TABLE ecommerce.item_do_pedido(
id_item_do_pedido INt PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
quantidade INT Not Null,
id_pedido INT Not Null REFERENCES ecommerce.pedido(id_pedido),
id_produto INT Not Null REFERENCES ecommerce.produto(id_produto)
);

CREATE TABLE ecommerce.pagamento(
forma_pagamento TEXT Not Null,
status TEXT Not Null,
data_pagamento TIMESTAMPTZ Not Null,
id_pedido INT Not Null REFERENCES ecommerce.pedido(id_pedido)
);
