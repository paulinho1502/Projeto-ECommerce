-- DQL - Consulta
SELECT nome_completo, telefone
FROM ecommerce.cliente;

SELECT nome, idade, cpf
FROM clinica.paciente;

SELECT * FROM clinica.medico;

-- JOIN (Juntar)
-- Com o JOIN posso juntar tabelas
-- Utilizando a chave estrangeira

SELECT 
   cs.data,
   cs.valor,
   med.nome
   FROM clinica.consulta AS cs
   JOIN
       clinica.medico AS med
	   ON 
	   cs.id_medico =
	   med.id_medico ;



	   SELECT
	   id_pedido,
	   nome_completo
	   FROM ecommerce.pedido
	   JOIN 
	   ecommerce.cliente 
	   ON
	   ecommerce.pedido.id_cliente =
	   ecommerce.cliente.id_cliente; 

	   SELECT 
	   nome_produto,
	   id_item_do_pedido
	   FROM ecommerce.produto
	   JOIN ecommerce.item_do_pedido
	   ON ecommerce.item_do_pedido.id_produto=
	   ecommerce.produto.id_produto
	   WHERE id_pedido =1;


	   


	   
	   
	   

	   

	   
	   