/*
	SQL - Exercicios Adicionais - SQL joins
*/

use Crescer15_2

select * from Material
select * from PedidoItem
select * from Pedido
select * from ProdutoMaterial
select * from Produto
select * from Cliente
select * from Cidade

--1)  Liste o total de pedidos realizados no mês de setembro de 2015.
select count(DataPedido) as TotalPedidos
from Pedido
where month(DataPedido)=09 and year(DataPedido)=2015

-- 2) Liste todos os clientes que tenham o LTDA no nome ou razao social.
select	Nome,
		RazaoSocial
from Cliente
WHERE exists(select Nome,
			  		 SUBSTRING(Nome, LEN(Nome)-4, LEN(Nome)),
			  		RazaoSocial,
			  		 SUBSTRING(RazaoSocial, LEN(RazaoSocial)-4, LEN(RazaoSocial))
			  From Cliente
			 )

-- 3)Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
SELECT * FROM Produto

Insert into Produto(Nome,PrecoCusto, PrecoVenda,Situacao) Values('Galocha Maragato', 35.67, 77.95, 'A');


/*
4) Identifique e liste os produtos que não tiveram nenhum pedido, considere os relacionamentos no modelo de 
dados, pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
Obs.: o produto criado anteriormente deverá ser listado (apenas este)
*/

select *
from Produto
where not exists(select 1 from PedidoItem where PedidoItem.IDProduto=Produto.IDProduto)

/*
5)  Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de clientes (tabela Cliente), liste 
também qual o Estado possuí o menor número de clientes.
Dica: pode (não é obrigatório) ser utilizado subquery, e também UNION
*/
	select * from
	(select top 1 C.UF as UF, count(Cl.IDCidade) as Maior
	from Cidade as C
	inner join Cliente as Cl on Cl.IDCidade=C.IDCidade
	group by UF
	order by count(Cl.IDCliente) desc)abc
	Union all
	select	*
	from	(select top 1 C.UF as UF, count(C.)



--7) Liste quais os produtos que utilizam o material de IDMaterial = 15836.

select	Prod.Nome,Prod.DataCadastro,
		Prod.PrecoCusto,Prod.PrecoVenda,
		Prod.Situacao
from	Produto as Prod
inner join ProdutoMaterial as ProdMat on ProdMat.IDProduto=Prod.IDProduto
inner join Material as Mat on ProdMat.IDMaterial=Mat.IDMaterial
where Mat.IDMaterial=15836

--9) Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
select	top 1
		SUBSTRING(Nome, 1, CHARINDEX(' ', Nome)) as Primeiro_Nome,
		count(1) as Total_Repeticoes
from	Cliente
group by SUBSTRING(Nome, 1, CHARINDEX(' ', Nome))
Order by COUNT(1) desc;