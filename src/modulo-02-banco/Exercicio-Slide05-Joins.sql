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
Select c.UF, COUNT(1) as Total_Cidades
From   Cidade c
Where  NOT EXISTS (Select 1
                   From   Associado
				   Where  Associado.IDCidade = C.IDCidade)
Group  by c.UF

--Questao 4)
