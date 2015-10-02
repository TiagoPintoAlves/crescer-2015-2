/*
		Exercício 05 - Crescer CWI - Banco de dados - SQL - joins
*/

use CursoSQL

--Questao 1)
select * from Empregado
select * from Departamento

select	e.NomeEmpregado,
		d.NomeDepartamento
from Empregado e
	inner join Departamento d ON e.IDDepartamento = d.IDDepartamento;

--Questao 2)
select * from Associado
select * from Cidade

select	a.Nome as NomeAssociado,
		c.Nome as NomeCidade
from Associado a
	left join Cidade c ON a.IDCidade = c.IDCidade;

--Questao 3)

select	c.UF, Count(1) as TotalCidade 
from Cidade c
where NOT EXISTS (Select 1
				  from Associado a
				  where a.IDCidade = c.IDCidade)
group by c.UF
